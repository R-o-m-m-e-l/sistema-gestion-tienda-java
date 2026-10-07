package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class trabajadorDAO {
	private final String RUTA = "textos/trabajadores.txt";
    private files archivo = new files(RUTA);
    private validante validar = new validante();

    public trabajadorDAO() {
        // Crear carpeta y archivo si no existen
        new files("textos").create(0);   // Crear carpeta
        archivo.create(1);               // Crear archivo
    }

    /**
     * MÉTODO 1:
     * Guarda un trabajador en el TXT usando:
     * Mail;código;perfil;nombre;id;teléfono;celular;dirección;fecha;
     */
    public boolean guardarTrabajadorTXT(trabajador t) {
        String linea = t.getMail() + ";" +
                       t.getCodigo() + ";" +
                       t.getPerfil() + ";" +
                       t.getNombre() + ";" +
                       t.getId() + ";" +
                       t.getTelefono() + ";" +
                       t.getCelular() + ";" +
                       t.getAddress() + ";" +
                       t.getFecha() + ";"+"\n";

        try {
            archivo.writerFile(linea, false);  // false → agregar sin borrar
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir el archivo");
            return false;
        }
    }

    /**
     * MÉTODO 2:
     * Cambiar el código (password) de un trabajador
     * - Param 1: mail a buscar
     * - Param 2: código actual
     * - Param 3: nuevo código
     */
    public boolean actualizarCodigoPorMail(String mail, String codigoActual, String nuevoCodigo) {

        try {
            String contenido = archivo.readerFile();
            if (contenido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen registros.");
                return false;
            }

            String[] lineas = contenido.split("\n");
            List<String> nuevasLineas = new ArrayList<>();
            boolean encontrado = false;

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");
                // datos[0] = mail
                // datos[1] = codigo
                
                if (datos[0].equals(mail)) {
                    encontrado = true;

                    if (!datos[1].equals(codigoActual)) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                        return false;
                    }

                    if (!validar.validarPassword(nuevoCodigo)) {
                        JOptionPane.showMessageDialog(null,
                                "El nuevo código no cumple los requisitos.");
                        return false;
                    }

                    // Reemplazar el código
                    datos[1] = nuevoCodigo;
                    linea = String.join(";", datos) + ";";
                }

                nuevasLineas.add(linea);
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                return false;
            }

            // Reescribir el archivo
            FileRewrite(nuevasLineas);

            return true;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer o escribir el archivo.");
            return false;
        }
    }

    /**
     * MÉTODO 3:
     * Retorna el PERFIL de un trabajador si:
     * - mail coincide
     * - código coincide
     */
    public String obtenerPerfilPorMailYCodigo(String mail, String codigo) {

        try {
            String contenido = archivo.readerFile();
            if (contenido.isEmpty()) return null;

            String[] lineas = contenido.split("\n");

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");
                // datos[0] = mail
                // datos[1] = codigo
                // datos[2] = perfil

                if (datos[0].equals(mail)) {
                    if (datos[1].equals(codigo)) {
                        return datos[2];  // PERFIL
                    }
                    return null; // Mail encontrado pero codigo incorrecto
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer archivo.");
        }

        return null; // Mail no encontrado
    }

    /**
     * Método interno para reescribir el archivo completamente
     */
    private void FileRewrite(List<String> lineas) throws IOException {
        // Primero borrar el archivo
        new FileWriter(archivo.getFile().getAbsolutePath(), false).close();

        for (String linea : lineas) {
            archivo.writerFile(linea, false);
        }
    }
}
