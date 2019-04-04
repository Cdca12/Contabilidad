package Datos;

import Entities.Cuenta;
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

    final static int VALOR_RENGLON = 44; // Longitud cada renglon = 44 bytes

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
            archivoIndex.writeLong(archivoCuentas.length() / VALOR_RENGLON);    // 8 bytes	
            quickSort(1, (int) (archivoIndex.length() / 16));   // Ordenar indices, como en una bd
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public boolean existeCuenta(String cuenta) {
        int posicion = busquedaBinaria(cuenta);
        return posicion == -1 ? false : true;
    }

    public Cuenta obtenerCuenta(String cuenta) {
        int posicion = busquedaBinaria(cuenta);
        Cuenta cuentaEncontrada = null;
        try {
            archivoIndex.seek((posicion - 1) * 16);
            archivoIndex.readUTF();
            long posicionCuenta = archivoIndex.readLong();
            archivoCuentas.seek((posicionCuenta - 1) * VALOR_RENGLON);
            String cta = archivoCuentas.readUTF(), nombre = archivoCuentas.readUTF();
            float saldo = archivoCuentas.readFloat(), cargo = archivoCuentas.readFloat(), abono = archivoCuentas.readFloat();
            char status = archivoCuentas.readChar();
            cuentaEncontrada = new Cuenta(cta, nombre, saldo, cargo, abono, status);
        } catch (IOException e) {
        }
        return cuentaEncontrada;
        // Va a regresar la cuenta o null de todas maneras si no la encuentra
    }

    public boolean darDeBaja(String cuenta) {
        int posicion = busquedaBinaria(cuenta);
        try {
            archivoCuentas.seek(((posicion - 1) * VALOR_RENGLON) + 42);
            archivoCuentas.writeChar('B');
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int busquedaBinaria(String cuenta) {
        try {
            String cuentaActual;
            int largo = (int) (archivoIndex.length() / 16), inferior = 1, mitad, superior = largo;
            while (inferior <= superior) {
                mitad = (inferior + superior) / 2;
                System.out.println(largo + " " + inferior + " " + superior + " " + mitad);
                archivoIndex.seek((mitad - 1) * 16);
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
            archivoIndex.seek((m - 1) * 16);
            String pivote = archivoIndex.readUTF();
            archivoIndex.seek((i - 1) * 16);
            String izq = archivoIndex.readUTF();
            archivoIndex.seek((d - 1) * 16);
            String der = archivoIndex.readUTF();

            do {
                while (izq.compareTo(pivote) < 0 && i < limDer) {
                    i++;
                    archivoIndex.seek((i - 1) * 16);
                    izq = archivoIndex.readUTF();
                }

                while (pivote.compareTo(der) < 0 && d > limIzq) {
                    d--;
                    archivoIndex.seek((d - 1) * 16);
                    der = archivoIndex.readUTF();
                }

                if (i <= d) {
                    archivoIndex.seek((d - 1) * 16);
                    archivoIndex.writeUTF(izq);
                    archivoIndex.writeLong(d);

                    archivoIndex.seek((i - 1) * 16);
                    archivoIndex.writeUTF(der);
                    archivoIndex.writeLong(i);
                    i++;
                    d--;
                    archivoIndex.seek((i - 1) * 16);
                    izq = archivoIndex.readUTF();
                    archivoIndex.seek((d - 1) * 16);
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
