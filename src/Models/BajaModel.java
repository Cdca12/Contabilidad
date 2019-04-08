package Models;

import DataAccesor.CuentaDataAccesor;

/**
 *
 * @author Carlos Contreras
 */
public class BajaModel {

    private CuentaDataAccesor cuentaDataAccesor;

    public BajaModel() {
        cuentaDataAccesor = new CuentaDataAccesor();
    }

    public boolean darDeBaja(String cuenta) {
        return cuentaDataAccesor.darDeBaja(cuenta);
    }

}
