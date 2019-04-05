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

    public ConsultaView() {
        setTitle("Consulta");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    public void setController(ConsultaController controller) {
        this.controller = controller;
    }

    public void lanzarVista() {
        generarTabla();
        setVisible(true);
    }

    public void generarTabla() {
        String[] nombreColumnas = {"Cuenta", "Nombre", "Saldo", "Cargo", "Abono", "Status"};
        Vector<String> vectorNombreColumnas = new Vector<>(Arrays.asList(nombreColumnas));
        Vector<Vector<String>> datosTablaCuentas = controller.obtenerDatosTablaCuentas();
        
        tablaResultados = new JTable(datosTablaCuentas, vectorNombreColumnas);
        scrollPane = new JScrollPane(tablaResultados);
        scrollPane.setBounds(10, 10, 475, 300);
        add(scrollPane);
    }
}
