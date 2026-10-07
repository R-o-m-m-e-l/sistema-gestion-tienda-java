package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class productoDAO {

    private final String RUTA = "textos/productos.txt";

    // Constructor: crea carpeta y archivo si no existen
    public productoDAO() {
        try {
            File archivo = new File(RUTA);

            // Crear carpeta si no existe
            if (!archivo.getParentFile().exists()) {
                archivo.getParentFile().mkdirs();
            }

            // Crear archivo si no existe
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error inicializando archivo productos: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // MÉTODO 1: Registrar producto en productos.txt
    // código;producto;unidades;precio;proveedor;
    // ---------------------------------------------------------
    public boolean registrarProducto(producto p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            String linea = p.getCodigo() + ";" +
                           p.getProducto() + ";" +
                           p.getUnidades() + ";" +
                           p.getPrecio() + ";" +
                           p.getProveedor() + ";";

            bw.write(linea);
            bw.newLine();
            return true;

        } catch (IOException e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }

    // ---------------------------------------------------------
    // MÉTODO 2: Buscar código del producto
    // Devuelve TRUE si existe, FALSE si no
    // ---------------------------------------------------------
    public boolean buscarProductoPorCodigo(String codigo) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length > 0) {
                    if (datos[0].equals(codigo)) {
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo productos: " + e.getMessage());
        }

        return false; // No encontrado
    }
    public producto obtenerProductoPorCodigo(String codigo) {

        try(BufferedReader br = new BufferedReader(new FileReader(RUTA))){

            String linea;
            while((linea = br.readLine()) != null){
                String[] d = linea.split(";");

                if(d[0].equals(codigo)){
                    producto p = new producto();
                    p.setCodigo(d[0]);
                    p.setProducto(d[1]);
                    p.setUnidades(Integer.parseInt(d[2]));
                    p.setPrecio(Double.parseDouble(d[3]));
                    p.setProveedor(d[4]);
                    return p;
                }
            }
        } catch(IOException e){
            System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return null;
    }
    public boolean actualizarProducto(producto nuevo) {

        try {

            java.util.List<String> lineas = new java.util.ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(RUTA));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");

                if (d[0].equals(nuevo.getCodigo())) {
                    linea = nuevo.getCodigo() + ";" +
                            nuevo.getProducto() + ";" +
                            nuevo.getUnidades() + ";" +
                            nuevo.getPrecio() + ";" +
                            nuevo.getProveedor() + ";";
                }

                lineas.add(linea);
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA));
            for(String l : lineas){
                bw.write(l);
                bw.newLine();
            }
            bw.close();

            return true;

        } catch (IOException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
}
