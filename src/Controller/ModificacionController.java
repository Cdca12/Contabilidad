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
                view.mostrarMensajeError("Favor de ingresar una cuenta de 6 dígitos");
                return;
            }
            if (!cuentasModel.existeCuenta(view.txtCuenta.getText())) {
                view.mostrarMensajeError("No existe ese número de cuenta");
                return;
            }
            Cuenta cuentaAux = cuentasModel.obtenerCuenta(view.txtCuenta.getText());
            System.out.println("Se encontró");
            view.habilitarEdicion(cuentaAux);
            return;
        }
        if (view.btnGuardar == evt.getSource()) {
            // TODO: Guardar
            return;
        }
        if (view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }

}
