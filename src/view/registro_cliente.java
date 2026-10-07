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

public class registro_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_nombre;
	public JTextField txt_id;
	public JTextField txt_mail;
	public JTextField txt_telefono;
	public JTextField txt_direccion;
	public JButton btn_registrar;
	public JButton btn_cancelar;

    // Rutas y Constantes de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_PERSONA = "/Imagenes/Persona.png";
    private final String ICONO_ID = "/Imagenes/Id (1).png";
    private final String ICONO_MAIL = "/Imagenes/Mail.png";
    private final String ICONO_TELEFONO = "/Imagenes/Telefono.png";
    private final String ICONO_UBICACION = "/Imagenes/Ubicacion.png";
    private final String ICONO_REGISTRAR = "/Imagenes/documento.png";
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
					registro_cliente frame = new registro_cliente();
					new controller.logic_Rcliente(frame);
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
	public registro_cliente() {
		setTitle("MEGATIENDAS - Registrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 450, 300);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 450, 300);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 450, 300);
        layeredPane.add(contentPane, Integer.valueOf(1)); 
        
		setContentPane(layeredPane); 
        
        // --- 2. ETIQUETAS Y CAMPOS ---
		
		// 1. NOMBRES (Icono Persona) - Línea 103 (corregida)
		JLabel lblNombre = createIconLabel("NOMBRES", ICONO_PERSONA);
		lblNombre.setBounds(25, 20, 100, 25);
		contentPane.add(lblNombre);
		
		// 2. ID (Icono ID) - Línea 108 (corregida)
		JLabel lblId = createIconLabel("ID", ICONO_ID);
		lblId.setBounds(25, 51, 100, 25);
		contentPane.add(lblId);
		
		// 3. MAIL (Icono Mail) - Línea 113 (corregida)
		JLabel lblMail = createIconLabel("MAIL", ICONO_MAIL);
		lblMail.setBounds(25, 75, 100, 25);
		contentPane.add(lblMail);
		
		// 4. TELEFONO (Icono Teléfono) - Línea 118 (corregida)
		JLabel lblTelefono = createIconLabel("TELEFONO", ICONO_TELEFONO);
		lblTelefono.setBounds(25, 104, 100, 25);
		contentPane.add(lblTelefono);
		
		// 5. DIRECCION (Icono Ubicación) - Línea 123 (corregida)
		JLabel lblDireccion = createIconLabel("DIRECCION", ICONO_UBICACION);
		lblDireccion.setBounds(25, 132, 100, 25);
		contentPane.add(lblDireccion);
		
		// CAMPOS DE TEXTO
		txt_nombre = new JTextField();
		txt_nombre.setBounds(122, 20, 304, 25);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setBounds(122, 51, 304, 25);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_mail = new JTextField();
		txt_mail.setBounds(122, 75, 304, 25);
		contentPane.add(txt_mail);
		txt_mail.setColumns(10);
		
		txt_telefono = new JTextField();
		txt_telefono.setBounds(122, 104, 304, 25);
		contentPane.add(txt_telefono);
		txt_telefono.setColumns(10);
		
		txt_direccion = new JTextField();
		txt_direccion.setBounds(122, 132, 304, 25);
		contentPane.add(txt_direccion);
		txt_direccion.setColumns(10);
		
		// BOTONES
		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.setBounds(128, 180, 126, 35);
        btn_registrar.setBackground(new Color(67, 160, 71)); // Verde de Registro
        btn_registrar.setForeground(Color.WHITE);
        btn_registrar.setIcon(getScaledIcon(ICONO_REGISTRAR, 20));
		contentPane.add(btn_registrar);
		
		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(270, 180, 126, 35);
        btn_cancelar.setBackground(new Color(244, 67, 54)); // Rojo (Cancelar)
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setIcon(getScaledIcon(ICONO_CANCELAR, 20));
		contentPane.add(btn_cancelar);

	}
    
    // --------------------------------------------------------------------------
    // MÉTODOS AUXILIARES AÑADIDOS (SOLUCIÓN)
    // --------------------------------------------------------------------------

    /**
     * Resuelve el error: Método auxiliar que crea el JLabel con el icono escalado.
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