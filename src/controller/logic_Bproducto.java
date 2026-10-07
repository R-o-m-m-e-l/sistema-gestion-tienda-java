package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.buscar_producto;
import view.ventana_bodeguero;

public class logic_Bproducto implements ActionListener{
	buscar_producto qr=new buscar_producto();

	public logic_Bproducto(buscar_producto qr) {
		super();
		// TODO Auto-generated constructor stub
		this.qr=qr;
		this.qr.btn_buscar.addActionListener(this);
		this.qr.btn_cancelar.addActionListener(this);
		this.qr.txt_codigo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==qr.btn_buscar) {

		    String codigo = qr.txt_codigo.getText().trim();
		    if(codigo.isEmpty()) {
		        javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un código");
		        return;
		    }

		    model.productoDAO dao = new model.productoDAO();
		    model.producto p = dao.obtenerProductoPorCodigo(codigo);

		    if(p == null) {
		        javax.swing.JOptionPane.showMessageDialog(null, "Producto no encontrado");
		        return;
		    }

		    // Abrir ventana actualizar y enviar datos
		    view.actualizar_producto ac = new view.actualizar_producto();
		    new controller.logic_Aproducto(ac);

		    ac.txt_codigo.setText(p.getCodigo());
		    ac.txt_producto.setText(p.getProducto());
		    ac.txt_unidades.setText(String.valueOf(p.getUnidades()));
		    ac.txt_precio.setText(String.valueOf(p.getPrecio()));
		    ac.txt_proveedor.setText(p.getProveedor());

		    ac.setVisible(true);
		    qr.dispose();
		}else if(e.getSource()==qr.btn_cancelar) {
			ventana_bodeguero vb=new ventana_bodeguero();
			new controller.logic_vbodeguero(vb);
			vb.setVisible(true);
			qr.dispose();
		}
		
	}

}
