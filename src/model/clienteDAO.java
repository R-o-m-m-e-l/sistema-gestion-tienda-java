package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class clienteDAO {

    private final String RUTA = "textos/clientes.txt";
    private files archivo = new files(RUTA);

    public clienteDAO() {
        new files("textos").create(0);
        archivo.create(1);
    }

    // -------------------------
    // REGISTRAR CLIENTE
    // -------------------------
    public boolean registrarClienteTXT(cliente c) {

        String linea = c.getId() + ";" +
                       c.getNombre() + ";" +
                       c.getMail() + ";" +
                       c.getCelular() + ";" +
                       c.getAddress() + ";";

        try {
            archivo.writerFile(linea, false);
            return true;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir clientes.txt");
            return false;
        }
    }

    // -------------------------
    // OBTENER CLIENTE POR ID
    // -------------------------
    public cliente obtenerClientePorID(String idBuscado) {

        try {
            String contenido = archivo.readerFile();
            String[] lineas = contenido.split("\n");

            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue;

                String datos[] = linea.split(";");

                if (datos[0].equals(idBuscado)) {

                    return new cliente(
                            datos[1],      // nombre
                            datos[2],      // mail
                            datos[4],      // address
                            Integer.parseInt(datos[0]), // id
                            Integer.parseInt(datos[3])  // celular
                    );
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente");
        }

        return null;
    }

    // -------------------------
    // ACTUALIZAR CLIENTE
    // -------------------------
    public boolean actualizarClienteTXT(cliente c) {

        try {
            String contenido = archivo.readerFile();
            String[] lineas = contenido.split("\n");

            List<String> nuevas = new ArrayList<>();

            for (String linea : lineas) {

                if (linea.trim().isEmpty()) continue;

                String datos[] = linea.split(";");

                if (datos[0].equals(String.valueOf(c.getId()))) {

                    // Reemplazar toda la línea
                    String nuevaLinea =
                            c.getId() + ";" +
                            c.getNombre() + ";" +
                            c.getMail() + ";" +
                            c.getCelular() + ";" +
                            c.getAddress() + ";";

                    nuevas.add(nuevaLinea);
                } else {
                    nuevas.add(linea);
                }
            }

            // Escribir todo el archivo de nuevo
            archivo.writerFile("", true); // BORRAR
            for (String l : nuevas) {
                archivo.writerFile(l + "\n", false);
            }

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente");
        }

        return false;
    }
}