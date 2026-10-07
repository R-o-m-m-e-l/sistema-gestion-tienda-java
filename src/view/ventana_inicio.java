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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane; 

public class ventana_inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton btn_ingresar;
	public JTextField txt_nombre;
	public JTextField txt_password;
	public JButton btn_salir;
    
    // Rutas de Recursos
    private final String RUTA_FONDO = "/Imagenes/Fondo.jpg"; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_inicio frame = new ventana_inicio();
					 new controller.logic_vInicio(frame);
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
	public ventana_inicio() {
		setTitle("MEGATIENDAS - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
        
        // --- 1. AÑADIR IMAGEN DE FONDO Y CAPAS ---
        URL urlFondo = getClass().getResource(RUTA_FONDO);
        
        if (urlFondo != null) {
            ImageIcon imageIcon = new ImageIcon(urlFondo);
            // Escalar la imagen para ajustarla al tamaño de la ventana
            Image image = imageIcon.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(image));
            background.setBounds(0, 0, 350, 300);
            
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setBounds(0, 0, 350, 300);
            layeredPane.add(background, Integer.valueOf(0));
            
            // Crear un JPanel transparente para colocar los controles
            JPanel controlsPanel = new JPanel(null); 
            controlsPanel.setOpaque(false); // Hacemos transparente para ver el fondo
            controlsPanel.setBounds(0, 0, 350, 300);
            layeredPane.add(controlsPanel, Integer.valueOf(1));
            
            contentPane = controlsPanel; // Redirigir todos los componentes a este panel
            setContentPane(layeredPane);
        } else {
            // Fallback si no se encuentra la imagen (similar al error 303)
            contentPane.setBackground(new Color(240, 240, 240));
            setContentPane(contentPane);
        }
		
        // --- 2. ETIQUETAS Y CAMPOS ---
        
        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.BLACK); 
        lblTitulo.setBounds(70, 20, 200, 25);
        contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("USUARIO (Correo):");
        lblNewLabel.setForeground(Color.BLACK); 
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 60, 110, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA:");
        lblNewLabel_1.setForeground(Color.BLACK); 
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 95, 110, 20);
		contentPane.add(lblNewLabel_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(140, 60, 180, 25);
		contentPane.add(txt_nombre);
		
		txt_password = new JTextField(); 
		txt_password.setBounds(140, 95, 180, 25);
		contentPane.add(txt_password);
		
        // --- 3. BOTONES CON COLORES SÓLIDOS (SIN ICONOS) ---
        
		btn_ingresar = new JButton("INGRESAR");
        btn_ingresar.setBackground(new Color(76, 175, 80)); // Verde (#4CAF50)
        btn_ingresar.setForeground(Color.WHITE);
        btn_ingresar.setFont(new Font("Arial", Font.BOLD, 12));
		btn_ingresar.setBounds(30, 150, 135, 35);
		contentPane.add(btn_ingresar);
		
		btn_salir = new JButton("SALIR");
        btn_salir.setBackground(new Color(244, 67, 54)); // Rojo (#F44336)
        btn_salir.setForeground(Color.WHITE);
        btn_salir.setFont(new Font("Arial", Font.BOLD, 12));
		btn_salir.setBounds(185, 150, 135, 35);
		contentPane.add(btn_salir);
	}
}