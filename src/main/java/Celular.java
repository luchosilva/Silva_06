/**
 *
 * @author Luis Silva
 */
public class Celular implements Comparable <Celular> {

    private String modelo;
    private double tamañoPantalla;

    public Celular (String modelo, double tamañoPantalla) {
        this.modelo=modelo;
        this.tamañoPantalla=tamañoPantalla;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    @Override
    public int compareTo(Celular celu) {
        return this.modelo.compareToIgnoreCase(celu.modelo);
    }
}
