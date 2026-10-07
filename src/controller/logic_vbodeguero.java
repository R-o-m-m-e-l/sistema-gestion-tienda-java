package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.actualizar_contrasenia;
import view.buscar_producto;
import view.registrar_producto;
import view.registrar_proveedor;
import view.ventana_bodeguero;
import view.ventana_inicio;

public class logic_vbodeguero implements ActionListener{
	ventana_bodeguero op=new ventana_bodeguero();
	
	public logic_vbodeguero(ventana_bodeguero op) {
		super();
		// TODO Auto-generated constructor stub
		this.op=op;
		this.op.btn_actualizarcontrasenia.addActionListener(this);
		this.op.btn_actualizarproducto.addActionListener(this);
		this.op.btn_registrarproducro.addActionListener(this);
		this.op.btn_registroproveedor.addActionListener(this);
		this.op.btn_regersar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==op.btn_actualizarcontrasenia) {
			actualizar_contrasenia ac=new actualizar_contrasenia();
			new controller.logic_Acontrasenia(ac);
			ac.setVisible(true);
			
		}else if(e.getSource()==op.btn_actualizarproducto) {
			buscar_producto bp=new buscar_producto();
			new controller.logic_Bproducto(bp);
			bp.setVisible(true);
			op.dispose();
		}else if(e.getSource()==op.btn_registrarproducro) {
			registrar_producto rp=new registrar_producto();
			new controller.logic_Rproducto(rp);
			rp.setVisible(true);
			op.dispose();
		}else if(e.getSource()==op.btn_registroproveedor) {
			registrar_proveedor rpv=new registrar_proveedor();
			new controller.logic_Rproveedor(rpv);
			rpv.setVisible(true);
			op.dispose();
		}else if(e.getSource()==op.btn_regersar) {
			ventana_inicio vi=new ventana_inicio();
			new controller.logic_vInicio(vi);
			vi.setVisible(true);
			op.dispose();
		}
		
	}

}
