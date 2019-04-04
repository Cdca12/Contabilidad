package Models;

import Entities.Cuenta;
import Datos.CuentaDatos;

/**
 *
 * @author Carlos Contreras
 */
public class BajaModel {
    
    CuentaDatos cuentaDatos;
    
    public boolean existeCuenta(String cuenta) {
        return cuentaDatos.existeCuenta(cuenta);
    }
    
    public Cuenta obtenerCuenta(String cuenta) {
        return cuentaDatos.obtenerCuenta(cuenta);
    }
    
    public boolean darDeBaja(String cuenta) {
        System.out.println("Se dio de baja");
        return cuentaDatos.darDeBaja(cuenta);
    }
    
}
