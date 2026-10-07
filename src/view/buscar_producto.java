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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buscar_producto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_codigo;
	public JButton btn_buscar;
	public JButton btn_cancelar;

    // Rutas y Constantes
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_CODIGO = "/Imagenes/Codigo.png";
    private final String ICONO_BUSCAR = "/Imagenes/Lupa.png";
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
					buscar_producto frame = new buscar_producto();
					new controller.logic_Bproducto(frame);
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
	public buscar_producto() {
		setTitle("MEGATIENDAS - Buscar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 230); 
        
        // --- 1. CONFIGURACIÓN DE CAPAS Y FONDO ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 290, 230);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            Image image = imageIcon.getImage().getScaledInstance(290, 230, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 290, 230);
            layeredPane.add(background, Integer.valueOf(0)); 
        }
        
        // Panel de Controles (Transparente)
		contentPane = new JPanel(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 290, 230);
        layeredPane.add(contentPane, Integer.valueOf(1)); 
        
		setContentPane(layeredPane); 
        
        // --- 2. ETIQUETAS Y CAMPOS ---
        
		// CÓDIGO (Icono de Código de Barras)
		JLabel lblCodigo = createIconLabel("CODIGO", ICONO_CODIGO); // Línea 98 corregida
		lblCodigo.setBounds(10, 36, 80, 25);
		contentPane.add(lblCodigo);
		
		txt_codigo = new JTextField();
		txt_codigo.setBounds(90, 36, 170, 25);
		contentPane.add(txt_codigo);
		txt_codigo.setColumns(10);
		
		// BOTÓN BUSCAR
		btn_buscar = new JButton("BUSCAR");
        btn_buscar.setBackground(new Color(33, 150, 243)); 
        btn_buscar.setForeground(Color.WHITE);
        btn_buscar.setFont(LABEL_FONT);
		btn_buscar.setBounds(20, 95, 120, 35);
        btn_buscar.setIcon(getScaledIcon(ICONO_BUSCAR, 20));
		contentPane.add(btn_buscar);
		
		// BOTÓN CANCELAR
		btn_cancelar = new JButton("CANCELAR");
        btn_cancelar.setBackground(new Color(244, 67, 54)); 
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setFont(LABEL_FONT);
		btn_cancelar.setBounds(150, 95, 120, 35);
        btn_cancelar.setIcon(getScaledIcon(ICONO_CANCELAR, 20));
		contentPane.add(btn_cancelar);
	}
    
    // --------------------------------------------------------------------------
    // MÉTODOS AUXILIARES AÑADIDOS (SOLUCIÓN)
    // --------------------------------------------------------------------------

    /**
     * Método auxiliar que crea el JLabel con el icono escalado y resuelve el error de método indefinido.
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