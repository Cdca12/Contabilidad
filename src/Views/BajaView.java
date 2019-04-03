package Views;

import Controller.BajaController;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class BajaView extends JDialog {

    private BajaController controller;
    public JLabel lbCuenta;
    public JTextField txtCuenta;
    public JButton btnBuscar, btnBaja, btnCancelar;

    public BajaView() {
        setTitle("Baja");
        setSize(310, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(50, 30, 50, 20);
        add(lbCuenta);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 25, 150, 30);
        add(txtCuenta);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(15, 170, 90, 30);
        add(btnBuscar);

        btnBaja = new JButton("Baja");
        btnBaja.setBounds(btnBuscar.getX() + btnBuscar.getWidth() + 5, 170, 90, 30);
        add(btnBaja);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(btnBaja.getX() + btnBaja.getWidth() + 5, 170, 90, 30);
        add(btnCancelar);

    }

    public void setController(BajaController controller) {
        this.controller = controller;
        btnBuscar.addActionListener(controller);
        btnBaja.addActionListener(controller);
        btnCancelar.addActionListener(controller);

    }

    public void lanzarVista() {
        setVisible(true);
    }

}
