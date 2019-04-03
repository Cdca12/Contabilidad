package Views;

import Controller.RegistroController;
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
    
    public MenuPrincipal() {
        super("Contabilidad");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        barraMenu = new JMenuBar();
        barraMenu.setSize(100, 100);
        setJMenuBar(barraMenu);

        catalogo = new JMenu("Catálogo");
        registro = new JMenuItem("Registro");
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroView();
            }
        });
        modificacion = new JMenuItem("Modificación");
        modificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModificacionView();
            }
        });
        baja = new JMenuItem("Baja");
        baja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BajaView();
            }
        });
        consulta = new JMenuItem("Consulta");
        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultaView();
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
        RegistroView view = new RegistroView();
        RegistroModel model = new RegistroModel();
        RegistroController controller = new RegistroController(model, view);
        view.setController(controller);
        view.lanzarVista();
         // vista
//        new RegistroView();
//        new ModificacionView();
//        new BajaView();
//        new ConsultaView();
    
    }
}