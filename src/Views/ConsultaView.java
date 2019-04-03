package Views;

import Controller.ConsultaController;
import javax.swing.*;
/**
 *
 * @author Carlos Contreras
 */
public class ConsultaView extends JDialog {

    private ConsultaController controller;

    public ConsultaView() {
        setTitle("Consulta");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        
        // TODO: Write code
    }
    
    public void setController(ConsultaController controller) {
        this.controller = controller;
        // Escuchadores
    }
    
    
    
    public void lanzarVista() {
        setVisible(true);
    }
}
