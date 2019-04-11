package Views;

import Controller.CapturaPolizasController;
import java.awt.Font;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import Utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasView extends JDialog {

    private CapturaPolizasController controller;
    public JLabel lbPoliza, lbCuenta, lbImporte, lbTotalAbono, lbTotalCargo, lbBalance;
    public JTextField txtPoliza, txtCuenta, txtImporte, txtTotalAbono, txtTotalCargo, txtBalance;
    public JButton btnCapturar, btnGuardar;
    public JRadioButton rdBtnAbono, rdBtnCargo;
    public ButtonGroup grupoRdBtn;
    public JTable tablaResultados;
    public JScrollPane scrollPane;
    public Vector<Vector<String>> datosTablaPolizas;

    public CapturaPolizasView() {
        setTitle("Captura de pólizas");
        setSize(550, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        lbPoliza = new JLabel("Póliza");
        lbPoliza.setBounds(60, 20, 100, 20);
        add(lbPoliza);

        lbCuenta = new JLabel("Cuenta");
        lbCuenta.setBounds(60, 60, 100, 20);
        add(lbCuenta);

        lbImporte = new JLabel("Importe");
        lbImporte.setBounds(60, 100, 100, 20);
        add(lbImporte);

        txtPoliza = new JTextField();
        txtPoliza.setBounds(120, 15, 150, 30);
        add(txtPoliza);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(120, 55, 150, 30);
        add(txtCuenta);

        txtImporte = new JTextField();
        txtImporte.setBounds(120, 95, 150, 30);
        add(txtImporte);

        rdBtnAbono = new JRadioButton("Abono", true);
        rdBtnCargo = new JRadioButton("Cargo");

        grupoRdBtn = new ButtonGroup();
        grupoRdBtn.add(rdBtnAbono);
        grupoRdBtn.add(rdBtnCargo);

        JPanel panel = new JPanel();

        panel.add(rdBtnAbono);
        panel.add(rdBtnCargo);
        panel.setBounds(255, 20, 300, 30);
        add(panel);

        btnCapturar = new JButton("Capturar");
        btnCapturar.setBounds(360, 55, 100, 30);
        add(btnCapturar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(360, 90, 100, 30);
        add(btnGuardar);

        String[] nombreColumnas = {"Número Poliza", "Cuenta", "Tipo", "Importe"};
        Vector<String> vectorNombreColumnas = new Vector<>(Arrays.asList(nombreColumnas));
        datosTablaPolizas = new Vector<Vector<String>>();

        tablaResultados = new JTable(datosTablaPolizas, vectorNombreColumnas);
        scrollPane = new JScrollPane(tablaResultados);
        scrollPane.setBounds(10, 140, 525, 200);
        add(scrollPane);

        lbTotalAbono = new JLabel("Total Abono");
        lbTotalAbono.setFont(new Font("Arial", Font.BOLD, 12));
        lbTotalAbono.setBounds(15, 345, 100, 20);
        add(lbTotalAbono);

        txtTotalAbono = new JTextField("0");
        txtTotalAbono.setEditable(false);
        txtTotalAbono.setBounds(lbTotalAbono.getX() + 70, 340, 100, 30);
        add(txtTotalAbono);

        lbTotalCargo = new JLabel("Total Cargo");
        lbTotalCargo.setFont(new Font("Arial", Font.BOLD, 12));
        lbTotalCargo.setBounds(200, 345, 100, 20);
        add(lbTotalCargo);

        txtTotalCargo = new JTextField("0");
        txtTotalCargo.setEditable(false);
        txtTotalCargo.setBounds(lbTotalCargo.getX() + 70, 340, 100, 30);
        add(txtTotalCargo);

        lbBalance = new JLabel("Balance");
        lbBalance.setFont(new Font("Arial", Font.BOLD, 12));
        lbBalance.setBounds(385, 345, 100, 20);
        add(lbBalance);

        txtBalance = new JTextField("0");
        txtBalance.setEditable(false);
        txtBalance.setBounds(lbBalance.getX() + 50, 340, 100, 30);
        add(txtBalance);

    }

    public void setController(CapturaPolizasController controller) {
        this.controller = controller;
        this.btnCapturar.addActionListener(controller);
        this.btnGuardar.addActionListener(controller);
        this.rdBtnAbono.addActionListener(controller);
        this.rdBtnCargo.addActionListener(controller);
    }

    public void lanzarVista() {
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtPoliza.setEditable(false);
        txtCuenta.setText("");
        txtImporte.setText("");
        txtCuenta.requestFocus();
    }

    public boolean validarCampos() {
        if (txtPoliza.getText().length() == 0) {
            mostrarMensaje("Favor de ingresar un número de póliza");
            txtPoliza.requestFocus();
            return false;
        }
        if (!Rutinas.esEntero(txtPoliza.getText())) {
            mostrarMensaje("Favor de ingresar un número de póliza numérico");
            txtPoliza.requestFocus();
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
        if (txtImporte.getText().contains("-")) {
            mostrarMensaje("Favor de ingresar solo números positivos en el importe");
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
        tablaResultados.updateUI();
    }

    public Vector<String> obtenerAbonos() {
        Vector<String> vectorAux = new Vector<>();
        for (int i = 0; i < datosTablaPolizas.size(); i++) {
            if (datosTablaPolizas.get(i).get(2).charAt(0) == 'A') {
                vectorAux.add(datosTablaPolizas.get(i).get(3));
            }
        }
        return vectorAux;
    }

    public Vector<String> obtenerCargos() {
        Vector<String> vectorAux = new Vector<>();
        for (int i = 0; i < datosTablaPolizas.size(); i++) {
            if (datosTablaPolizas.get(i).get(2).charAt(0) == 'C') { // Compruebo el Tipo
                vectorAux.add(datosTablaPolizas.get(i).get(3));
            }
        }
        return vectorAux;
    }

    public boolean confirmarGuardarPoliza() {
        return JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar la póliza actual?") == 0 ? true : false;
    }

    public boolean validarPolizaBalanceada() {
        if (!txtBalance.getText().equals("0")) {
            mostrarMensaje("La póliza no está balanceada. No se puede guardar");
            return false;
        }
        return true;
    }

    public void limpiarDatosTabla() {
        datosTablaPolizas.removeAllElements();
        tablaResultados.updateUI();
    }
}
