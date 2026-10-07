package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.actualizar_contrasenia;
import view.buscar_cliente;
import view.registro_empleado;
import view.ventana_admin;
import view.ventana_inicio;

public class logic_vadmin implements ActionListener{
	ventana_admin cd = new ventana_admin();
	
	public logic_vadmin(ventana_admin cd) {
		super();
		// TODO Auto-generated constructor stub
		this.cd=cd;
		this.cd.btn_actualizar_cliente.addActionListener(this);
		this.cd.btn_actualizar_pass.addActionListener(this);
		this.cd.btn_registrar.addActionListener(this);
		this.cd.btn_regresar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cd.btn_actualizar_cliente) {
			buscar_cliente bc= new buscar_cliente();
			new controller.logic_Bcliente(bc);
			bc.setVisible(true);
			cd.dispose();
			
		}else if(e.getSource()==cd.btn_actualizar_pass) {
			actualizar_contrasenia ac =new actualizar_contrasenia();
			new controller.logic_Acontrasenia(ac);
			ac.setVisible(true);
			
		}else if(e.getSource()==cd.btn_registrar) {
			registro_empleado re=new registro_empleado();
			new controller.logic_Rempleado(re);
			re.setVisible(true);
			cd.dispose();
			
		}else if(e.getSource()==cd.btn_regresar) {
			ventana_inicio vi = new ventana_inicio();
			new controller.logic_vInicio(vi);
			vi.setVisible(true);
			cd.dispose();//cierra ventanas
		}
	}

}
