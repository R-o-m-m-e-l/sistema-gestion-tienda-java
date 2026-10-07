package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.trabajadorDAO;
import view.ventana_admin;
import view.ventana_bodeguero;
import view.ventana_inicio;
import view.ventana_vendedor;

public class logic_vInicio implements ActionListener {

    private ventana_inicio vi;
    private trabajadorDAO dao;

    public logic_vInicio(ventana_inicio vi) {
        this.vi = vi;
        this.dao = new trabajadorDAO();

        this.vi.btn_ingresar.addActionListener(this);
        this.vi.btn_salir.addActionListener(this);
        this.vi.txt_nombre.addActionListener(this);
        this.vi.txt_password.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vi.btn_ingresar) {
            ingresarSistema();
        }
        else if (e.getSource() == vi.btn_salir) {
            System.exit(0);
        }
    }

    private void ingresarSistema() {

        String mail = vi.txt_nombre.getText().trim();     // ← El DAO usa mail
        String codigo = vi.txt_password.getText().trim(); // ← Contraseña/código

        if (mail.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Complete todos los campos.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ----------------------------------------
        // Llamamos al método que ya existe en tu DAO
        // ----------------------------------------
        String perfil = dao.obtenerPerfilPorMailYCodigo(mail, codigo);

        if (perfil == null) {
            JOptionPane.showMessageDialog(null,
                    "Correo o contraseña incorrectos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ----------------------------------------
        // ABRIR SEGÚN PERFIL
        // ----------------------------------------
        switch (perfil) {

            case "ADMINISTRADOR":
                ventana_admin va = new ventana_admin();
                new logic_vadmin(va);
                va.setVisible(true);
                vi.dispose();
                break;

            case "VENDEDOR":
                ventana_vendedor vv = new ventana_vendedor();
                new logic_vvendedor(vv);
                vv.setVisible(true);
                vi.dispose();
                break;

            case "BODEGUERO":
                ventana_bodeguero vb = new ventana_bodeguero();
                new logic_vbodeguero(vb);
                vb.setVisible(true);
                vi.dispose();
                break;

            default:
                JOptionPane.showMessageDialog(null,
                        "Perfil desconocido: " + perfil,
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
