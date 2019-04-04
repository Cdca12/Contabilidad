package Entities;

/**
 *
 * @author Carlos Contreras
 */
public class Cuenta {

    private String cuenta;
    private String nombre;
    private float saldo;
    private float cargo;
    private float abono;
    private char status;


    public Cuenta(String cuenta, String nombre, float saldo, float cargo, float abono, char status) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.saldo = saldo;
        this.cargo = cargo;
        this.abono = abono;
        this.status = status;
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

    public float getCargo() {
        return cargo;
    }

    public void setCargo(float cargo) {
        this.cargo = cargo;
    }

    public float getAbono() {
        return abono;
    }

    public void setAbono(float abono) {
        this.abono = abono;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    

}
