package Controller;

import Models.BajaModel;
import Views.BajaView;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class BajaController implements ActionListener {
    
    private BajaView view;
    private BajaModel model;
    
    public BajaController(BajaView view, BajaModel model) {
        this.view = view;
        this.model = model;
    }
    

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(view.btnBuscar == evt.getSource()) {
            // TODO: Buscar
            
            return;
        }
        if(view.btnBaja == evt.getSource()) {
            // TODO: Dar de baja
            
            // Mensaje que diga "La Cuenta se ha dado de baja correctamente" (? Fuera cambiar de JDialog a JFrame
            return;
        }
        if(view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }
    
}
