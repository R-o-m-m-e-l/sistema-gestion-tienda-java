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
import javax.swing.JLayeredPane; // Para el fondo

public class ventana_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_registrar;
	public JButton btn_actualizar_cliente;
	public JButton btn_regresar;
	public JButton btn_actualizar_pass;
    
    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg"; 
    private final String ICONO_REGISTRAR = "/Imagenes/documento.png";
    private final String ICONO_ACTUALIZAR = "/Imagenes/Cambio de Dato.png";
    private final String ICONO_CLAVE = "/Imagenes/Clave.png";
    private final String ICONO_REGRESAR = "/Imagenes/cerrar-sesion.png"; // Usamos cerrar-sesion para salir/regresar

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_admin frame = new ventana_admin();
					new controller.logic_vadmin(frame);
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
	public ventana_admin() {
		setTitle("MEGATIENDAS - Panel Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 300);
        
        // --- PREPARACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 336, 300);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(336, 300, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 336, 300);
            layeredPane.add(background, Integer.valueOf(0)); // Capa 0: Fondo
        }
        
        // Panel de Controles transparente (capa superior)
        contentPane = new JPanel(null); 
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 336, 300);
        layeredPane.add(contentPane, Integer.valueOf(1)); // Capa 1: Controles
        
		setContentPane(layeredPane); // Establecer el panel con capas
		
		// --- CONFIGURACIÓN DE BOTONES ---
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        
        // 1. REGISTRAR (Empleados, Clientes, Proveedores)
		btn_registrar = new JButton("REGISTRAR EMPLEADO");
		btn_registrar.setBounds(20, 20, 290, 40);
        btn_registrar.setBackground(new Color(67, 160, 71)); // Verde de Registro
        btn_registrar.setForeground(Color.WHITE);
        btn_registrar.setFont(buttonFont);
        btn_registrar.setIcon(getScaledIcon(ICONO_REGISTRAR, 20)); // Icono: Documento
		contentPane.add(btn_registrar);
		
        // 2. ACTUALIZAR CONTRASEÑA
		btn_actualizar_pass = new JButton("ACTUALIZAR CONTRASEÑA");
		btn_actualizar_pass.setBounds(20, 70, 290, 40);
        btn_actualizar_pass.setBackground(new Color(0, 51, 102)); // Azul Oscuro (Seguridad)
        btn_actualizar_pass.setForeground(Color.WHITE);
        btn_actualizar_pass.setFont(buttonFont);
        btn_actualizar_pass.setIcon(getScaledIcon(ICONO_CLAVE, 20)); // Icono: Clave
		contentPane.add(btn_actualizar_pass);
		
        // 3. ACTUALIZAR CLIENTE
		btn_actualizar_cliente = new JButton("ACTUALIZAR DATOS CLIENTE");
		btn_actualizar_cliente.setBounds(20, 120, 290, 40);
        btn_actualizar_cliente.setBackground(new Color(33, 150, 243)); // Azul Claro (Actualizar/Cambio)
        btn_actualizar_cliente.setForeground(Color.WHITE);
        btn_actualizar_cliente.setFont(buttonFont);
        btn_actualizar_cliente.setIcon(getScaledIcon(ICONO_ACTUALIZAR, 20)); // Icono: Cambio de Dato
		contentPane.add(btn_actualizar_cliente);
		
        // 4. REGRESAR / SALIR
		btn_regresar = new JButton("REGRESAR / CERRAR SESIÓN");
		btn_regresar.setBounds(20, 190, 290, 40);
        btn_regresar.setBackground(new Color(244, 67, 54)); // Rojo (Salir)
        btn_regresar.setForeground(Color.WHITE);
        btn_regresar.setFont(buttonFont);
        btn_regresar.setIcon(getScaledIcon(ICONO_REGRESAR, 20)); // Icono: Cerrar Sesión
		contentPane.add(btn_regresar);
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