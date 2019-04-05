package Controller;

import Entities.Cuenta;
import Models.CuentasModel;
import Models.ModificacionModel;
import Views.ModificacionView;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class ModificacionController implements ActionListener {

    private ModificacionView view;
    private ModificacionModel model;
    private CuentasModel cuentasModel;

    public ModificacionController(ModificacionView view, ModificacionModel model, CuentasModel cuentasModel) {
        this.view = view;
        this.model = model;
        this.cuentasModel = cuentasModel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (view.btnBuscar == evt.getSource()) {
            if (view.txtCuenta.getText().length() != 6) {
                view.mostrarMensaje("Favor de ingresar una cuenta de 6 dígitos");
                return;
            }
            if (!cuentasModel.existeCuenta(view.txtCuenta.getText())) {
                view.mostrarMensaje("No existe ese número de cuenta");
                return;
            }
            Cuenta cuentaAux = cuentasModel.obtenerCuenta(view.txtCuenta.getText());
            if (cuentaAux == null) {
                view.mostrarMensaje("No se pudo obtener la cuenta");
                return;
            }
            System.out.println("Se encontró");
            view.habilitarEdicion(cuentaAux);
            return;
        }
        if (view.btnGuardar == evt.getSource()) {
            if (!model.modificarCuenta(view.txtCuenta.getText(), view.txtNombre.getText())) {
                view.mostrarMensaje("No fue posible modificar la cuenta");
                return;
            }
            view.mostrarMensaje("La cuenta ha se ha modificado correctamente");
            view.limpiarCampos();
            return;
        }
        if (view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }

}
