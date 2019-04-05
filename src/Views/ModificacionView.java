package Views;

import Controller.ModificacionController;
import Entities.Cuenta;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class ModificacionView extends JDialog {

    private ModificacionController controller;
    public JLabel lbCuenta, lbNombre;
    public JTextField txtCuenta, txtNombre;
    public JButton btnBuscar, btnGuardar, btnCancelar;

    public ModificacionView() {
        setTitle("Modificación");
        setSize(310, 250);
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

        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 25, 150, 30);
        add(txtCuenta);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 65, 150, 30);
        txtNombre.setEnabled(false);
        add(txtNombre);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(15, 170, 90, 30);
        add(btnBuscar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(btnBuscar.getX() + btnBuscar.getWidth() + 5, 170, 90, 30);
        btnGuardar.setEnabled(false);
        add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(btnGuardar.getX() + btnGuardar.getWidth() + 5, 170, 90, 30);
        add(btnCancelar);

    }

    public void setController(ModificacionController controller) {
        this.controller = controller;
        btnBuscar.addActionListener(controller);
        btnGuardar.addActionListener(controller);
        btnCancelar.addActionListener(controller);
    }

    public void lanzarVista() {
        setVisible(true);
    }

    public void mostrarMensaje(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }

    public void habilitarEdicion(Cuenta cuenta) {
        btnGuardar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtNombre.setText(cuenta.getNombre().trim());
        txtNombre.requestFocus();
    }

    public void limpiarCampos() {
        btnGuardar.setEnabled(false);
        txtNombre.setText("");
        txtCuenta.requestFocus();
        txtCuenta.setText("");
    }

}
