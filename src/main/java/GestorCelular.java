import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Luis Silva
 */
public class GestorCelular {

    private String [] textoExtraido;
    public ArrayList<Celular> celulares = new ArrayList<Celular>();

    /**
     * Este metodo muestra los celulares almacenados.
     * @param
     * @return void
     */
    public void mostraCelulares(){
        for(int i = 0; i < this.celulares.size(); i++){
            System.out.println("Celular "+(i+1)+":" );
            System.out.println("Modelo: "+this.celulares.get(i).getModelo());
            System.out.println("Tamaño pantalla: "+this.celulares.get(i).getTamañoPantalla());
            System.out.println();
        }
    }

    /**
     * Este metodo extrae el texto del csv.
     * @param  ubicacionTexto,numeroDeLineas
     * @return boolean.
     */
    public boolean extraerTexto(String ubicacionTexto, int numeroDeLineas) throws FileNotFoundException, IOException {
        try{
            textoExtraido = new String[numeroDeLineas];
            File file = new File (ubicacionTexto);
            if (file.exists() && numeroDeLineas >= 0){
                FileReader fl = new FileReader(ubicacionTexto);
                BufferedReader br = new BufferedReader(fl);
                while(br.readLine() != null){
                    for(int i = 0; i < numeroDeLineas; i++){
                        textoExtraido[i] = br.readLine();
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }catch(NegativeArraySizeException e){
            System.out.println("El número de líneas introducido no puede ser negativo, ni tampoco 0");
            return false;
        }
    }

    /**
     * Este metodo cuenta la cantidad de lineas del texto.
     * @param  ubicacionTexto
     * @return int
     */
    public int contarLineas (String ubicacionTexto) throws IOException{
        int numeroDeLineas = 0;
        try{
            FileReader fr = new FileReader(ubicacionTexto);
            BufferedReader bf = new BufferedReader(fr);
            while (bf.readLine()!=null) {
                numeroDeLineas++;
            }
            return numeroDeLineas - 1;
        }catch(FileNotFoundException e){
            System.out.println("El archivo ingresado no existe o esta vacío");
            return -1;
        }
    }

    /**
     * Este metodo crea los objetos de tipo Celular desde el Array [] texto.
     * @param  numeroDeLineas
     * @return boolean
     */
    public boolean crearObjetos(int numeroDeLineas){
        if (numeroDeLineas <= 0) {
            System.out.println("el numero de lineas ingresado debe ser mayor que 0");
            return false;
        }else {
            try {
                for (int i = 0; i < numeroDeLineas; i++) {
                    this.celulares.add(new Celular(separarLineas(i)[0], Double.parseDouble(separarLineas(i)[1])));
                }
                return true;
            } catch (Exception e) {
                System.out.println("Ocurrio un error al crear los objetos");
                return false;
            }
        }
    }

    /**
     * Este metodo separa el texto extraido.
     * @param  posicion
     * @return String []
     */
    public String [] separarLineas(int posicion){
        try{
            return textoExtraido[posicion].split(";");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("La posición introducida debe ser positiva y distinta de 0");
            String [] vacio = {null,null,null};
            return vacio;
        }catch(Exception ee){
            System.out.println("La posición introducida debe ser positiva y distinta de 0");
            String [] vacio = {null,null,null};
            return vacio;
        }
    }

    /**
     * Metodo SelectionSort que ordena de menor a mayor el arrraylist celus dependiendo del tamaño de pantalla.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> selectionSortPorPantalla (ArrayList <Celular> celus) {
        for (int i = 0; i < celus.size(); i++) {
            int pos = i;
            for (int j = i; j < celus.size(); j++) {
                if (celus.get(j).getTamañoPantalla() < celus.get(pos).getTamañoPantalla())
                    pos = j;
            }
            Celular celMin = celus.get(pos);
            celus.set(pos, celus.get(i));
            celus.set(i, celMin);
        }
        return celus;
    }

    /**
     * Metodo MergeSort que ordena de menor a mayor el arraylist celus dependiendo del tamaño de la pantalla.
     * @param primero,ultimo,celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> mergeSortPorPantalla (int primero, int ultimo,ArrayList <Celular> celus) {
        int j,i;
        if(ultimo>1) {
            i = ultimo/2;
            j = ultimo-i;
            mergeSortPorPantalla(primero, i,celus);
            mergeSortPorPantalla(primero+i,j,celus);
            merge(primero,i,j,celus);
        }
        return celus;
    }

    /**
     * Este metodo es complemento del metodo mergeSort.
     * @param primero,i,j,celus
     * @return void
     */
    private void merge(int primero, int i, int j,ArrayList <Celular> celus) {
        Celular aux [] = new Celular [i+j];
        int temp=0;
        int temp1=0;
        int temp2=0;
        while (temp1<i && temp2<j) {
            if(celus.get(primero+temp1).getTamañoPantalla() < celus.get(primero+i+temp2).getTamañoPantalla()){
                aux[temp++]=celus.get(primero+(temp1++));
            }else{
                aux[temp++]=celus.get(primero+i+(temp2++));
            }
        }
        while (temp1<i){
            aux[temp++]=celus.get(primero+(temp1++));
        }
        while (temp2<j){
            aux[temp++]=celus.get(primero+i+(temp2++));
        }
        for ( int k=0; k < i+j ; k++){
            if(celus.get(primero+k).getTamañoPantalla()!=aux[k].getTamañoPantalla()) {
                celus.set(primero + k, aux[k]);
            }
        }
    }

    /**
     * Metodo MergeSort que ordena el arraylist celus alfabeticamente.
     * @param primero,ultimo,celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> mergeSortPorModelo (int primero, int ultimo,ArrayList <Celular> celus) {
        int j,i;
        if(ultimo>1) {
            i = ultimo/2;
            j = ultimo-i;
            mergeSortPorModelo(primero, i,celus);
            mergeSortPorModelo(primero+i,j,celus);
            merge2(primero,i,j,celus);
        }
        return celus;
    }

    /**
     * Este metodo es complemento del metodo mergeSort.
     * @param primero,i,j,celus
     * @return void
     */
    private void merge2(int primero, int i, int j,ArrayList <Celular> celus) {
        Celular aux [] = new Celular [i+j];
        int temp=0;
        int temp1=0;
        int temp2=0;
        while (temp1<i && temp2<j) {
            if((celus.get(primero+temp1).getModelo().compareTo(celus.get(primero+i+temp2).getModelo()))>0){
                aux[temp++]=celus.get(primero+(temp1++));
            }else{
                aux[temp++]=celus.get(primero+i+(temp2++));
            }
        }
        while (temp1<i){
            aux[temp++]=celus.get(primero+(temp1++));
        }
        while (temp2<j){
            aux[temp++]=celus.get(primero+i+(temp2++));
        }
        for ( int k=0; k < i+j ; k++){
                celus.set(primero + k, aux[k]);
        }
    }

    /**
     * Este metodo ordena los elementos del arraylist celus alfabeticamente, dependiendo del modelo del celular.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> ordenamientoAlfabetico (ArrayList <Celular> celus){
        Collections.sort(celus, new Comparator<Celular>() {
            public int compare(Celular obj1, Celular obj2) {
                return obj1.getModelo().compareTo(obj2.getModelo());
            }
        });
        return celus;
    }

    public void ordenAlfabetico (ArrayList <Celular> celus) {
        Collections.sort(celus);
    }

    /**
     * Este metodo ordena de menos a mayor dependiendo del tamaño de pantalla de cada celular del arraylist celus.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> ordenamientoNumerico (ArrayList <Celular> celus){
        Collections.sort(celus, new Comparator<Celular>() {
            public int compare(Celular obj1, Celular obj2) {
                return new Double(obj1.getTamañoPantalla()).compareTo(obj2.getTamañoPantalla());
            }
        });
        System.out.println("");
        return celus;
    }

    public void mostrarArrayList (){
        for(Celular temp: this.celulares){
            System.out.println(temp.getModelo()+" , "+temp.getTamañoPantalla());
        }
    }

    /**
     * Metodo insertionSort que ordena el arraylist celus de menor a mayor dependiendo del tamaño de la pantalla del celular.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> insertionSortPorPantalla (ArrayList <Celular> celus) {
        int i, j;
        for (i = 1; i < celus.size(); i++) {
            Celular tmp = celus.get(i);
            j = i;
            while ((j > 0) && (celus.get(j - 1).getTamañoPantalla() > tmp.getTamañoPantalla())) {
                celus.set(j, celus.get(j - 1));
                j--;
            }
            celus.set(j, tmp);
        }
        return celus;
    }

    /**
     * Metodo insertionSort que ordena el arraylist celus alfabeticamente.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> insertionSortPorModelo (ArrayList <Celular> celus) {
        for(int i = 1; i < celus.size(); i++)  {
            Celular key = celus.get(i);
            int j = i - 1;
            while (j >= 0 && key.getModelo().compareTo(celus.get(j).getModelo()) < 0) {
                celus.set(j+1, celus.get(j));
                j--;
            }
            celus.set(j+1, key);
        }
        return celus;
    }

    /**
     * Metodo selectionSort que ordena el arraylist celus alfabeticamente.
     * @param celus
     * @return ArrayList <Celular>
     */
    public ArrayList <Celular> selectionSortPorModelo (ArrayList <Celular> celus) {
        for (int i = 0; i < celus.size(); i++) {
            int pos = i;
            for (int j = i; j < celus.size(); j++) {
                if ( celus.get(j).getModelo().compareTo(celus.get(pos).getModelo()) < 0)
                    pos = j;
            }
            Celular celMin = celus.get(pos);
            celus.set(pos, celus.get(i));
            celus.set(i, celMin);
        }
        return celus;
    }
}
