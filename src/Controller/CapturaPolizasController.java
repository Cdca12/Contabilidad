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
    public char tipo = Polizas.ABONO;

    public CapturaPolizasController(CapturaPolizasView view, CapturaPolizasModel model, CuentasModel cuentasModel) {
        this.view = view;
        this.model = model;
        this.cuentasModel = cuentasModel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == view.btnCapturar) {
            // TODO: Validar que la póliza no exista
            // TEST:
            if (!view.validarCampos()) {
                return;
            }
            if (!model.esSubSubCuenta(view.txtCuenta.getText())) {
                view.mostrarMensaje("La cuenta ingresada no es una SubSubCuenta");
                view.txtCuenta.requestFocus();
                return;
            }
            if (!cuentasModel.existeCuenta(view.txtCuenta.getText())) {
                view.mostrarMensaje("No existe ese número de cuenta");
                return;
            }
            if (cuentasModel.estaDadoDeBaja(view.txtCuenta.getText())) {
                view.mostrarMensaje("No se puede añadir pólizas de una cuenta que está dada de baja");
                return;
            }
            // Añadir a tabla
            view.añadirFilaAsiento();
            view.limpiarCampos();

            // Actualizar las sumatorias
            view.txtTotalAbono.setText(Integer.toString(model.obtenerTotal(view.obtenerAbonos())));
            view.txtTotalCargo.setText(Integer.toString(model.obtenerTotal(view.obtenerCargos())));
            view.txtBalance.setText(Integer.toString(model.obtenerBalance(Integer.parseInt(view.txtTotalAbono.getText()), Integer.parseInt(view.txtTotalCargo.getText()))));
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
//             TEST: Validacion
            if (!view.validarPolizaBalanceada()) {
                view.txtCuenta.requestFocus();
                return;
            }
            if (!view.confirmarGuardarPoliza()) {
                return;
            }
            if (!model.guardarPoliza(view.datosTablaPolizas)) {
                view.mostrarMensaje("No fue posible guardar la póliza");
                return;
            }
            view.limpiarDatosTabla();
            model.imprimirPolizaTest();
            view.mostrarMensaje("La póliza se ha guardado con éxito");
        }
    }

}
