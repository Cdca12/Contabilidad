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

    public Asiento() {
    }
    
    public Asiento(String poliza, String cuenta, char tipo, float importe) {
        this.poliza = poliza;
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.importe = importe;
    }
    
    public Asiento(Asiento asiento) {
        this.poliza = asiento.getPoliza();
        this.cuenta = asiento.getCuenta();
        this.tipo = asiento.getTipo();
        this.importe = asiento.getImporte();
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

}
