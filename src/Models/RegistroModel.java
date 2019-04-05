package Models;

import Entities.Cuenta;
import DataAccesor.CuentaDataAccesor;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroModel {

    private CuentaDataAccesor cuentaDataAccesor; // Usado para manipular datos, escribir y recuperar del archivo .dat
    public String mensajeError;
 
    public RegistroModel() {
        cuentaDataAccesor = new CuentaDataAccesor();
    }

    public boolean añadirCuenta(Cuenta cuenta) {
        // validar que no exista, etc
        String cuentaAux = cuenta.getCuenta();
        String cuentaPadre = cuentaAux.substring(0, 2);
        String subCuenta = cuentaAux.substring(2, 4);
        String subSubCuenta = cuentaAux.substring(4, 6);
        
        

        // Escribir 
        cuentaDataAccesor.insertarRegistro(cuenta);
        return true;
    }
    
}
