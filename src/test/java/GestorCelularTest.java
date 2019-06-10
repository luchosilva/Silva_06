import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Luis Silva
 */

public class GestorCelularTest {

    GestorCelular gC;
    String ubicacionTexto;

    @Before
    public void setUp(){
        gC = new GestorCelular();
        ubicacionTexto="celulares.csv";
    }

    /*
    Se quiere almacenar las líneas de un texto que no existe.
    */
    @Test
    public void testAlmacenarLineasTexto() throws IOException{
        boolean resultadoConseguido =gC.extraerTexto("noExisto.txt",gC.contarLineas("noExisto.txt"));
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado,resultadoConseguido);
    }

    /*
    Se quiere almacenar las líneas de un texto en blanco.
    */
    @Test
    public void testAlmacenarLineasTexto2() throws IOException{
        boolean resultadoConseguido =gC.extraerTexto("sinLineas.txt",gC.contarLineas("sinLineas.txt"));
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado,resultadoConseguido);
    }

    /*
    Se quieren contar las lineas de un texto en blanco.
    */
    @Test
    public void testContarLineas() throws IOException {
        int resultadoConseguido = gC.contarLineas("sinLineas.txt");
        int resultadoEsperado = -1;
        assertEquals(resultadoEsperado,resultadoConseguido);
    }

    /*
    Se quiere separar el texto extraído que se encuentra en una posición negativa.
    */
    @Test
    public void testSepararLineas(){
        String[] resultadoConseguido = gC.separarLineas(-1);
        String[] resultadoEsperado = {null,null,null};
        Assert.assertArrayEquals(resultadoEsperado,resultadoConseguido);
    }

    /*
    Se quiere separar el texto extraído que se encuentra en una posición nula.
    */
    @Test
    public void testSepararLineas2(){
        String[] resultadoConseguido = gC.separarLineas(0);
        String[] resultadoEsperado = {null,null,null};
        Assert.assertArrayEquals(resultadoEsperado,resultadoConseguido);
    }

    /*
    Se quiere crear objetos a partir de un numero de lineas negativo
    */
    @Test
    public void testCrearObjeto() throws IOException{
        boolean resultadoConseguido = gC.crearObjetos(-1);
        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado,resultadoConseguido);
    }
}
