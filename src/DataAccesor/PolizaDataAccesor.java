package DataAccesor;

import Entities.Asiento;
import java.io.*;
import java.util.Vector;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class PolizaDataAccesor {

    final static int VALOR_RENGLON_POLIZAS = 21; // Longitud cada renglon en las pólizas = 19 bytes

    File filePolizas;
    RandomAccessFile archivoPolizas;

    public PolizaDataAccesor() {
        try {
            filePolizas = new File("./src/Files/archivoPolizas.dat");
            archivoPolizas = new RandomAccessFile(filePolizas, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Pólizas");
        }
    }

    public int totalRegistrosPolizas() {
        try {
            return (int) (archivoPolizas.length() / VALOR_RENGLON_POLIZAS);
        } catch (IOException ex) {
            return 0;
        }
    }
    
    public boolean guardarPoliza(Vector<Asiento> datosAsientos) {
        Asiento asientoActual;
        for (int i = 0; i < datosAsientos.size(); i++) {
            asientoActual = datosAsientos.get(i);
            try {
                archivoPolizas.seek(archivoPolizas.length());
                archivoPolizas.writeUTF(Rutinas.PonBlancos(asientoActual.getPoliza(), 5));
                archivoPolizas.writeUTF(asientoActual.getCuenta());
                archivoPolizas.writeChar(asientoActual.getTipo());
                archivoPolizas.writeFloat(asientoActual.getImporte());
            } catch (IOException ex) {
                return false;
            }
        }
        return true;
    }
    
    public boolean imprimirPolizaTest() {
        Asiento asientoActual;
        System.out.println("Poliza\t\tCuenta\t\tTipo\t\tImporte");
        try {
            int totalRegistros = totalRegistrosPolizas();
            for (int i = 0; i < totalRegistros; i++) {
                asientoActual = new Asiento();
                archivoPolizas.seek(i * VALOR_RENGLON_POLIZAS);
                asientoActual.setPoliza(archivoPolizas.readUTF());
                asientoActual.setCuenta(archivoPolizas.readUTF());
                asientoActual.setTipo(archivoPolizas.readChar());
                asientoActual.setImporte(archivoPolizas.readFloat());
                System.out.println(asientoActual.getPoliza() + "\t\t"
                        + asientoActual.getCuenta() + "\t\t"
                        + asientoActual.getTipo() + "\t\t"
                        + asientoActual.getImporte() + "\t\t");
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
