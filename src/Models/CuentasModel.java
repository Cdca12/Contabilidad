package Models;

import DataAccesor.CuentaDataAccesor;
import Entities.Cuenta;
import java.util.Vector;

/**
 *
 * @author Carlos Contreras
 */
public class CuentasModel {

    private CuentaDataAccesor cuentaDataAccesor; // Usado para manipular datos, escribir y recuperar del archivo .dat

    public CuentasModel() {
        cuentaDataAccesor = new CuentaDataAccesor();
    }

    public boolean existeCuenta(String cuenta) {
        return cuentaDataAccesor.existeCuenta(cuenta);
    }

    public boolean estaDadoDeBaja(String cuenta) {
        return cuentaDataAccesor.estaDadoDeBaja(cuenta);
    }

    public Cuenta obtenerCuenta(String cuenta) {
        return cuentaDataAccesor.obtenerCuenta(cuenta);
    }

    public Vector<Vector<String>> obtenerDatosTablaCuentas() {
        return cuentaDataAccesor.obtenerDatosTablaCuentas();
    }

}
