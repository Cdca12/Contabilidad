package Views;

import Controller.ConsultaController;
import DataAccesor.CuentaDataAccesor;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Contreras
 */
public class ConsultaView extends JDialog {

    private ConsultaController controller;
    private CuentaDataAccesor cuentaDataAccesor;

    private JTable tablaResultados;
    private JScrollPane scrollPane;
    private String[] nombreColumnas;
    private Vector<String> vectorNombreColumnas;

    public ConsultaView() {
        setTitle("Consulta");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        nombreColumnas = new String[]{"Cuenta", "Nombre", "Saldo", "Cargo", "Abono", "Status"};
        vectorNombreColumnas = new Vector<>(Arrays.asList(nombreColumnas));
    }

    public void setController(ConsultaController controller) {
        this.controller = controller;
    }

    public void lanzarVista() {
        generarTabla();
        scrollPane = new JScrollPane(tablaResultados);
        scrollPane.setBounds(10, 10, 475, 300);
        add(scrollPane);
        setVisible(true);
    }

    public void generarTabla() {
        Vector<Vector<String>> datosTablaCuentas = controller.obtenerDatosTablaCuentas();
        tablaResultados = new JTable(datosTablaCuentas, vectorNombreColumnas);
    }

}
