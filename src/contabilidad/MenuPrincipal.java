package contabilidad;

import javax.swing.*;

/**
 *
 * @author Carlos Contreras
 */
public class MenuPrincipal extends JFrame {

    private JTabbedPane opcionesMenu;
    private JFrame menuRegistro, menuModificacion, menuBaja, menuConsulta;

    public MenuPrincipal() {
        super("Pólizas");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        opcionesMenu = new JTabbedPane();
        add(opcionesMenu);

        opcionesMenu.addTab("Registro", menuRegistro);
        opcionesMenu.addTab("Modificación", menuModificacion);
        opcionesMenu.addTab("Baja", menuBaja);
        opcionesMenu.addTab("Consulta", menuConsulta);

        setVisible(true);
    }
}
