package Controller;

import Models.ModificacionModel;
import Views.ModificacionView;
import java.awt.event.*;

/**
 *
 * @author Carlos Contreras
 */
public class ModificacionController implements ActionListener {

    private ModificacionView view;
    private ModificacionModel model;

    public ModificacionController(ModificacionView view, ModificacionModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (view.btnBuscar == evt.getSource()) {
            // TODO: Buscar
            view.buscarCuenta();
            return;
        }
        if (view.btnGuardar == evt.getSource()) {
            // TODO: Guardar
            return;
        }
        if (view.btnCancelar == evt.getSource()) {
            view.dispose();
            return;
        }
    }

}
