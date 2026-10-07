package view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ventana_bodeguero extends JFrame {

	private static final long serialVersionUID = 1L;
	// Hacemos el contentPane privado y usamos JLayeredPane
	public JButton btn_registrarproducro;
	public JButton btn_actualizarproducto;
	public JButton btn_actualizarcontrasenia;
	public JButton btn_registroproveedor;
	public JButton btn_regersar; // El botón de regreso

    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_PAQUETE = "/Imagenes/paquete.png";
    private final String ICONO_CAMBIO_DATO = "/Imagenes/Cambio de Dato.png";
    private final String ICONO_CLAVE = "/Imagenes/Clave.png";
    private final String ICONO_REGRESAR = "/Imagenes/Regresar.png";
    private final String ICONO_DOCUMENTO = "/Imagenes/documento.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_bodeguero frame = new ventana_bodeguero();
					new controller.logic_vbodeguero(frame);
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
	public ventana_bodeguero() {
		setTitle("MEGATIENDAS - Panel Bodeguero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 300);
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 352, 300);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(352, 300, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 352, 300);
            layeredPane.add(background, Integer.valueOf(0)); // Capa 0: Fondo
        }
        
        // Panel de Controles (Transparente)
		JPanel contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 352, 300);
        layeredPane.add(contentPane, Integer.valueOf(1)); // Capa 1: Controles
        
		setContentPane(layeredPane); 
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        
        // --- 2. CONFIGURACIÓN DE BOTONES ---
        
        // 2.1. REGISTRAR PRODUCTO (Verde = Añadir Inventario)
		btn_registrarproducro = new JButton("REGISTRAR PRODUCTO");
		btn_registrarproducro.setBounds(56, 29, 223, 30);
        btn_registrarproducro.setBackground(new Color(67, 160, 71)); 
        btn_registrarproducro.setForeground(Color.WHITE);
        btn_registrarproducro.setFont(buttonFont);
        btn_registrarproducro.setIcon(getScaledIcon(ICONO_PAQUETE, 20));
		contentPane.add(btn_registrarproducro);
		
        // 2.2. ACTUALIZAR PRODUCTO (Azul = Modificación)
		btn_actualizarproducto = new JButton("ACTUALIZAR PRODUCTO");
		btn_actualizarproducto.setBounds(56, 72, 223, 30);
        btn_actualizarproducto.setBackground(new Color(33, 150, 243)); 
        btn_actualizarproducto.setForeground(Color.WHITE);
        btn_actualizarproducto.setFont(buttonFont);
        btn_actualizarproducto.setIcon(getScaledIcon(ICONO_CAMBIO_DATO, 20));
		contentPane.add(btn_actualizarproducto);
		
        // 2.3. REGISTRAR PROVEEDOR (Gris/Neutro = Nuevo Registro)
		btn_registroproveedor = new JButton("REGISTRAR PROVEEDOR");
		btn_registroproveedor.setBounds(56, 115, 223, 30);
        btn_registroproveedor.setBackground(new Color(189, 189, 189));
        btn_registroproveedor.setForeground(Color.BLACK);
        btn_registroproveedor.setFont(buttonFont);
        btn_registroproveedor.setIcon(getScaledIcon(ICONO_DOCUMENTO, 20));
		contentPane.add(btn_registroproveedor);
        
        // 2.4. ACTUALIZAR CONTRASEÑA (Seguridad)
		btn_actualizarcontrasenia = new JButton("ACTUALIZAR CONTRASEÑA");
		btn_actualizarcontrasenia.setBounds(56, 158, 223, 30);
        btn_actualizarcontrasenia.setBackground(new Color(0, 51, 102));
        btn_actualizarcontrasenia.setForeground(Color.WHITE);
        btn_actualizarcontrasenia.setFont(buttonFont);
        btn_actualizarcontrasenia.setIcon(getScaledIcon(ICONO_CLAVE, 20));
		contentPane.add(btn_actualizarcontrasenia);
		
        // 2.5. REGRESAR (Salir)
		btn_regersar = new JButton("REGRESAR");
		btn_regersar.setBounds(56, 219, 223, 30);
        btn_regersar.setBackground(new Color(244, 67, 54)); 
        btn_regersar.setForeground(Color.WHITE);
        btn_regersar.setFont(buttonFont);
        btn_regersar.setIcon(getScaledIcon(ICONO_REGRESAR, 20));
		contentPane.add(btn_regersar);
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