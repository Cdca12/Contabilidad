package Models;

import Controller.RegistroController;
import Entities.Cuenta;
import DataAccesor.CuentaDataAccesor;
import Entities.Mensaje;

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

        // Escribir 
        cuentaDataAccesor.insertarRegistro(cuenta);
        return true;
    }

    public boolean validarCuenta(String cuenta, Mensaje mensaje) {
        String cuentaPadre = cuenta.substring(0, 2);
        String subCuenta = cuenta.substring(2, 4);
        String subSubCuenta = cuenta.substring(4, 6);

        if (!subSubCuenta.equals("00")) { // Si no es 00 valido, si no, ya que puede ser una subcuenta
            if (!validarSubSubCuenta(cuenta, cuentaPadre + subCuenta)) {
                mensaje.textoMensaje = "La SubSubCuenta no es válida";
                return false;
            }
        }
        if (!subCuenta.equals("00")) {
            if (!validarSubCuenta(cuenta, cuentaPadre)) {
                mensaje.textoMensaje = "La SubCuenta no es válida";
                return false;
            }
        }
        return true;
    }

    public boolean validarSubSubCuenta(String cuenta, String subSubcuenta) {
        String subCuenta = subSubcuenta + "00";
        if (cuentaDataAccesor.busquedaBinaria(subCuenta) != -1 && cuentaDataAccesor.busquedaBinaria(subSubcuenta) == -1) {
            return true;
        }
        return false;
    }

    public boolean validarSubCuenta(String cuenta, String subcuenta) {
        String cuentaAux = subcuenta + "0000";
        if (cuentaDataAccesor.busquedaBinaria(cuentaAux) != -1 && cuentaDataAccesor.busquedaBinaria(subcuenta) == -1) {
            return true;
        }
        return false;
    }

}
