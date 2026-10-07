package controller;

import view.ventana_inicio;

public class controlador_proyecto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ventana_inicio yz=new ventana_inicio();
		new controller.logic_vInicio(yz);
		yz.setVisible(true);

	}

}
