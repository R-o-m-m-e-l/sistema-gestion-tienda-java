package model;

import libreria_p67.generic;

public class proveedor {
	String codigo,razon_social,contacto,mail;
	int telefono;
	generic<String,String> gen;
	generic<Integer,?> neg;
	public proveedor() {
		this.gen=new generic<>();
		this.neg=new generic<>();
		this.codigo=" ";
		this.razon_social=" ";
		this.contacto=" ";
		this.mail=" ";
		this.telefono=0;
	}
	public String getCodigo() {
		return gen.getAttribute1();
	}
	public void setCodigo(String codigo) {
		gen.setAttribute1(codigo);
	}
	public String getRazon_social() {
		return gen.getAttribute2();
	}
	public void setRazon_social(String razon_social) {
		gen.setAttribute2(razon_social);
	}
	public String getContacto() {
		return gen.getAttribute3();
	}
	public void setContacto(String contacto) {
		gen.setAttribute3(contacto);
	}
	public String getMail() {
		return gen.getAttribute4();
	}
	public void setMail(String mail) {
		gen.setAttribute4(mail);
	}
	public int getTelefono() {
		return neg.getAttribute1();
	}
	public void setTelefono(int telefono) {
		neg.setAttribute1(Integer.valueOf(telefono));
	}
	

}
