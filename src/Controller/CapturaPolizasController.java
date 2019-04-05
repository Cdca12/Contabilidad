package Controller;

import Models.CapturaPolizasModel;
import Models.CuentasModel;
import Views.CapturaPolizasView;
import java.awt.event.*;
import utils.Polizas;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasController implements ActionListener {

    private CapturaPolizasView view;
    private CapturaPolizasModel model;
    private CuentasModel cuentasModel;
    public char tipo;

    public CapturaPolizasController(CapturaPolizasView view, CapturaPolizasModel model, CuentasModel cuentasModel) {
        this.view = view;
        this.model = model;
        this.cuentasModel = cuentasModel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
//        if (!view.validarCampos()) {
//            return;
//        }
        if (evt.getSource() == view.btnCapturar) {
//            if (!cuentasModel.existeCuenta(view.txtCuenta.getText())) {
//                view.mostrarMensaje("No existe ese número de cuenta");
//                return;
//            }
//            if (cuentasModel.estaDadoDeBaja(view.txtCuenta.getText())) {
//                view.mostrarMensaje("No se puede capturar pólizas de una cuenta que está dada de baja");
//            }
            // Añadir a tabla
            view.añadirFilaAsiento();
            view.limpiarCampos();
        }
        if (evt.getSource() == view.rdBtnAbono) {
            tipo = Polizas.ABONO;
            return;
        }
        if (evt.getSource() == view.rdBtnCargo) {
            tipo = Polizas.CARGO;
            return;
        }
        if (evt.getSource() == view.btnGuardar) {
            view.mostrarMensaje("No se puede guardar la póliza");
            return;
        }
    }

}
