package DataAccesor;

import Entities.Asiento;
import java.io.*;
import java.util.Vector;
import Utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class PolizaDataAccesor {

    final static int VALOR_RENGLON_POLIZAS = 23; // Longitud cada renglon en las pólizas = 23 bytes
    private CuentaDataAccesor cuentaDataAccesor;

    File filePolizas;
    RandomAccessFile archivoPolizas;

    public PolizaDataAccesor() {
        cuentaDataAccesor = new CuentaDataAccesor();
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
            try {
                asientoActual = datosAsientos.get(i);
                archivoPolizas.seek(archivoPolizas.length());
                archivoPolizas.writeUTF(Rutinas.PonBlancos(asientoActual.getPoliza(), 5));
                archivoPolizas.writeUTF(asientoActual.getCuenta());
                archivoPolizas.writeChar(asientoActual.getTipo());
                archivoPolizas.writeFloat(asientoActual.getImporte());
                archivoPolizas.writeChar(asientoActual.getEstadoPoliza());
            } catch (IOException ex) {
                return false;
            }
        }
        return true;
    }

    public boolean imprimirPolizaTest() {
        Asiento asientoActual;
        System.out.println("Poliza\t\tCuenta\t\tTipo\t\tImporte\t\tEstadoPoliza");
        int totalRegistros = totalRegistrosPolizas();
        for (int i = 0; i < totalRegistros; i++) {
            try {
                asientoActual = new Asiento();
                archivoPolizas.seek(i * VALOR_RENGLON_POLIZAS);
                asientoActual.setPoliza(archivoPolizas.readUTF());
                asientoActual.setCuenta(archivoPolizas.readUTF());
                asientoActual.setTipo(archivoPolizas.readChar());
                asientoActual.setImporte(archivoPolizas.readFloat());
                asientoActual.setEstadoPoliza(archivoPolizas.readChar());
                System.out.println(asientoActual.getPoliza() + "\t\t"
                        + asientoActual.getCuenta() + "\t\t"
                        + asientoActual.getTipo() + "\t\t"
                        + asientoActual.getImporte() + "\t\t"
                        + asientoActual.getEstadoPoliza());
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean afectarCuentas() {
        Asiento asiento;
        int totalRegistros = totalRegistrosPolizas();
        for (int i = 0; i < totalRegistros; i++) {
            try {
                asiento = new Asiento();
                archivoPolizas.seek(i * VALOR_RENGLON_POLIZAS); // Me posicono antes de la cuenta
                archivoPolizas.readUTF(); // Lee poliza en falso    
                asiento.setCuenta(archivoPolizas.readUTF());
                asiento.setTipo(archivoPolizas.readChar());
                asiento.setImporte(archivoPolizas.readFloat());
                asiento.setEstadoPoliza(archivoPolizas.readChar());

                if (asiento.getEstadoPoliza() == 'Y') {
                    continue;
                }
                archivoPolizas.seek(archivoPolizas.getFilePointer() - 2); // Me posiciono justo antes del estadoPoliza
                archivoPolizas.writeChar('Y');
                cuentaDataAccesor.afectarCuenta(asiento);
            } catch (IOException ex) {
                return false;
            }
        }
        System.out.println("Se afectaron las cuentas");
        return true;
    }

}
