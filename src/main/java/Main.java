import java.io.IOException;

public class Main {

    /**
     * OJO: para probar metodos quitar el '//' antes del metodo, y de el interfaz.mostrarArrayList() también, que se encuentra
     * arriba del metodo, para así ver el antes y después de cada método
     */
    public static void main(String[] args) throws IOException {
        GestorCelular interfaz = new GestorCelular();
        //System.out.println(interfaz.contarLineas("celulares.csv")); //funciona
        interfaz.extraerTexto("celulares.csv",interfaz.contarLineas("celulares.csv")); //funciona
        interfaz.crearObjetos(interfaz.contarLineas("celulares.csv")); //funciona
        //interfaz.mostraCelulares();
        //interfaz.mostrarArrayList();
        //interfaz.selectionSortPorPantalla(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.insertionSortPorPantalla(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.ordenamientoAlfabetico(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.ordenAlfabetico(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.ordenamientoNumerico(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.mergeSortPorPantalla(0,interfaz.celulares.size(),interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.selectionSortPorModelo(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.insertionSortPorModelo(interfaz.celulares); //funciona
        //interfaz.mostrarArrayList();
        //interfaz.mergeSortPorModelo(0,interfaz.celulares.size(),interfaz.celulares); //no funciona
        System.out.println("");
        interfaz.mostrarArrayList();
    }

}
