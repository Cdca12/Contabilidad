package Views;

import Controller.BajaController;
import Controller.ConsultaController;
import Controller.ModificacionController;
import Controller.RegistroController;
import Models.BajaModel;
import Models.ConsultaModel;
import Models.CuentasModel;
import Models.ModificacionModel;
import Models.RegistroModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Carlos Contreras
 */
public class MenuPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu catalogo, polizas;
    private JMenuItem registro, modificacion, baja, consulta, captura, afectacion;
    private CuentasModel cuentasModel;

    public MenuPrincipal() {
        super("Contabilidad");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cuentasModel = new CuentasModel();

        barraMenu = new JMenuBar();
        barraMenu.setSize(100, 100);
        setJMenuBar(barraMenu);

        catalogo = new JMenu("Catálogo");
        registro = new JMenuItem("Registro");
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuRegistro();
            }
        });
        modificacion = new JMenuItem("Modificación");
        modificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuModificacion();
            }
        });
        baja = new JMenuItem("Baja");
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuBaja();
            }
        });
        consulta = new JMenuItem("Consulta");
        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuConsulta();
            }
        });
        catalogo.add(registro);
        catalogo.add(modificacion);
        catalogo.add(baja);
        catalogo.add(consulta);
        barraMenu.add(catalogo);

        polizas = new JMenu("Pólizas");
        captura = new JMenuItem("Captura");
        afectacion = new JMenuItem("Afectación");
        polizas.add(captura);
        polizas.add(afectacion);
        barraMenu.add(polizas);

        // TODO: Añadir imagen central
        
        setVisible(true);

        // TEST:
//        abrirMenuRegistro();
//        abrirMenuModificacion();
        abrirMenuBaja();
//        abrirMenuConsulta();

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
        ModificacionController controller = new ModificacionController(view, model);
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
        ConsultaController controller = new ConsultaController(view, model);
        view.setController(controller);
        view.lanzarVista();
    }
}
