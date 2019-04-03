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
        String cuentaAux = cuenta.getCuenta();
        String cuentaPadre = cuentaAux.substring(0, 2);
        String subCuenta = cuentaAux.substring(2, 4);
        String subSubCuenta = cuentaAux.substring(4, 6);
        
        

        // Escribir 
        cuentaDatos.insertarRegistro(cuenta);
    }

    public void obtenerCuenta(String cuenta) {

    }

}
