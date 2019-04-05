package Controller;

import Models.BajaModel;
import Models.CuentasModel;
import Views.BajaView;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Contreras
 */
public class BajaController implements ActionListener {

    private BajaView view;
    private BajaModel model;
    private CuentasModel cuentasModel;

    public BajaController(BajaView view, BajaModel model, CuentasModel cuentasModel) {
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
            view.btnBaja.setEnabled(true);
            view.btnBaja.requestFocus();
            System.out.println("Se encontró");
            return;
        }
        if (view.btnBaja == evt.getSource()) {
            if (!view.confirmarBaja()) {
                return;
            }
            if (!model.darDeBaja(view.txtCuenta.getText())) {
                view.mostrarMensajeError("No se pudo dar de baja");
                return;
            }
            view.txtCuenta.setText("");
            JOptionPane.showMessageDialog(view, "La cuenta ha sido dada de baja correctamente");
            return;
        }
        if (view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }

}
