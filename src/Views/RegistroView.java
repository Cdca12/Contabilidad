package Views;

import Controller.RegistroController;
import Entities.Cuenta;
import javax.swing.*;
import java.awt.event.*;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroView extends JDialog {

    public RegistroController controller;
    public JLabel lbCuenta, lbNombre, lbSaldo;
    public JTextField txtCuenta, txtNombre, txtSaldo;
    public JButton btnAñadir, btnCancelar;

    public RegistroView() {
        setTitle("Registro");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(50, 30, 50, 20);
        add(lbCuenta);

        lbNombre = new JLabel("Nombre");
        lbNombre.setBounds(50, 70, 50, 20);
        add(lbNombre);

        lbSaldo = new JLabel("Saldo");
        lbSaldo.setBounds(50, 110, 50, 20);
        add(lbSaldo);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 25, 150, 30);
        add(txtCuenta);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 65, 150, 30);
        add(txtNombre);

        txtSaldo = new JTextField();
        txtSaldo.setBounds(110, 105, 150, 30);
        add(txtSaldo);

        btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(50, 170, 100, 30);
        add(btnAñadir);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(160, 170, 100, 30);
        add(btnCancelar);
    }

    public void lanzarVista() {
        setVisible(true);
    }

    public void setController(RegistroController controller) {
        this.controller = controller;
        btnAñadir.addActionListener(controller);
        btnCancelar.addActionListener(controller);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtCuenta.setText("");
        txtNombre.setText("");
        txtSaldo.setText("");
        txtCuenta.requestFocus();
    }

    public boolean validarCampos() {
        if (txtCuenta.getText().length() != 6) {
            mostrarMensaje("Favor de ingresar una cuenta de 6 dígitos");
            txtCuenta.requestFocus();
            return false;
        }
        if (!Rutinas.esEntero(txtCuenta.getText())) {
            mostrarMensaje("Favor de ingresar sólo números enteros en el número de cuenta");
            txtCuenta.requestFocus();
            return false;
        }
        if (txtNombre.getText().length() == 0) {
            mostrarMensaje("Favor de ingresar un nombre válido");
            txtNombre.requestFocus();
            return false;
        }
        if (Rutinas.esEntero(txtNombre.getText())) {
            mostrarMensaje("Favor de ingresar sólo letras en el nombre");
            txtNombre.requestFocus();
            return false;
        }
        if (txtSaldo.getText().length() == 0) {
            mostrarMensaje("Favor de ingresar un saldo al usuario");
            txtSaldo.requestFocus();
            return false;
        }
        if (!Rutinas.esEntero(txtSaldo.getText())) {
            mostrarMensaje("Favor de ingresar sólo números en el saldo");
            txtSaldo.requestFocus();
            return false;
        }
        return true;
    }

}
