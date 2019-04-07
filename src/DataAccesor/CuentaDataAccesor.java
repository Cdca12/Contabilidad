package DataAccesor;

import Entities.Asiento;
import Entities.Cuenta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class CuentaDataAccesor {

    final static int VALOR_RENGLON_CUENTAS = 44; // Longitud cada renglon en las cuentas= 44 bytes
    final static int VALOR_RENGLON_INDICE = 16; // Longitud cada renglon en el índice = 16 bytes
    final static int VALOR_RENGLON_POLIZAS = 21; // Longitud cada renglon en las pólizas = 19 bytes

    File fileCuentas, fileIndex, filePolizas;
    RandomAccessFile archivoCuentas, archivoIndex, archivoPolizas;

    public CuentaDataAccesor() {
        try {
            fileCuentas = new File("./src/Files/archivoCuentas.dat");
            archivoCuentas = new RandomAccessFile(fileCuentas, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Cuentas");
        }
        try {
            fileIndex = new File("./src/Files/archivoIndex.dat");
            archivoIndex = new RandomAccessFile(fileIndex, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Index");
        }
        try {
            filePolizas = new File("./src/Files/archivoPolizas.dat");
            archivoPolizas = new RandomAccessFile(filePolizas, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de Pólizas");
        }
    }

    public boolean estaDadoDeBaja(String cuenta) {
        int posicion = this.busquedaBinaria(cuenta);
        char c = 0;
        try {
            archivoCuentas.seek(((posicion - 1) * VALOR_RENGLON_CUENTAS) + 42);
            c = archivoCuentas.readChar();
        } catch (IOException ex) {
        }
        return c == 'B' ? true : false;
    }

    public boolean insertarRegistro(Cuenta cuenta) {
        try {
            archivoCuentas.seek(archivoCuentas.length()); // Me posiciono a la última posición
            archivoCuentas.writeUTF(Rutinas.PonBlancos(cuenta.getCuenta(), 6));     // String(6) + length (2)  = 8 bytes
            archivoCuentas.writeUTF(Rutinas.PonBlancos(cuenta.getNombre(), 20));    // String(20) + length(2) = 22 bytes
            archivoCuentas.writeFloat(cuenta.getSaldo());                           // float(4) = 4 bytes
            archivoCuentas.writeFloat(cuenta.getCargo());                           // float(4) = 4 bytes
            archivoCuentas.writeFloat(cuenta.getAbono());                           // float(4) = 4 bytes
            archivoCuentas.writeChar(cuenta.getStatus());                           // char(2) = 2 bytes
            //  Total = 44 bytes
            // Indexar
            archivoIndex.seek(archivoIndex.length());
            archivoIndex.writeUTF(Rutinas.PonBlancos(cuenta.getCuenta(), 6));   // 8 bytes
            archivoIndex.writeLong(archivoCuentas.length() / VALOR_RENGLON_CUENTAS);    // 8 bytes	
            quickSort(1, (int) (archivoIndex.length() / VALOR_RENGLON_INDICE));   // Ordenar indices, como en una bd
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public boolean existeCuenta(String cuenta) {
        return busquedaBinaria(cuenta) == -1 ? false : true;
    }

    public Cuenta obtenerCuenta(String cuenta) {
        int posicion = busquedaBinaria(cuenta);
        Cuenta cuentaEncontrada = null;
        long posicionCuenta;
        float saldo, cargo, abono;
        String cuentaAux;
        String nombre;
        try {
            archivoIndex.seek((posicion - 1) * VALOR_RENGLON_INDICE);
            archivoIndex.readUTF();
            posicionCuenta = archivoIndex.readLong();
            archivoCuentas.seek((posicionCuenta - 1) * VALOR_RENGLON_CUENTAS);
            cuentaAux = archivoCuentas.readUTF();
            nombre = archivoCuentas.readUTF();
            saldo = archivoCuentas.readFloat();
            cargo = archivoCuentas.readFloat();
            abono = archivoCuentas.readFloat();
            char status = archivoCuentas.readChar();
            cuentaEncontrada = new Cuenta(cuentaAux, nombre, saldo, cargo, abono, status);
        } catch (IOException e) {
        }
        return cuentaEncontrada; // Va a regresar la cuenta o null de todas maneras si no la encuentra
    }

    public boolean darDeBaja(String cuenta) {
        int posicion = busquedaBinaria(cuenta);
        try {
            archivoCuentas.seek(((posicion - 1) * VALOR_RENGLON_CUENTAS) + 42);
            archivoCuentas.writeChar('B');
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modificarCuenta(String cuenta, String nombre) {
        int posicion = busquedaBinaria(cuenta);
        long posicionCuenta;
        try {
            archivoIndex.seek((posicion - 1) * VALOR_RENGLON_INDICE);
            archivoIndex.readUTF();
            posicionCuenta = archivoIndex.readLong();
            archivoCuentas.seek((posicionCuenta - 1) * VALOR_RENGLON_CUENTAS);
            archivoCuentas.readUTF();
            archivoCuentas.writeUTF(Rutinas.PonBlancos(nombre, 20)); // Escribe el nuevo nombre
        } catch (IOException e) {
            return false;
        }
        return true;

    }

    public int totalRegistrosCuentas() {
        try {
            return (int) (archivoCuentas.length() / VALOR_RENGLON_CUENTAS);
        } catch (IOException ex) {
            return 0;
        }
    }

    public int totalRegistrosPolizas() {
        try {
            return (int) (archivoPolizas.length() / VALOR_RENGLON_POLIZAS);
        } catch (IOException ex) {
            return 0;
        }
    }

    public Vector<Vector<String>> obtenerDatosTablaCuentas() {
        Vector<Vector<String>> datosTablaCuentas = null;
        Vector<String> cuentaActual;
        try {
            int totalRegistros = totalRegistrosCuentas();
            datosTablaCuentas = new Vector<Vector<String>>();
            for (int i = 0; i < totalRegistros; i++) {
                archivoCuentas.seek(i * VALOR_RENGLON_CUENTAS);
                cuentaActual = new Vector<String>();
                cuentaActual.add(archivoCuentas.readUTF());
                cuentaActual.add(archivoCuentas.readUTF().trim());
                cuentaActual.add(Float.toString(archivoCuentas.readFloat()));
                cuentaActual.add(Float.toString(archivoCuentas.readFloat()));
                cuentaActual.add(Float.toString(archivoCuentas.readFloat()));
                cuentaActual.add(archivoCuentas.readChar() + "");
                datosTablaCuentas.add(cuentaActual);
            }
        } catch (IOException e) {
            return null;
        }
        return datosTablaCuentas;
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

    public int busquedaBinaria(String cuenta) {
        try {
            String cuentaActual;
            int largo = (int) (archivoIndex.length() / VALOR_RENGLON_INDICE), inferior = 1, mitad, superior = largo;
            while (inferior <= superior) {
                mitad = (inferior + superior) / 2;
                archivoIndex.seek((mitad - 1) * VALOR_RENGLON_INDICE);
                cuentaActual = archivoIndex.readUTF();
                if (cuenta.compareTo(cuentaActual) == 0) {
                    return mitad;
                }
                if (cuentaActual.compareTo(cuenta) > 0) {
                    superior = mitad - 1;
                } else {
                    inferior = mitad + 1;
                }
            }
            return -1;
        } catch (IOException e) {
            return -1;
        }

    }

    private void quickSort(int limIzq, int limDer) {
        try {
            int i = limIzq, d = limDer, m = (i + d) / 2;
            archivoIndex.seek((m - 1) * VALOR_RENGLON_INDICE);
            String pivote = archivoIndex.readUTF();
            archivoIndex.seek((i - 1) * VALOR_RENGLON_INDICE);
            String izq = archivoIndex.readUTF();
            archivoIndex.seek((d - 1) * VALOR_RENGLON_INDICE);
            String der = archivoIndex.readUTF();

            do {
                while (izq.compareTo(pivote) < 0 && i < limDer) {
                    i++;
                    archivoIndex.seek((i - 1) * VALOR_RENGLON_INDICE);
                    izq = archivoIndex.readUTF();
                }

                while (pivote.compareTo(der) < 0 && d > limIzq) {
                    d--;
                    archivoIndex.seek((d - 1) * VALOR_RENGLON_INDICE);
                    der = archivoIndex.readUTF();
                }

                if (i <= d) {
                    archivoIndex.seek((d - 1) * VALOR_RENGLON_INDICE);
                    archivoIndex.writeUTF(izq);
                    archivoIndex.writeLong(d);

                    archivoIndex.seek((i - 1) * VALOR_RENGLON_INDICE);
                    archivoIndex.writeUTF(der);
                    archivoIndex.writeLong(i);
                    i++;
                    d--;
                    archivoIndex.seek((i - 1) * VALOR_RENGLON_INDICE);
                    izq = archivoIndex.readUTF();
                    archivoIndex.seek((d - 1) * VALOR_RENGLON_INDICE);
                    der = archivoIndex.readUTF();
                }
            } while (i <= d);

            if (limIzq < d) {
                quickSort(limIzq, d);
            }
            if (i < limDer) {
                quickSort(i, limDer);
            }
        } catch (IOException e) {
            return;
        }
    }
}
