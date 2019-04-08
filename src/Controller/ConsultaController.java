package Controller;

//import Models.ConsultaModel;
import Models.CuentasModel;
import Views.ConsultaView;
import java.util.Vector;

/**
 *
 * @author Carlos Contreras
 */
public class ConsultaController {

    private ConsultaView view;
//    private ConsultaModel model;
    private CuentasModel cuentasModel;

//    public ConsultaController(ConsultaView view, ConsultaModel model, CuentasModel cuentasModel) {
    public ConsultaController(ConsultaView view, CuentasModel cuentasModel) {
        this.view = view;
//        this.model = model;
        this.cuentasModel = cuentasModel;
    }

    public Vector<Vector<String>> obtenerDatosTablaCuentas() {
        return cuentasModel.obtenerDatosTablaCuentas();
    }

}
