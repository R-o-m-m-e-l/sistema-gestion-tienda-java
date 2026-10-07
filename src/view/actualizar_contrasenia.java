package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class actualizar_contrasenia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_usuario;
	public JTextField txt_oldpass;
	public JTextField txt_newpass;
	public JButton btn_actualizar;
	public JButton btn_cancelar;

    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_USUARIO = "/Imagenes/Persona.png"; 
    private final String ICONO_CLAVE = "/Imagenes/Clave.png";
    private final String ICONO_ACTUALIZAR = "/Imagenes/Cambio de Dato.png";
    private final String ICONO_CANCELAR = "/Imagenes/Regresar.png";
    private final int ICON_SIZE = 18;
    private final Font LABEL_FONT = new Font("Arial", Font.BOLD, 12);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actualizar_contrasenia frame = new actualizar_contrasenia();
					new controller.logic_Acontrasenia(frame); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public actualizar_contrasenia() {
		setTitle("MEGATIENDAS - Cambiar Contraseña");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 450, 260);
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 450, 260);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(450, 260, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 450, 260);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		JPanel contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 450, 260);
        layeredPane.add(contentPane, Integer.valueOf(1)); 
        
		setContentPane(layeredPane); 
        
        // --- 2. ETIQUETAS Y CAMPOS ---
        
		// 1. USUARIO (MAIL) - Icono de Persona
        // ESTAS LÍNEAS ERAN LAS QUE FALLABAN PORQUE createIconLabel NO EXISTÍA ABAJO
		JLabel lblUsuario = createIconLabel("USUARIO (Correo)", ICONO_USUARIO);
		lblUsuario.setBounds(25, 24, 158, 25);
		contentPane.add(lblUsuario);
		
		// 2. CONTRASEÑA ANTIGUA - Icono de Clave
		JLabel lblOldPass = createIconLabel("CONTRASEÑA ANTIGUA", ICONO_CLAVE);
		lblOldPass.setBounds(25, 63, 158, 25);
		contentPane.add(lblOldPass);
		
		// 3. NUEVA CONTRASEÑA - Icono de Clave
		JLabel lblNewPass = createIconLabel("NUEVA CONTRASEÑA", ICONO_CLAVE);
		lblNewPass.setBounds(25, 103, 158, 25);
		contentPane.add(lblNewPass);
		
		// CAMPOS DE TEXTO
		txt_usuario = new JTextField();
		txt_usuario.setBounds(193, 21, 233, 25);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		txt_oldpass = new JTextField(); 
		txt_oldpass.setBounds(193, 60, 233, 25);
		contentPane.add(txt_oldpass);
		txt_oldpass.setColumns(10);
		
		txt_newpass = new JTextField(); 
		txt_newpass.setBounds(193, 100, 233, 25);
		contentPane.add(txt_newpass);
		txt_newpass.setColumns(10);
		
		// BOTONES
		btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setBounds(45, 165, 160, 30);
        btn_actualizar.setBackground(new Color(33, 150, 243)); 
        btn_actualizar.setForeground(Color.WHITE);
        btn_actualizar.setIcon(getScaledIcon(ICONO_ACTUALIZAR, 20));
		contentPane.add(btn_actualizar);
		
		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(230, 165, 160, 30);
        btn_cancelar.setBackground(new Color(244, 67, 54)); 
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setIcon(getScaledIcon(ICONO_CANCELAR, 20));
		contentPane.add(btn_cancelar);

	}
    
    // --- FUNCIÓN FALTANTE QUE RESUELVE EL ERROR ---

    /**
     * Método auxiliar que crea el JLabel con el icono escalado.
     */
    private JLabel createIconLabel(String text, String iconPath) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(Color.BLACK); 
        
        // Carga y escala el icono usando el método getScaledIcon
        label.setIcon(getScaledIcon(iconPath, ICON_SIZE));
        
        return label;
    }
    
    /**
     * Método auxiliar para cargar y escalar iconos.
     */
    private ImageIcon getScaledIcon(String path, int size) {
        URL url = getClass().getResource(path);
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return null;
    }
}