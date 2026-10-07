package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.cliente;
import model.clienteDAO;
import view.actualizar_cliente;
import view.buscar_cliente;
import view.ventana_admin;

public class logic_Bcliente implements ActionListener{
	buscar_cliente fg =new buscar_cliente();
	

	public logic_Bcliente(buscar_cliente fg) {
		super();
		// TODO Auto-generated constructor stub
		this.fg=fg;
		this.fg.btn_buscar.addActionListener(this);
		this.fg.btn_cancelar.addActionListener(this);
		this.fg.txt_id.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fg.btn_buscar) {

	        String id = fg.txt_id.getText().trim();

	        clienteDAO dao = new clienteDAO();

	        cliente c = dao.obtenerClientePorID(id);

	        if (c == null) {
	            JOptionPane.showMessageDialog(null, "El cliente no existe");
	            return;
	        }

	        // Abrir ventana actualizar
	        actualizar_cliente vista = new actualizar_cliente();
	        logic_Acliente controlador = new logic_Acliente(vista);

	        // Cargar datos
	        vista.txt_id.setText(String.valueOf(c.getId()));
	        vista.txt_nombre.setText(c.getNombre());
	        vista.txt_mail.setText(c.getMail());
	        vista.txt_celular.setText(String.valueOf(c.getCelular()));
	        vista.txt_direccion.setText(c.getAddress());

	        vista.setVisible(true);
	        fg.dispose();
		}else if(e.getSource()==fg.btn_cancelar) {
			ventana_admin va= new ventana_admin();
			new controller.logic_vadmin(va);
			va.setVisible(true);
			fg.dispose();
		}
	}

}
