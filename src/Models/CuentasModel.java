package Models;

import Datos.CuentaDatos;
import Entities.Cuenta;

/**
 *
 * @author Carlos Contreras
 */
public class CuentasModel {

    private CuentaDatos cuentaDatos; // Usado para manipular datos, escribir y recuperar del archivo .dat
    public String mensajeError;

    public CuentasModel() {
        cuentaDatos = new CuentaDatos();
    }

    public boolean existeCuenta(String cuenta) {
        return cuentaDatos.existeCuenta(cuenta);
    }

    public Cuenta obtenerCuenta(String cuenta) {
        return cuentaDatos.obtenerCuenta(cuenta);
    }
    
    
    
    

}
