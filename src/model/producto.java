package model;

import libreria_p67.generic;

public class producto {
	String codigo, producto,proveedor;
	int unidades;
	double precio;
	generic<String,Integer> p;
	generic<String,Double>  p2;
	public producto() {
		this.p=new generic<>();
		this.p2=new generic<>();
		this.codigo=" ";
		this.producto=" ";
		this.proveedor=" ";
		this.unidades=0;
		this.precio=0.0;
	}
	public String getCodigo() {
		return p.getAttribute1();
	}
	public void setCodigo(String codigo) {
		p.setAttribute1(codigo);
	}
	public String getProducto() {
		return p.getAttribute2();
	}
	public void setProducto(String producto) {
		p.setAttribute2(producto);
	}
	public String getProveedor() {
		return p2.getAttribute1();
	}
	public void setProveedor(String proveedor) {
		p2.setAttribute1(proveedor);
	}
	public int getUnidades() {
		return p.getAttribute3();
	}
	public void setUnidades(int unidades) {
		p.setAttribute3(Integer.valueOf(unidades));
	}
	public double getPrecio() {
		return p2.getAttribute3();
	}
	public void setPrecio(double precio) {
		p2.setAttribute3(Double.valueOf(precio));
	}
	

}
