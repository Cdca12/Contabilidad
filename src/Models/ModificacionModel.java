package Models;

import DataAccesor.CuentaDataAccesor;
import Entities.Cuenta;

/**
 *
 * @author Carlos Contreras
 */
public class ModificacionModel {

    private CuentaDataAccesor cuentaDataAccesor;

    public ModificacionModel() {
        cuentaDataAccesor = new CuentaDataAccesor();
    }

    public Cuenta obtenerCuenta(String cuenta) {
        return cuentaDataAccesor.obtenerCuenta(cuenta);
    }

    public boolean modificarCuenta(String cuenta, String nombre) {
        return cuentaDataAccesor.modificarCuenta(cuenta, nombre);
    }
}
