package Views;

import Controller.CapturaPolizasController;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasView extends JDialog {

    private CapturaPolizasController controller;
    public JLabel lbPoliza, lbCuenta, lbImporte;
    public JTextField txtPoliza, txtCuenta, txtImporte;
    public JButton btnCapturar, btnGuardar;
    public JRadioButton rdBtnAbono, rdBtnCargo;
    public ButtonGroup grupoRdBtn;
    private JTable tablaResultados;
    private JScrollPane scrollPane;
    private Vector<Vector<String>> datosTablaPolizas;

    public CapturaPolizasView() {
        setTitle("Captura de pólizas");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        lbPoliza = new JLabel("Póliza");
        lbPoliza.setBounds(50, 30, 100, 20);
        add(lbPoliza);

        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(50, 70, 100, 20);
        add(lbCuenta);

        lbImporte = new JLabel("Importe");
        lbImporte.setBounds(50, 110, 100, 20);
        add(lbImporte);

        txtPoliza = new JTextField();
        txtPoliza.setBounds(110, 25, 150, 30);
        add(txtPoliza);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(110, 65, 150, 30);
        add(txtCuenta);

        txtImporte = new JTextField();
        txtImporte.setBounds(110, 105, 150, 30);
        add(txtImporte);

        rdBtnAbono = new JRadioButton("Abono", true);
        rdBtnCargo = new JRadioButton("Cargo");

        grupoRdBtn = new ButtonGroup();
        grupoRdBtn.add(rdBtnAbono);
        grupoRdBtn.add(rdBtnCargo);

        JPanel panel = new JPanel();

        panel.add(rdBtnAbono);
        panel.add(rdBtnCargo);
        panel.setBounds(228, 30, 300, 30);
        add(panel);

        btnCapturar = new JButton("Capturar");
        btnCapturar.setBounds(330, 65, 100, 30);
        add(btnCapturar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(330, 100, 100, 30);
        add(btnGuardar);

        String[] nombreColumnas = {"Número Poliza", "Cuenta", "Tipo", "Importe"};
        Vector<String> vectorNombreColumnas = new Vector<>(Arrays.asList(nombreColumnas));
        datosTablaPolizas = new Vector<Vector<String>>();

        tablaResultados = new JTable(datosTablaPolizas, vectorNombreColumnas);
        scrollPane = new JScrollPane(tablaResultados);
        scrollPane.setBounds(10, 150, 475, 200);
        add(scrollPane);
    }

    public void setController(CapturaPolizasController controller) {
        this.controller = controller;
        this.btnCapturar.addActionListener(controller);
        this.btnGuardar.addActionListener(controller);
    }

    public void lanzarVista() {
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtPoliza.setText("");
        txtCuenta.setText("");
        txtImporte.setText("");
        txtPoliza.requestFocus();
    }

    public boolean validarCampos() {
        if (txtPoliza.getText().length() == 0) {
            mostrarMensaje("Favor de ingresar un número de póliza");
            txtPoliza.requestFocus();
            return false;
        }
        if (!Rutinas.esEntero(txtPoliza.getText())) {
            mostrarMensaje("Favor de ingresar sólo números enteros en el número de póliza");
            txtCuenta.requestFocus();
            return false;
        }
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
        if (txtImporte.getText().length() == 0) {
            mostrarMensaje("Favor de ingresar el importe");
            txtImporte.requestFocus();
            return false;
        }
        if (!Rutinas.esEntero(txtImporte.getText())) {
            mostrarMensaje("Favor de ingresar sólo números en el importe");
            txtImporte.requestFocus();
            return false;
        }
        return true;
    }

    public void añadirFilaAsiento() {
        Vector<String> fila = new Vector<String>();
        fila.add(txtPoliza.getText());
        fila.add(txtCuenta.getText());
        fila.add(controller.tipo + "");
        fila.add(txtImporte.getText());
        datosTablaPolizas.addElement(fila);
        SwingUtilities.updateComponentTreeUI(tablaResultados);
    }
}
