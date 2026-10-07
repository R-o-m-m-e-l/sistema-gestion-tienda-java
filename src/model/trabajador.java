package model;

public class trabajador extends persona{

	public trabajador(String nombre, String mail, String address, String fecha, String perfil, int codigo, int id,
			int telefono, int celular) {
		super(nombre, mail, address, fecha, perfil, codigo, id, telefono, celular);
		// TODO Auto-generated constructor stub
	}
	public String perfil(int num) {
		switch(num) {
		case 1:
			 setPerfil("ADMINISTRADOR");
			 break;
		case 2:
			setPerfil("VENDEDOR");
			break;
		case 3:
			setPerfil("BODEGUERO");
			break;
		default:
			break;
		}
		return getPerfil();
	}

}
