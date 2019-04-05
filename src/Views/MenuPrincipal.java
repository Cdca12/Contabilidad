package Views;

import Controller.BajaController;
import Controller.CapturaPolizasController;
import Controller.ConsultaController;
import Controller.ModificacionController;
import Controller.RegistroController;
import DataAccesor.CuentaDataAccesor;
import Models.BajaModel;
import Models.CapturaPolizasModel;
import Models.ConsultaModel;
import Models.CuentasModel;
import Models.ModificacionModel;
import Models.RegistroModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class MenuPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu catalogo, polizas, otros;
    private JMenuItem registro, modificacion, baja, consulta, captura, afectacion, limpiar;
    private CuentasModel cuentasModel;
    private JLabel icon;

    public MenuPrincipal() {
        super("Contabilidad");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cuentasModel = new CuentasModel();

        icon = new JLabel(Rutinas.AjustarImagen("./src/Images/icon.png", 550, 300));
        icon.setBounds(getWidth() / 2, getHeight() / 2, 200, 200);
        add(icon);

        barraMenu = new JMenuBar();
        barraMenu.setSize(100, 100);
        setJMenuBar(barraMenu);

        catalogo = new JMenu("Catálogo");
        registro = new JMenuItem("Registro");
        registro.addActionListener(evt -> {
            abrirMenuRegistro(); // ActionListener -> actionPerformed
        });
        modificacion = new JMenuItem("Modificación");
        modificacion.addActionListener(evt -> {
            abrirMenuModificacion();
        });
        baja = new JMenuItem("Baja");
        baja.addActionListener(evt -> {
            abrirMenuBaja();
        });
        consulta = new JMenuItem("Consulta");
        consulta.addActionListener(evt -> {
            abrirMenuConsulta();
        });
        catalogo.add(registro);
        catalogo.add(modificacion);
        catalogo.add(baja);
        catalogo.add(consulta);
        barraMenu.add(catalogo);

        polizas = new JMenu("Pólizas");
        captura = new JMenuItem("Captura de pólizas");
        captura.addActionListener(evt -> {
            abrirMenuCapturaPolizas();
        });
        polizas.add(captura);
        barraMenu.add(polizas);

        otros = new JMenu("Otros");
        limpiar = new JMenuItem("Limpiar archivos");
        limpiar.addActionListener((evt) -> {
            if (cuentasModel.limpiarArchivos()) {
                JOptionPane.showMessageDialog(this, "Los archivos se han limpiado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al intentar limpiar los archivos");
            }
        });
        otros.add(limpiar);
        barraMenu.add(otros);

        setVisible(true);
    }

    public void abrirMenuRegistro() {
        RegistroView view = new RegistroView();
        RegistroModel model = new RegistroModel();
        RegistroController controller = new RegistroController(model, view, cuentasModel);
        view.setController(controller);
        view.lanzarVista();
    }

    public void abrirMenuModificacion() {
        ModificacionView view = new ModificacionView();
        ModificacionModel model = new ModificacionModel();
        ModificacionController controller = new ModificacionController(view, model, cuentasModel);
        view.setController(controller);
        view.lanzarVista();
    }

    public void abrirMenuBaja() {
        BajaView view = new BajaView();
        BajaModel model = new BajaModel();
        BajaController controller = new BajaController(view, model, cuentasModel);
        view.setController(controller);
        view.lanzarVista();
    }

    public void abrirMenuConsulta() {
        ConsultaView view = new ConsultaView();
        ConsultaModel model = new ConsultaModel();
        ConsultaController controller = new ConsultaController(view, model, cuentasModel);
        view.setController(controller);
        view.lanzarVista();
    }

    public void abrirMenuCapturaPolizas() {
        CapturaPolizasView view = new CapturaPolizasView();
        CapturaPolizasModel model = new CapturaPolizasModel();
        CapturaPolizasController controller = new CapturaPolizasController(view, model, cuentasModel);
        view.setController(controller);
        view.lanzarVista();
    }
}
