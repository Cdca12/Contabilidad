package Models;

import Entities.Cuenta;
import Datos.CuentaDatos;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroModel {

    private CuentaDatos cuentaDatos; // Usado para manipular datos, escribir y recuperar del archivo .dat
    public String mensajeError;
 
    public RegistroModel() {
        cuentaDatos = new CuentaDatos();
    }

    public boolean añadirCuenta(Cuenta cuenta) {
        // validar que no exista, etc
        String cuentaAux = cuenta.getCuenta();
        String cuentaPadre = cuentaAux.substring(0, 2);
        String subCuenta = cuentaAux.substring(2, 4);
        String subSubCuenta = cuentaAux.substring(4, 6);
        
        

        // Escribir 
        cuentaDatos.insertarRegistro(cuenta);
        return true;
    }
    
}
