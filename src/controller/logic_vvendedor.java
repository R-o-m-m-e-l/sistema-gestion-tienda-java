package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.actualizar_contrasenia;
import view.registro_cliente;
import view.ventana_inicio;
import view.ventana_vendedor;

public class logic_vvendedor implements ActionListener{
	ventana_vendedor lm = new ventana_vendedor();

	public logic_vvendedor(ventana_vendedor lm) {
		super();
		// TODO Auto-generated constructor stub
		this.lm=lm;
		this.lm.btn_actualizarcontrasenia.addActionListener(this);
		this.lm.btn_registrarcliente.addActionListener(this);
		this.lm.btn_regresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lm.btn_actualizarcontrasenia) {
			actualizar_contrasenia ac=new actualizar_contrasenia();
			new controller.logic_Acontrasenia(ac);
			ac.setVisible(true);
			
		}else if(e.getSource()==lm.btn_registrarcliente) {
			registro_cliente rc=new registro_cliente();
			new controller.logic_Rcliente(rc);
			rc.setVisible(true);
			lm.dispose();
			
		}else if(e.getSource()==lm.btn_regresar) {
			ventana_inicio vi=new ventana_inicio();
			new controller.logic_vInicio(vi);
			vi.setVisible(true);
			lm.dispose();
		}
		
	}

}
