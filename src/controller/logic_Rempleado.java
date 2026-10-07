package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.registro_empleado;
import view.ventana_admin;

public class logic_Rempleado implements ActionListener{
	registro_empleado de =new registro_empleado();
	

	public logic_Rempleado(registro_empleado de) {
		super();
		// TODO Auto-generated constructor stub
		this.de=de;
		this.de.btn_cancerlar.addActionListener(this);
		this.de.btn_registrar.addActionListener(this);
		this.de.txt_celular.addActionListener(this);
		this.de.txt_direccion.addActionListener(this);
		this.de.txt_fecha.addActionListener(this);
		this.de.txt_id.addActionListener(this);
		this.de.txt_mail.addActionListener(this);
		this.de.txt_nombres.addActionListener(this);
		this.de.txt_tlc.addActionListener(this);
		this.de.comboBox.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==de.btn_cancerlar) {
			ventana_admin va=new ventana_admin();
			new controller.logic_vadmin(va);
			va.setVisible(true);
			de.dispose();
			
		}else if(e.getSource()==de.btn_registrar) {
		    // 1. Validar que no haya campos vacíos
		    if (de.txt_nombres.getText().isEmpty() || de.txt_id.getText().isEmpty() ||
		        de.txt_mail.getText().isEmpty() || de.txt_tlc.getText().isEmpty() ||
		        de.txt_celular.getText().isEmpty() || de.txt_direccion.getText().isEmpty() ||
		        de.txt_fecha.getText().isEmpty() || de.comboBox.getSelectedIndex() == 0) {

		        javax.swing.JOptionPane.showMessageDialog(null,
		                "❗ Todos los campos deben estar llenos");
		        return;
		    }

		    try {
		        // 2. Capturar datos de la vista
		        String nombre   = de.txt_nombres.getText();
		        String mail     = de.txt_mail.getText();
		        String address  = de.txt_direccion.getText();
		        String fecha    = de.txt_fecha.getText();
		        int id          = Integer.parseInt(de.txt_id.getText());
		        int telefono    = Integer.parseInt(de.txt_tlc.getText());
		        int celular     = Integer.parseInt(de.txt_celular.getText());
		        int codigo      = id;  // Puedes usar ID como código si así lo deseas
		        
		        // 3. Obtener perfil del ComboBox
		        int opcionPerfil = de.comboBox.getSelectedIndex(); // 1=ADMIN, 2=VENDEDOR, 3=BODEGUERO

		        // 4. Crear trabajador (perfil vacío temporalmente)
		        model.trabajador t = new model.trabajador(
		                nombre, mail, address, fecha, "", codigo, id, telefono, celular
		        );

		        // 5. Asignar el perfil real
		        String perfil = t.perfil(opcionPerfil);
		        t.setPerfil(perfil);

		        // 6. Guardar en el TXT mediante el DAO
		        model.trabajadorDAO dao = new model.trabajadorDAO();

		        if (dao.guardarTrabajadorTXT(t)) {
		            javax.swing.JOptionPane.showMessageDialog(null,
		                    "✔ Trabajador registrado correctamente");

		            // Regresar al admin
		            view.ventana_admin va = new view.ventana_admin();
		            new controller.logic_vadmin(va);
		            va.setVisible(true);
		            de.dispose();

		        } else {
		            javax.swing.JOptionPane.showMessageDialog(null,
		                    "❌ Error al registrar trabajador");
		        }

		    } catch (NumberFormatException ex) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		                "❗ Teléfono, celular e ID deben ser números válidos.");
		    }
		}
	}

}
