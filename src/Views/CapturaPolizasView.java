package Views;

import Controller.CapturaPolizasController;
import javax.swing.*;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasView extends JFrame {

    private CapturaPolizasController controller;

    public void setController(CapturaPolizasController controller) {
        this.controller = controller;
        // Escuchadores
    }

    public void lanzarVista() {
        setVisible(true);
    }
}
