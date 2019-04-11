package Contabilidad;

import Views.MenuPrincipal;
import Utils.Tema;

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
