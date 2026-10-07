package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.productoDAO;
import view.registrar_producto;
import view.ventana_bodeguero;

public class logic_Rproducto implements ActionListener{
	registrar_producto uv=new registrar_producto();

	public logic_Rproducto(registrar_producto uv) {
		super();
		// TODO Auto-generated constructor stub
		this.uv=uv;
		this.uv.btn_cancelar.addActionListener(this);
		this.uv.btn_reistrar.addActionListener(this);
		this.uv.txt_codigo.addActionListener(this);
		this.uv.txt_precio.addActionListener(this);
		this.uv.txt_producto.addActionListener(this);
		this.uv.txt_provedor.addActionListener(this);
		this.uv.txt_unidades.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==uv.btn_cancelar) {
			ventana_bodeguero vb=new ventana_bodeguero();
			new controller.logic_vbodeguero(vb);
			vb.setVisible(true);
			uv.dispose();
			
		}else if(e.getSource()==uv.btn_reistrar) {

		    // 1. Obtener datos de la vista
		    String codigo = uv.txt_codigo.getText().trim();
		    String nombreProducto = uv.txt_producto.getText().trim();
		    String proveedor = uv.txt_provedor.getText().trim();
		    String unidadesTxt = uv.txt_unidades.getText().trim();
		    String precioTxt = uv.txt_precio.getText().trim();

		    // 2. Validar campos vacíos
		    if(codigo.isEmpty() || nombreProducto.isEmpty() || proveedor.isEmpty() ||
		       unidadesTxt.isEmpty() || precioTxt.isEmpty()) {

		        javax.swing.JOptionPane.showMessageDialog(null, 
		            "Todos los campos son obligatorios.", 
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // 3. Validar que unidades sea entero y precio sea double
		    int unidades;
		    double precio;
		    try {
		        unidades = Integer.parseInt(unidadesTxt);
		        precio = Double.parseDouble(precioTxt);
		    } catch (NumberFormatException ex) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Unidades debe ser número entero y Precio debe ser decimal.",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // 4. Verificar si el código ya existe en productos.txt
		    productoDAO dao = new productoDAO();
		    if (dao.buscarProductoPorCodigo(codigo)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "El código del producto ya está registrado.",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // 5. Crear el objeto producto
		    model.producto p = new model.producto();
		    p.setCodigo(codigo);
		    p.setProducto(nombreProducto);
		    p.setProveedor(proveedor);
		    p.setUnidades(unidades);
		    p.setPrecio(precio);

		    // 6. Registrar en el txt
		    if (dao.registrarProducto(p)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Producto registrado correctamente.",
		            "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

		        // 7. Limpiar campos
		        uv.txt_codigo.setText("");
		        uv.txt_producto.setText("");
		        uv.txt_provedor.setText("");
		        uv.txt_unidades.setText("");
		        uv.txt_precio.setText("");

		    } else {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Error al guardar el producto.",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		    }
		}
		
	}

}
