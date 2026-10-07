package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.registro_cliente;
import view.ventana_vendedor;

public class logic_Rcliente implements ActionListener{
	registro_cliente nñ=new registro_cliente();

	public logic_Rcliente(registro_cliente nñ) {
		super();
		// TODO Auto-generated constructor stub
		this.nñ=nñ;
		this.nñ.btn_cancelar.addActionListener(this);
		this.nñ.btn_registrar.addActionListener(this);
		this.nñ.txt_direccion.addActionListener(this);
		this.nñ.txt_id.addActionListener(this);
		this.nñ.txt_mail.addActionListener(this);
		this.nñ.txt_nombre.addActionListener(this);
		this.nñ.txt_telefono.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nñ.btn_cancelar) {
			ventana_vendedor vv=new ventana_vendedor();
			new controller.logic_vvendedor(vv);
			vv.setVisible(true);
			nñ.dispose();
			
		}else if(e.getSource()==nñ.btn_registrar) {

		    // ============ 1. Obtener datos del formulario ============
		    String idTxt = nñ.txt_id.getText().trim();
		    String nombre = nñ.txt_nombre.getText().trim();
		    String mail = nñ.txt_mail.getText().trim();
		    String celularTxt = nñ.txt_telefono.getText().trim();
		    String address = nñ.txt_direccion.getText().trim();

		    // ============ 2. Validar campos vacíos ============
		    if(idTxt.isEmpty() || nombre.isEmpty() || mail.isEmpty() ||
		       celularTxt.isEmpty() || address.isEmpty()) {

		        javax.swing.JOptionPane.showMessageDialog(null,
		                "Todos los campos son obligatorios.");
		        return;
		    }

		    // ============ 3. Convertir a enteros ============
		    int id = 0;
		    int celular = 0;

		    try {
		        id = Integer.parseInt(idTxt);
		        celular = Integer.parseInt(celularTxt);
		    } catch (NumberFormatException ex) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		                "ID y Celular deben ser números.");
		        return;
		    }

		    // ============ 4. Crear DAO ============
		    model.clienteDAO dao = new model.clienteDAO();

		    // Validar si ID ya existe
		    if(dao.obtenerClientePorID(idTxt) != null) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		                "El ID ingresado ya existe en clientes.txt");
		        return;
		    }

		    // ============ 5. Crear objeto cliente usando su constructor ============
		    model.cliente c = new model.cliente(nombre, mail, address, id, celular);

		    // ============ 6. Registrar cliente en TXT ============
		    if(dao.registrarClienteTXT(c)) {

		        javax.swing.JOptionPane.showMessageDialog(null,
		                "Cliente registrado correctamente.");

		        // limpiar campos
		        nñ.txt_id.setText("");
		        nñ.txt_nombre.setText("");
		        nñ.txt_mail.setText("");
		        nñ.txt_telefono.setText("");
		        nñ.txt_direccion.setText("");

		        // regresar a ventana vendedor
		        ventana_vendedor vv = new ventana_vendedor();
		        new controller.logic_vvendedor(vv);
		        vv.setVisible(true);
		        nñ.dispose();

		    } else {
		        javax.swing.JOptionPane.showMessageDialog(null,
		                "Error: no se pudo registrar el cliente.");
		    }
		}
		}
}
