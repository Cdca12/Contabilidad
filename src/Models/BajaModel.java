package Models;

import Entities.Cuenta;
import Datos.CuentaDatos;

/**
 *
 * @author Carlos Contreras
 */
public class BajaModel {

    private CuentaDatos cuentaDatos;
    
    public BajaModel() {
        cuentaDatos = new CuentaDatos();
    }

    public boolean darDeBaja(String cuenta) {
        return cuentaDatos.darDeBaja(cuenta);
    }

}
