package Views;

import Controller.ModificacionController;
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

        // TODO: Write code
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

    public void buscarCuenta() {
        txtNombre.setEnabled(true);
        txtNombre.setText(txtCuenta.getText());
        txtNombre.requestFocus();
    }

}
