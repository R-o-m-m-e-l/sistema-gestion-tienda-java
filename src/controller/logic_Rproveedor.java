package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.registrar_proveedor;
import view.ventana_bodeguero;

public class logic_Rproveedor implements ActionListener{
	registrar_proveedor wx=new registrar_proveedor();

	public logic_Rproveedor(registrar_proveedor wx) {
		super();
		// TODO Auto-generated constructor stub
		this.wx=wx;
		this.wx.btn_cancelar.addActionListener(this);
		this.wx.btn_registrar.addActionListener(this);
		this.wx.txt_codigo.addActionListener(this);
		this.wx.txt_contacto.addActionListener(this);
		this.wx.txt_mail.addActionListener(this);
		this.wx.txt_razonsosial.addActionListener(this);
		this.wx.txt_telefono.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wx.btn_cancelar) {
			ventana_bodeguero vb=new ventana_bodeguero();
			new controller.logic_vbodeguero(vb);
			vb.setVisible(true);
			wx.dispose();
		}else if(e.getSource()==wx.btn_registrar) {

		    model.validante v = new model.validante();

		    // 1. Leer datos
		    String codigo = wx.txt_codigo.getText().trim();
		    String razon = wx.txt_razonsosial.getText().trim();
		    String contacto = wx.txt_contacto.getText().trim();
		    String mail = wx.txt_mail.getText().trim();
		    String telefono = wx.txt_telefono.getText().trim();

		    // 2. Validaciones
		    if(codigo.isEmpty() || razon.isEmpty() || contacto.isEmpty() ||
		       mail.isEmpty() || telefono.isEmpty()) {

		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Todos los campos son obligatorios",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if(!v.validarTelf(contacto)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "El contacto debe contener entre 7 y 9 dígitos.",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if(!v.validarCel(telefono)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "El teléfono debe ser un celular ecuatoriano válido (09XXXXXXXX).",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if(!v.validarMail(mail)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Correo no válido. Solo se acepta Gmail o Hotmail.",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // 3. Crear el objeto proveedor
		    model.proveedor p = new model.proveedor();
		    if(v.validarRS(razon)) {
		        p.setRazon_social(razon);
		    } else {
		        javax.swing.JOptionPane.showMessageDialog(null, "Razón social inválida");
		        return; // detener el guardado
		    }
		    p.setCodigo(codigo);
		    p.setRazon_social(razon);
		    p.setContacto(contacto);
		    p.setMail(mail);
		    p.setTelefono(Integer.parseInt(telefono));

		    // 4. Registrar en archivo
		    model.proveedorDAO dao = new model.proveedorDAO();

		    if(dao.registrarProveedor(p)) {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Proveedor registrado correctamente");

		        // Regresar a ventana bodeguero
		        ventana_bodeguero vb = new ventana_bodeguero();
		        new controller.logic_vbodeguero(vb);
		        vb.setVisible(true);
		        wx.dispose();

		    } else {
		        javax.swing.JOptionPane.showMessageDialog(null,
		            "Error al registrar el proveedor",
		            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
		    }
		}
		
	}

}
