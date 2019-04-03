package Controller;

import Datos.CuentaDatos;
import Models.Cuenta;
import Models.RegistroModel;
import Views.RegistroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroController implements ActionListener, FocusListener {

    private RegistroModel model;
    private RegistroView view;

    public RegistroController(RegistroModel model, RegistroView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Entra actionPerformed");

        if (evt.getSource() == view.btnAñadir) {
            System.out.println("Entro btnAñadir");
            if (!validarCampos()) {
                return;
            }
            // Validar existencia cuentas
            model.añadirCuenta(new Cuenta(view.txtCuenta.getText(), view.txtNombre.getText(), Float.parseFloat(view.txtSaldo.getText())));
            view.limpiarCampos();
            return;
        }
        if (evt.getSource() == view.btnCancelar) {
            System.out.println("Entro btnCancelar");
            view.dispose();
            return;
        }
    }

    @Override
    public void focusGained(FocusEvent evt) {

    }

    @Override
    public void focusLost(FocusEvent evt) {
//        if (evt.getSource() == view.txtCuenta) {
//            if (view.txtCuenta.getText().length() != 6) {
//                JOptionPane.showMessageDialog(view, "Favor de ingresar una cuenta de 6 dígitos");
//                view.txtCuenta.requestFocus();
//                return;
//            }
//        }
//        if (evt.getSource() == view.txtNombre) {
//            if (view.txtNombre.getText().length() == 0) {
//                JOptionPane.showMessageDialog(view, "Favor de ingresar un nombre válido");
//                view.txtNombre.requestFocus();
//                return;
//            }
//        if (evt.getSource() == view.txtSaldo) {
//            if (view.txtSaldo.getText().length() == 0) {
//                JOptionPane.showMessageDialog(view, "Favor de ingresar un saldo al usuario");
//                view.txtSaldo.requestFocus();
//                return;
//            }
//
//        }
    }

    public boolean validarCampos() {
        if (view.txtCuenta.getText().length() != 6) {
            JOptionPane.showMessageDialog(view, "Favor de ingresar una cuenta de 6 dígitos");
            return false;
        }
        if (view.txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(view, "Favor de ingresar un nombre válido");
            view.txtNombre.requestFocus();
            return false;
        }
        if (view.txtSaldo.getText().length() == 0) {
            JOptionPane.showMessageDialog(view, "Favor de ingresar un saldo al usuario");
            view.txtSaldo.requestFocus();
            return false;
        }
        return true;
    }

}
