package Models;

import Datos.CuentaDatos;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroModel {

    private CuentaDatos cuentaDatos; // Usado para manipular datos, escribir y recuperar del archivo .dat
 
    public RegistroModel() {
        cuentaDatos = new CuentaDatos();
    }

    public void añadirCuenta(Cuenta cuenta) {
        // validar que no exista, etc

        // Escribir 
        cuentaDatos.insertarRegistro(cuenta);
    }

    public void obtenerCuenta(String cuenta) {

    }

}
