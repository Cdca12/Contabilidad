package Views;

import Controller.RegistroController;
import Models.Cuenta;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroView extends JDialog {

    public RegistroController controller;
    public JLabel lbCuenta, lbNombre, lbSaldo;
    public JTextField txtCuenta, txtNombre, txtSaldo;
    public JButton btnAñadir, btnCancelar;

    // TODO: Hacer que no se pueda cerrar
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
    
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    public void limpiarCampos() {
        txtCuenta.setText("");
        txtNombre.setText("");
        txtSaldo.setText("");
        txtCuenta.requestFocus();
    }

}
