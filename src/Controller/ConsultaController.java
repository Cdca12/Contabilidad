package Controller;

import Models.ConsultaModel;
import Views.ConsultaView;

/**
 *
 * @author Carlos Contreras
 */
public class ConsultaController {
    
    private ConsultaView view;
    private ConsultaModel model;
    
    public ConsultaController(ConsultaView view, ConsultaModel model) {
        this.view = view;
        this.model = model;
    }
}
