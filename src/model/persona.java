package model;

import libreria_p67.generic;

public class persona {
    
    String nombre, mail, address, fecha, perfil;
    int codigo, id, telefono, celular;

    generic<String, Integer> dlc1;
    generic<String, Integer> dlc2;
    generic<String, ?> dlc3;

    public persona(String nombre, String mail, String address, String fecha,
                   String perfil, int codigo, int id, int telefono, int celular) {

        this.dlc1 = new generic<>();
        this.dlc2 = new generic<>();
        this.dlc3 = new generic<>();

        // Cargar datos en los generic
        dlc1.setAttribute1(nombre);
        dlc1.setAttribute2(mail);
        dlc1.setAttribute3(codigo);
        dlc1.setAttribute4(id);

        dlc2.setAttribute1(address);
        dlc2.setAttribute2(fecha);
        dlc2.setAttribute3(telefono);
        dlc2.setAttribute4(celular);

        dlc3.setAttribute1(perfil);

        // También guardas los valores normales si los necesitas
        this.nombre = nombre;
        this.mail = mail;
        this.address = address;
        this.fecha = fecha;
        this.perfil = perfil;
        this.codigo = codigo;
        this.id = id;
        this.telefono = telefono;
       	this.celular = celular;
    }

    public String getNombre() {
        return dlc1.getAttribute1();
    }
    public void setNombre(String nombre) {
        dlc1.setAttribute1(nombre);
    }

    public String getMail() {
        return dlc1.getAttribute2();
    }
    public void setMail(String mail) {
        dlc1.setAttribute2(mail);
    }

    public String getAddress() {
        return dlc2.getAttribute1();
    }
    public void setAddress(String address) {
        dlc2.setAttribute1(address);
    }

    public String getFecha() {
        return dlc2.getAttribute2();
    }
    public void setFecha(String fecha) {
        dlc2.setAttribute2(fecha);
    }

    public String getPerfil() {
        return (String) dlc3.getAttribute1();
    }
    public void setPerfil(String perfil) {
        dlc3.setAttribute1(perfil);
    }

    public int getCodigo() {
        return dlc1.getAttribute3();
    }
    public void setCodigo(int codigo) {
        dlc1.setAttribute3(codigo);
    }

    public int getId() {
        return dlc1.getAttribute4();
    }
    public void setId(int id) {
        dlc1.setAttribute4(id);
    }

    public int getTelefono() {
        return dlc2.getAttribute3();
    }
    public void setTelefono(int telefono) {
        dlc2.setAttribute3(telefono);
    }

    public int getCelular() {
        return dlc2.getAttribute4();
    }
    public void setCelular(int celular) {
        dlc2.setAttribute4(celular);
    }
}