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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana_vendedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_registrarcliente;
	public JButton btn_actualizarcontrasenia;
	public JButton btn_regresar;

    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_DOCUMENTO = "/Imagenes/documento.png";
    private final String ICONO_CLAVE = "/Imagenes/Clave.png";
    private final String ICONO_REGRESAR = "/Imagenes/Regresar.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_vendedor frame = new ventana_vendedor();
					new controller.logic_vvendedor(frame);
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
	public ventana_vendedor() {
		setTitle("MEGATIENDAS - Panel Vendedor");
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
            layeredPane.add(background, Integer.valueOf(0)); // Capa 0: Fondo
        }
        
        // Panel de Controles (Transparente)
		contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 450, 300);
        layeredPane.add(contentPane, Integer.valueOf(1)); // Capa 1: Controles
        
		setContentPane(layeredPane); 
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        
        // --- 2. CONFIGURACIÓN DE BOTONES ---
        
        // 2.1. ACTUALIZAR CONTRASEÑA (Seguridad - Botón Emergente)
		btn_actualizarcontrasenia = new JButton("ACTUALIZAR CONTRASEÑA");
		btn_actualizarcontrasenia.setBounds(62, 59, 327, 30); // Aumento de altura para estética
        btn_actualizarcontrasenia.setBackground(new Color(0, 51, 102)); // Azul Oscuro (Seguridad)
        btn_actualizarcontrasenia.setForeground(Color.WHITE);
        btn_actualizarcontrasenia.setFont(buttonFont);
        btn_actualizarcontrasenia.setIcon(getScaledIcon(ICONO_CLAVE, 20));
		contentPane.add(btn_actualizarcontrasenia);
		
        // 2.2. REGISTRAR CLIENTE (Añadir nuevo registro)
		btn_registrarcliente = new JButton("REGISTRAR CLIENTE");
		btn_registrarcliente.setBounds(62, 123, 327, 30);
        btn_registrarcliente.setBackground(new Color(67, 160, 71)); // Verde Esmeralda (Registro)
        btn_registrarcliente.setForeground(Color.WHITE);
        btn_registrarcliente.setFont(buttonFont);
        btn_registrarcliente.setIcon(getScaledIcon(ICONO_DOCUMENTO, 20));
		contentPane.add(btn_registrarcliente);
		
        // 2.3. REGRESAR (Salir de la sesión)
		btn_regresar = new JButton("REGRESAR / CERRAR SESIÓN");
		btn_regresar.setBounds(62, 193, 327, 30);
        btn_regresar.setBackground(new Color(244, 67, 54)); // Rojo (Salir)
        btn_regresar.setForeground(Color.WHITE);
        btn_regresar.setFont(buttonFont);
        btn_regresar.setIcon(getScaledIcon(ICONO_REGRESAR, 20)); // Icono de Regreso/Cierre
		contentPane.add(btn_regresar);

        // NOTA: Se elimina el ActionListener vacío del botón 'registrarcliente'
	}
    
    /**
     * Método auxiliar para cargar y escalar iconos desde la carpeta Imagenes.
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