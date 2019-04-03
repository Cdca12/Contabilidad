package Controller;

import Datos.CuentaDatos;
import Models.Cuenta;
import Models.RegistroModel;
import Views.RegistroView;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroController implements ActionListener {

    private RegistroModel model;
    private RegistroView view;

    public RegistroController(RegistroModel model, RegistroView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == view.btnAñadir) {
            if (!validarCampos()) {
                return;
            }
            // Validar existencia cuentas
            model.añadirCuenta(new Cuenta(
                    view.txtCuenta.getText(),
                    view.txtNombre.getText(),
                    Float.parseFloat(view.txtSaldo.getText()),
                    0f, 0f, 'A'
            ));
            view.limpiarCampos();
            return;
        }
        if (evt.getSource() == view.btnCancelar) {
            view.dispose();
            return;
        }
    }

    public boolean validarCampos() {
        if (view.txtCuenta.getText().length() != 6) {
            view.mostrarMensajeError("Favor de ingresar una cuenta de 6 dígitos");
            view.txtCuenta.requestFocus();
            return false;
        }
        if (view.txtNombre.getText().length() == 0) {
            view.mostrarMensajeError("Favor de ingresar un nombre válido");
            view.txtNombre.requestFocus();
            return false;
        }
        if (view.txtSaldo.getText().length() == 0) {
            view.mostrarMensajeError("Favor de ingresar un saldo al usuario");
            view.txtSaldo.requestFocus();
            return false;
        }
        return true;
    }

}
