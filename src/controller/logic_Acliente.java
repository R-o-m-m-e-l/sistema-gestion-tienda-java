package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.cliente;
import model.clienteDAO;
import view.actualizar_cliente;
import view.ventana_admin;

public class logic_Acliente implements ActionListener{
	actualizar_cliente hi =new actualizar_cliente();
	

	public logic_Acliente(actualizar_cliente hi) {
		super();
		// TODO Auto-generated constructor stub
		this.hi=hi;
		this.hi.btn_actualizar.addActionListener(this);
		this.hi.btn_cancelar.addActionListener(this);
		this.hi.txt_celular.addActionListener(this);
		this.hi.txt_direccion.addActionListener(this);
		this.hi.txt_id.addActionListener(this);
		this.hi.txt_mail.addActionListener(this);
		this.hi.txt_nombre.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==hi.btn_actualizar) {

	        try {
	            int id = Integer.parseInt(hi.txt_id.getText().trim());
	            int celular = Integer.parseInt(hi.txt_celular.getText().trim());

	            cliente c = new cliente(
	                    hi.txt_nombre.getText().trim(),
	                    hi.txt_mail.getText().trim(),
	                    hi.txt_direccion.getText().trim(),
	                    id,
	                    celular
	            );

	            clienteDAO dao = new clienteDAO();

	            if (dao.actualizarClienteTXT(c)) {
	                JOptionPane.showMessageDialog(null, "Cliente actualizado");
	            } else {
	                JOptionPane.showMessageDialog(null, "Error al actualizar");
	            }

	            ventana_admin va = new ventana_admin();
	            new controller.logic_vadmin(va);
	            va.setVisible(true);
	            hi.dispose();

	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Datos inválidos");
	        }
		}else if(e.getSource()==hi.btn_cancelar) {
			ventana_admin va = new ventana_admin();
			new controller.logic_vadmin(va);
			va.setVisible(true);
			hi.dispose();
		}
		
	}

}
