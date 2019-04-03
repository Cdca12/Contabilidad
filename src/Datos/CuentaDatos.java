package Datos;

import Models.Cuenta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class CuentaDatos {

//    final static int VALOR_RENGLON = 40; // int + String + int = 4 + 30+2 + 4 = 40

    RandomAccessFile archivoCuentas, archivoIndex;

    public CuentaDatos() {
        try {
            archivoCuentas = new RandomAccessFile("./src/Files/archivoCuentas.dat", "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Cuentas");
        }
        try {
            archivoIndex = new RandomAccessFile("./src/Files/archivoIndex.dat", "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Index");
        }
    }

    public void insertarRegistro(Cuenta cuenta) {
        try {
            archivoCuentas.seek(archivoCuentas.length()); // Me posiciono a la última posición
            archivoCuentas.writeUTF(Rutinas.PonBlancos(cuenta.getCuenta(), 6)); // 6+2 = 8 bytes
            archivoCuentas.writeUTF(Rutinas.PonBlancos(cuenta.getNombre(), 30)); // 30+2 = 32 bytes

            // Escribir en índice
//            archivoIndex.seek(archivoIndex.length());
//            archivoIndex.writeUTF(Rutinas.PonBlancos(cuenta.getCuenta(), 6));    // 6+2 = 8 bytes
//            archivoIndex.writeLong(archivoCuentas.length() / VALOR_RENGLON);		//8 bytes	
            // MÃ©todo ordenamiento...
        } catch (IOException ex) {
            Logger.getLogger(CuentaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se insertÃ³ cuenta");
    }
}
