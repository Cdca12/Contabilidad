package Controller;

import Models.BajaModel;
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

    public BajaController(BajaView view, BajaModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (view.btnBuscar == evt.getSource()) {
            if (view.txtCuenta.getText().length() != 6) {
                view.mostrarMensajeError("Favor de insertar un número de cuenta");
                return;
            }
            if (!model.existeCuenta(view.txtCuenta.getText())) {
                view.mostrarMensajeError("No existe ese número de cuenta");
                return;
            }
            view.btnBaja.setEnabled(true);
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
            JOptionPane.showMessageDialog(view, "La cuenta ha sido dada de baja correctamente");
            // Mensaje que diga "La Cuenta se ha dado de baja correctamente" (? Fuera cambiar de JDialog a JFrame
            return;
        }
        if (view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }

}
