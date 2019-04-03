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
        if (evt.getSource() == view.btnBuscar) {
            // TODO: Buscar
            view.buscarCuenta();
            return;
        }
        if (evt.getSource() == view.btnGuardar) {
            // TODO: Guardar
            return;
        }
        if (evt.getSource() == view.btnCancelar) {
            view.dispose();
            return;
        }
    }

}
