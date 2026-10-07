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

public class registrar_proveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_codigo;
	public JTextField txt_razonsosial;
	public JTextField txt_contacto;
	public JTextField txt_telefono;
	public JTextField txt_mail;
	public JButton btn_registrar;
	public JButton btn_cancelar;

    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_CODIGO = "/Imagenes/Codigo.png";
    private final String ICONO_RAZON = "/Imagenes/Razon Social.png";
    private final String ICONO_CONTACTO = "/Imagenes/Contacto.png";
    private final String ICONO_TELEFONO = "/Imagenes/Telefono.png";
    private final String ICONO_MAIL = "/Imagenes/Mail.png";
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
					registrar_proveedor frame = new registrar_proveedor();
					new controller.logic_Rproveedor(frame);
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
	public registrar_proveedor() {
		setTitle("MEGATIENDAS - Registrar Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320); // Ajuste de altura
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 450, 320);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(450, 320, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 450, 320);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 450, 320);
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
		
		// 1. CÓDIGO
		JLabel lblCodigo = createIconLabel("CODIGO", ICONO_CODIGO);
		lblCodigo.setBounds(10, 10, 100, 25);
		contentPane.add(lblCodigo);
		
		// 2. RAZON SOCIAL
		JLabel lblRazonSocial = createIconLabel("RAZON SOCIAL", ICONO_RAZON);
		lblRazonSocial.setBounds(10, 42, 100, 25);
		contentPane.add(lblRazonSocial);
		
		// 3. CONTACTO
		JLabel lblContacto = createIconLabel("CONTACTO", ICONO_CONTACTO);
		lblContacto.setBounds(10, 79, 100, 25);
		contentPane.add(lblContacto);
		
		// 4. TELEFONO
		JLabel lblTelefono = createIconLabel("TELEFONO", ICONO_TELEFONO);
		lblTelefono.setBounds(10, 115, 100, 25);
		contentPane.add(lblTelefono);
		
		// 5. MAIL
		JLabel lblMail = createIconLabel("MAIL", ICONO_MAIL);
		lblMail.setBounds(10, 150, 100, 25);
		contentPane.add(lblMail);
		
		// CAMPOS DE TEXTO
		txt_codigo = new JTextField();
		txt_codigo.setBounds(118, 10, 277, 25);
		contentPane.add(txt_codigo);
		
		txt_razonsosial = new JTextField();
		txt_razonsosial.setBounds(118, 42, 277, 25);
		contentPane.add(txt_razonsosial);
		
		txt_contacto = new JTextField();
		txt_contacto.setBounds(118, 79, 277, 25);
		contentPane.add(txt_contacto);
		
		txt_telefono = new JTextField();
		txt_telefono.setBounds(118, 115, 277, 25);
		contentPane.add(txt_telefono);
		
		txt_mail = new JTextField();
		txt_mail.setBounds(118, 147, 277, 25);
		contentPane.add(txt_mail);
		
		// BOTONES
		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.setBounds(66, 200, 150, 35);
        btn_registrar.setBackground(new Color(67, 160, 71)); // Verde de Registro
        btn_registrar.setForeground(Color.WHITE);
        btn_registrar.setIcon(getScaledIcon(ICONO_REGISTRAR, 20));
		contentPane.add(btn_registrar);
		
		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(233, 200, 150, 35);
        btn_cancelar.setBackground(new Color(244, 67, 54)); // Rojo (Cancelar)
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setIcon(getScaledIcon(ICONO_CANCELAR, 20));
		contentPane.add(btn_cancelar);

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