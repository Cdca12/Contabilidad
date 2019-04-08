package contabilidad;

import Views.MenuPrincipal;
import utils.Tema;

/**
 *
 * @author Carlos Contreras
 */
public class Main {

    public static void main(String[] args) {
        Tema.cambiarTema();
        new MenuPrincipal();
    }

}
