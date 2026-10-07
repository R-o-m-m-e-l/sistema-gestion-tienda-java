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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class registro_empleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nombres;
	public JTextField txt_id;
	public JTextField txt_mail;
	public JTextField txt_tlc;
	public JTextField txt_direccion;
	public JTextField txt_fecha;
	public JTextField txt_celular;
	public JComboBox<String> comboBox;
	public JButton btn_registrar;
	public JButton btn_cancerlar;

    // Rutas y Constantes de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_PERSONA = "/Imagenes/Persona.png";
    private final String ICONO_ID = "/Imagenes/Id (1).png";
    private final String ICONO_MAIL = "/Imagenes/Mail.png";
    private final String ICONO_TELF_CONV = "/Imagenes/Telefono Convencional.png"; // Icono específico
    private final String ICONO_CELULAR = "/Imagenes/Telefono.png"; // Icono genérico de teléfono
    private final String ICONO_UBICACION = "/Imagenes/Ubicacion.png";
    private final String ICONO_FECHA = "/Imagenes/Fecha.png";
    private final String ICONO_ROL = "/Imagenes/Clave.png"; // Icono para el ComboBox (Perfil/Rol)
    private final String ICONO_REGISTRAR = "/Imagenes/documento.png";
    private final String ICONO_CANCELAR = "/Imagenes/Regresar.png";
    private final int ICON_SIZE = 18;
    private final Font LABEL_FONT = new Font("Arial", Font.BOLD, 11); // Fuente ligeramente más pequeña

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_empleado frame = new registro_empleado();
					new controller.logic_Rempleado(frame);
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
	public registro_empleado() {
		setTitle("MEGATIENDAS - Registro de Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 393);
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 482, 393);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(482, 393, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 482, 393);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		JPanel contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 482, 393);
        layeredPane.add(contentPane, Integer.valueOf(1)); 
        
		setContentPane(layeredPane); 
        
        // Función de ayuda para crear JLabel con Icono
        java.util.function.BiFunction<String, String, JLabel> createIconLabel = (text, iconPath) -> {
            JLabel label = new JLabel(text);
            label.setFont(LABEL_FONT);
            label.setForeground(Color.BLACK); 
            
            URL urlIcon = getClass().getResource(iconPath);
            if (urlIcon != null) {
                ImageIcon icon = new ImageIcon(urlIcon);
                label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
            }
            return label;
        };
		
		// 1. NOMBRES
		JLabel lblNombres = createIconLabel("NOMBRES", ICONO_PERSONA);
		lblNombres.setBounds(22, 23, 136, 20);
		contentPane.add(lblNombres);
		
		// 2. ID
		JLabel lblId = createIconLabel("ID", ICONO_ID);
		lblId.setBounds(22, 55, 136, 20);
		contentPane.add(lblId);
		
		// 3. MAIL
		JLabel lblMail = createIconLabel("MAIL", ICONO_MAIL);
		lblMail.setBounds(22, 87, 136, 20);
		contentPane.add(lblMail);
		
		// 4. TELF CONVENCIONAL
		JLabel lblTlc = createIconLabel("TELF CONVENCIONAL", ICONO_TELF_CONV);
		lblTlc.setBounds(22, 122, 136, 20);
		contentPane.add(lblTlc);
		
		// 5. CELULAR
		JLabel lblCelular = createIconLabel("CELULAR", ICONO_CELULAR);
		lblCelular.setBounds(22, 153, 136, 20);
		contentPane.add(lblCelular);
		
		// 6. DIRECCION
		JLabel lblDireccion = createIconLabel("DIRECCION", ICONO_UBICACION);
		lblDireccion.setBounds(22, 192, 136, 20);
		contentPane.add(lblDireccion);
		
		// 7. FECHA
		JLabel lblFecha = createIconLabel("FECHA", ICONO_FECHA);
		lblFecha.setBounds(22, 214, 136, 20);
		contentPane.add(lblFecha);
		
		// CAMPOS DE TEXTO
		txt_nombres = new JTextField();
		txt_nombres.setBounds(173, 20, 233, 25);
		contentPane.add(txt_nombres);
		
		txt_id = new JTextField();
		txt_id.setBounds(173, 52, 233, 25);
		contentPane.add(txt_id);
		
		txt_mail = new JTextField();
		txt_mail.setColumns(10);
		txt_mail.setBounds(173, 84, 233, 25);
		contentPane.add(txt_mail);
		
		txt_tlc = new JTextField();
		txt_tlc.setColumns(10);
		txt_tlc.setBounds(173, 119, 233, 25);
		contentPane.add(txt_tlc);
		
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(173, 183, 233, 25);
		contentPane.add(txt_direccion);
		
		txt_fecha = new JTextField();
		txt_fecha.setColumns(10);
		txt_fecha.setBounds(173, 211, 233, 25);
		contentPane.add(txt_fecha);
		
		txt_celular = new JTextField();
		txt_celular.setColumns(10);
		txt_celular.setBounds(173, 150, 233, 25);
		contentPane.add(txt_celular);
		
		// COMBOBOX Y BOTONES
		// Etiqueta para el ComboBox
		JLabel lblPerfil = createIconLabel("PERFIL", ICONO_ROL);
		lblPerfil.setBounds(22, 253, 136, 20);
		contentPane.add(lblPerfil);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(173, 253, 233, 25);
		comboBox.addItem(" ");
		comboBox.addItem("ADMINISTRADOR");
		comboBox.addItem("VENDEDOR");
		comboBox.addItem("BODEGUERO");
		contentPane.add(comboBox);
		
		btn_cancerlar = new JButton("CANCELAR");
		btn_cancerlar.setBounds(250, 310, 156, 35);
        btn_cancerlar.setBackground(new Color(244, 67, 54)); 
        btn_cancerlar.setForeground(Color.WHITE);
        btn_cancerlar.setFont(new Font("Arial", Font.BOLD, 14));
        btn_cancerlar.setIcon(getScaledIcon(ICONO_CANCELAR, 20));
		contentPane.add(btn_cancerlar);
		
		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.setBounds(47, 310, 156, 35);
        btn_registrar.setBackground(new Color(67, 160, 71)); 
        btn_registrar.setForeground(Color.WHITE);
        btn_registrar.setFont(new Font("Arial", Font.BOLD, 14));
        btn_registrar.setIcon(getScaledIcon(ICONO_REGISTRAR, 20));
		contentPane.add(btn_registrar);

	}
    
    /**
     * Método auxiliar que crea el JLabel con el icono escalado.
     */
    private JLabel createIconLabel(String text, String iconPath) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(Color.BLACK); 
        
        URL urlIcon = getClass().getResource(iconPath);
        if (urlIcon != null) {
            ImageIcon icon = new ImageIcon(urlIcon);
            label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH)));
        }
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