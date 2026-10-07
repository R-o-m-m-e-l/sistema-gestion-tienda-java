package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class proveedorDAO {
	 private final String RUTA = "textos/proveedores.txt"; 
	    // Ajusta la ruta si la tienes en una carpeta específica

	    // ---------------------------------------------------------
	    // MÉTODO: Registrar proveedor en proveedores.txt
	    // Los datos se guardan separados por ; y terminan con ;
	    // ---------------------------------------------------------
	    public boolean registrarProveedor(proveedor p) {

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

	            // Puedes cambiar el orden si lo deseas
	            String linea = p.getCodigo() + ";" +
	                           p.getRazon_social() + ";" +
	                           p.getContacto() + ";" +
	                           p.getMail() + ";" +
	                           p.getTelefono() + ";";

	            bw.write(linea);
	            bw.newLine();

	            return true;

	        } catch (IOException e) {
	            System.out.println("Error al registrar proveedor: " + e.getMessage());
	            return false;
	        }
	    }
}
