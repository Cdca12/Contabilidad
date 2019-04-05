package Controller;

import Models.CapturaPolizasModel;
import Models.CuentasModel;
import Views.CapturaPolizasView;

/**
 *
 * @author Carlos Contreras
 */
public class CapturaPolizasController {

    private CapturaPolizasView view;
    private CapturaPolizasModel model;
    private CuentasModel cuentasModel;

    public CapturaPolizasController(CapturaPolizasView view, CapturaPolizasModel model, CuentasModel cuentasModel) {
        this.view = view;
        this.model = model;
        this.cuentasModel = cuentasModel;
    }

}
