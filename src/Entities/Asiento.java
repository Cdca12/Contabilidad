package Entities;

/**
 *
 * @author Carlos Contreras
 */
public class Asiento {

    private String poliza;
    private String cuenta;
    private char tipo;
    private float importe;
    private char estadoPoliza;

    public Asiento() {
    }

    public Asiento(String poliza, String cuenta, char tipo, float importe, char estadoPoliza) {
        this.poliza = poliza;
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.importe = importe;
        this.estadoPoliza = estadoPoliza;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public char getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(char estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

}
