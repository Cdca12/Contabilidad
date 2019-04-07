package Models;

import DataAccesor.CuentaDataAccesor;
import Entities.Asiento;
import java.util.Vector;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasModel {

    private CuentaDataAccesor cuentaDataAccesor;

    public CapturaPolizasModel() {
        this.cuentaDataAccesor = new CuentaDataAccesor();
    }

    public boolean esSubSubCuenta(String cuenta) {
        return !cuenta.substring(4, 6).equals("00");
    }

    public int obtenerTotal(Vector<String> importes) {
        int total = 0;
        for (int i = 0; i < importes.size(); i++) {
            total += Integer.parseInt(importes.get(i));
        }
        return total;
    }

    public int obtenerBalance(int totalAbono, int totalCargo) {
        return totalAbono - totalCargo;
    }

    public Vector<Asiento> convertirAAsientos(Vector<Vector<String>> datosTablaPolizas) {
        Vector<Asiento> datosAsientos = new Vector();
        Asiento asientoActual = new Asiento();
        for (int i = 0; i < datosTablaPolizas.size(); i++) {
            asientoActual.setPoliza(datosTablaPolizas.get(i).get(0));
            asientoActual.setCuenta(datosTablaPolizas.get(i).get(1));
            asientoActual.setTipo(datosTablaPolizas.get(i).get(2).charAt(0));
            asientoActual.setImporte(Float.parseFloat(datosTablaPolizas.get(i).get(3)));
            datosAsientos.add(asientoActual);
        }
        return datosAsientos;
    }

    public boolean guardarPoliza(Vector<Vector<String>> datosTablaPolizas) {
        Vector<Asiento> datosAsientos = convertirAAsientos(datosTablaPolizas);
        return cuentaDataAccesor.guardarPoliza(datosAsientos);
    }
    
    public boolean imprimirPolizaTest() {
        return cuentaDataAccesor.imprimirPolizaTest();
    }
}
