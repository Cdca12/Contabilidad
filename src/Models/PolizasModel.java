package Models;

import DataAccesor.PolizaDataAccesor;

/**
 *
 * @author Carlos Contreras
 */
public class PolizasModel {

    public PolizaDataAccesor polizaDataAccesor;

    public PolizasModel() {
        this.polizaDataAccesor = new PolizaDataAccesor();
    }

    public boolean afectarCuentas() {
        return polizaDataAccesor.afectarCuentas();
    }

    public int obtenerTotalPolizas() {
        return polizaDataAccesor.totalRegistrosPolizas();
    }

}
