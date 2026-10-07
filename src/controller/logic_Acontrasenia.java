package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.trabajadorDAO;
import view.actualizar_contrasenia;

public class logic_Acontrasenia implements ActionListener{
	actualizar_contrasenia jk=new actualizar_contrasenia();

	public logic_Acontrasenia(actualizar_contrasenia jk) {
		super();
		// TODO Auto-generated constructor stub
		this.jk=jk;
		this.jk.btn_actualizar.addActionListener(this);
		this.jk.btn_cancelar.addActionListener(this);
		this.jk.txt_newpass.addActionListener(this);
		this.jk.txt_oldpass.addActionListener(this);
		this.jk.txt_usuario.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jk.btn_actualizar) {

		    // Obtener valores de los JTextField
		    String mail = jk.txt_usuario.getText().trim();
		    String oldPass = jk.txt_oldpass.getText().trim();
		    String newPass = jk.txt_newpass.getText().trim();

		    // Validar campos vacíos
		    if (mail.isEmpty() || oldPass.isEmpty() || newPass.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Complete todos los campos.");
		        return;
		    }

		    // Llamar al DAO
		    trabajadorDAO dao = new trabajadorDAO();

		    boolean actualizado = dao.actualizarCodigoPorMail(mail, oldPass, newPass);

		    if (actualizado) {
		        JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito.");
		        jk.dispose();  // Cerrar ventana
		    }
		}else if(e.getSource()==jk.btn_cancelar) {
			jk.dispose();
		}
		
	}

}
