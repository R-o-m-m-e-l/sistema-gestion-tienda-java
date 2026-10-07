package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.function.BiFunction;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class actualizar_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JTextField txt_nombre;
	public JTextField txt_id;
	public JTextField txt_mail;
	public JTextField txt_celular;
	public JTextField txt_direccion;
	public JButton btn_actualizar;
	public JButton btn_cancelar;

    // Rutas de Recursos (Las constantes están correctamente definidas)
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_PERSONA = "/Imagenes/Persona.png"; 
    private final String ICONO_ID = "/Imagenes/Id (1).png";       
    private final String ICONO_MAIL = "/Imagenes/Mail.png";
    private final String ICONO_TELEFONO = "/Imagenes/Telefono.png"; 
    private final String ICONO_UBICACION = "/Imagenes/Ubicacion.png";
    private final int ICON_SIZE = 18;
    private final Font LABEL_FONT = new Font("Arial", Font.BOLD, 12); 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actualizar_cliente frame = new actualizar_cliente();
					// new controller.logic_Acliente(frame); 
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
	public actualizar_cliente() {
		setTitle("MEGATIENDAS - Actualizar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 431);
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 450, 431);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(450, 431, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 450, 431);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		JPanel contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 450, 431);
        layeredPane.add(contentPane, Integer.valueOf(1)); 
        
		setContentPane(layeredPane); 
        
        // --- 2. ETIQUETAS Y CAMPOS ---
		
        // NOMBRES (Icono Persona) - Línea 104 corregida
		JLabel lblNombre = createIconLabel("NOMBRES", ICONO_PERSONA); 
		lblNombre.setBounds(27, 34, 150, 18);
		contentPane.add(lblNombre);
		
		// ID (Icono ID) - Línea 109 corregida
		JLabel lblId = createIconLabel("ID", ICONO_ID);
		lblId.setBounds(27, 72, 150, 18);
		contentPane.add(lblId);
		
		// MAIL (Icono Mail) - Línea 114 corregida
		JLabel lblMail = createIconLabel("MAIL", ICONO_MAIL);
		lblMail.setBounds(27, 109, 150, 18);
		contentPane.add(lblMail);
		
		// CELULAR (Icono Teléfono) - Línea 119 corregida
		JLabel lblCelular = createIconLabel("CELULAR", ICONO_TELEFONO);
		lblCelular.setBounds(27, 141, 150, 18);
		contentPane.add(lblCelular);
		
		// DIRECCION (Icono Ubicación) - Línea 124 corregida
		JLabel lblDireccion = createIconLabel("DIRECCION", ICONO_UBICACION);
		lblDireccion.setBounds(27, 175, 150, 18);
		contentPane.add(lblDireccion);
		
		// Campos de Texto
		txt_nombre = new JTextField();
		txt_nombre.setBounds(134, 31, 292, 18);
		contentPane.add(txt_nombre);
		
		txt_id = new JTextField();
		txt_id.setBounds(134, 69, 292, 18);
        txt_id.setEditable(false); 
		contentPane.add(txt_id);
		
		txt_mail = new JTextField();
		txt_mail.setBounds(134, 106, 292, 18);
		contentPane.add(txt_mail);
		
		txt_celular = new JTextField();
		txt_celular.setBounds(134, 138, 292, 18);
		contentPane.add(txt_celular);
		
		txt_direccion = new JTextField();
		txt_direccion.setBounds(134, 172, 292, 18);
		contentPane.add(txt_direccion);
		
        // --- 3. BOTONES ---
		btn_actualizar = new JButton("ACTUALIZAR");
		btn_actualizar.setBounds(134, 245, 124, 30); 
        btn_actualizar.setBackground(new Color(33, 150, 243)); 
        btn_actualizar.setForeground(Color.WHITE);
		contentPane.add(btn_actualizar);
		
		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(134, 298, 124, 30); 
        btn_cancelar.setBackground(new Color(244, 67, 54)); 
        btn_cancelar.setForeground(Color.WHITE);
		contentPane.add(btn_cancelar);
        
        // Inicialización del controlador
        // new controller.logic_Acliente(this);
	}
    
    /**
     * SOLUCIÓN: Método auxiliar que crea el JLabel con el icono escalado.
     * Este método estaba faltando en la clase.
     */
    private JLabel createIconLabel(String text, String iconPath) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(Color.BLACK); 
        
        URL urlIcon = getClass().getResource(iconPath);
        if (urlIcon != null) {
            ImageIcon icon = new ImageIcon(urlIcon);
            Image img = icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        }
        return label;
    }
}