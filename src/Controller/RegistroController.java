package Controller;

import DataAccesor.CuentaDataAccesor;
import Entities.Cuenta;
import Entities.Mensaje;
import Models.CuentasModel;
import Models.RegistroModel;
import Views.RegistroView;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Contreras
 */
public class RegistroController implements ActionListener {

    private RegistroModel model;
    private RegistroView view;
    private CuentasModel cuentasModel;

    public RegistroController(RegistroModel model, RegistroView view, CuentasModel cuentasModel) {
        this.model = model;
        this.view = view;
        this.cuentasModel = cuentasModel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == view.btnAñadir) {
            if (!view.validarCampos()) {
                return;
            }
            // Validar existencia cuentas
            if (cuentasModel.existeCuenta(view.txtCuenta.getText())) {
                view.mostrarMensaje("Ya existe ese número de cuenta");
                return;
            }
            
            Mensaje mensaje = new Mensaje(); // Modelo un mensaje para error específico
            if (!model.validarCuenta(view.txtCuenta.getText(), mensaje)) {
                view.mostrarMensaje(mensaje.textoMensaje);
                return;
            }
            model.añadirCuenta(new Cuenta(view.txtCuenta.getText(), view.txtNombre.getText(), Float.parseFloat(view.txtSaldo.getText()), 0f, 0f, 'A'));
            view.mostrarMensaje("La cuenta se ha añadido con éxito");
            view.limpiarCampos();
            return;
        }
        if (evt.getSource() == view.btnCancelar) {
            view.dispose();
            return;
        }
    }
    
    

}
