package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.actualizar_producto;
import view.ventana_bodeguero;

public class logic_Aproducto implements ActionListener{
	actualizar_producto st=new actualizar_producto();

	public logic_Aproducto(actualizar_producto qr) {
		super();
		// TODO Auto-generated constructor stub
		this.st=qr;
		this.st.btn_actializar.addActionListener(this);
		this.st.btn_cancelar.addActionListener(this);
		this.st.txt_codigo.addActionListener(this);
		this.st.txt_precio.addActionListener(this);
		this.st.txt_producto.addActionListener(this);
		this.st.txt_proveedor.addActionListener(this);
		this.st.txt_unidades.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==st.btn_actializar) {

		    model.producto p = new model.producto();

		    p.setCodigo(st.txt_codigo.getText().trim());
		    p.setProducto(st.txt_producto.getText().trim());
		    p.setUnidades(Integer.parseInt(st.txt_unidades.getText().trim()));
		    p.setPrecio(Double.parseDouble(st.txt_precio.getText().trim()));
		    p.setProveedor(st.txt_proveedor.getText().trim());

		    model.productoDAO dao = new model.productoDAO();

		    if(dao.actualizarProducto(p)) {
		        javax.swing.JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
		    } else {
		        javax.swing.JOptionPane.showMessageDialog(null, "Error al actualizar");
		    }
		
		}else if(e.getSource()==st.btn_cancelar) {
			ventana_bodeguero vb=new ventana_bodeguero();
			new controller.logic_vbodeguero(vb);
			vb.setVisible(true);
			st.dispose();
		}
	}

}

