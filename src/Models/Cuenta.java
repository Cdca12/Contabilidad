package Models;

/**
 *
 * @author Carlos Contreras
 */
public class Cuenta {
    
    private String cuenta;
    private String nombre;
    private float saldo;
    
    public Cuenta(String cuenta, String nombre, float saldo) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    
    
}
