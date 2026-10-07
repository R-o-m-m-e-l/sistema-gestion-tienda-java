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

public class registrar_producto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_codigo;
	public JTextField txt_producto;
	public JTextField txt_unidades;
	public JTextField txt_precio;
	public JTextField txt_provedor;
	public JButton btn_reistrar;
	public JButton btn_cancelar;

    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg";
    private final String ICONO_CODIGO = "/Imagenes/Codigo.png";
    private final String ICONO_PAQUETE = "/Imagenes/paquete.png";
    private final String ICONO_UNIDADES = "/Imagenes/Unidades.png";
    private final String ICONO_PRECIO = "/Imagenes/Precio.png";
    private final String ICONO_PERSONA = "/Imagenes/Persona.png"; // Usamos para Proveedor
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
					registrar_producto frame = new registrar_producto();
					new controller.logic_Rproducto(frame);
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
	public registrar_producto() {
		setTitle("MEGATIENDAS - Registrar Producto");
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
		JLabel lblCodigo = createIconLabel("CÓDIGO", ICONO_CODIGO);
		lblCodigo.setBounds(25, 22, 100, 25);
		contentPane.add(lblCodigo);
		
		// 2. PRODUCTO
		JLabel lblProducto = createIconLabel("PRODUCTO", ICONO_PAQUETE);
		lblProducto.setBounds(25, 49, 100, 25);
		contentPane.add(lblProducto);
		
		// 3. UNIDADES
		JLabel lblUnidades = createIconLabel("UNIDADES", ICONO_UNIDADES);
		lblUnidades.setBounds(25, 76, 100, 25);
		contentPane.add(lblUnidades);
		
		// 4. PRECIO
		JLabel lblPrecio = createIconLabel("PRECIO", ICONO_PRECIO);
		lblPrecio.setBounds(25, 103, 100, 25);
		contentPane.add(lblPrecio);
		
		// 5. PROVEDOR
		JLabel lblProveedor = createIconLabel("PROVEEDOR", ICONO_PERSONA);
		lblProveedor.setBounds(25, 130, 100, 25);
		contentPane.add(lblProveedor);
		
		// CAMPOS DE TEXTO
		txt_codigo = new JTextField();
		txt_codigo.setBounds(122, 22, 259, 25);
		contentPane.add(txt_codigo);
		txt_codigo.setColumns(10);
		
		txt_producto = new JTextField();
		txt_producto.setBounds(122, 49, 259, 25);
		contentPane.add(txt_producto);
		txt_producto.setColumns(10);
		
		txt_unidades = new JTextField();
		txt_unidades.setBounds(122, 76, 259, 25);
		contentPane.add(txt_unidades);
		txt_unidades.setColumns(10);
		
		txt_precio = new JTextField();
		txt_precio.setBounds(122, 103, 259, 25);
		contentPane.add(txt_precio);
		txt_precio.setColumns(10);
		
		txt_provedor = new JTextField();
		txt_provedor.setBounds(122, 130, 259, 25);
		contentPane.add(txt_provedor);
		txt_provedor.setColumns(10);
		
		// BOTONES
		btn_reistrar = new JButton("REGISTRAR");
		btn_reistrar.setBounds(122, 185, 145, 35);
        btn_reistrar.setBackground(new Color(67, 160, 71)); // Verde de Registro
        btn_reistrar.setForeground(Color.WHITE);
        btn_reistrar.setIcon(getScaledIcon(ICONO_REGISTRAR, 20));
		contentPane.add(btn_reistrar);
		
		btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(122, 235, 145, 35);
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