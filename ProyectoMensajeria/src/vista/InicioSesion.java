package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class InicioSesion {

	private JFrame frame;
	private JTextField jTextFieldNombreUsuario;
	private JTextField jTextFieldContrasenya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion window = new InicioSesion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 473, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIAR SESI\u00D3N");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 437, 14);
		frame.getContentPane().add(lblNewLabel);
		
		jTextFieldNombreUsuario = new JTextField();
		jTextFieldNombreUsuario.setBounds(53, 108, 353, 20);
		frame.getContentPane().add(jTextFieldNombreUsuario);
		jTextFieldNombreUsuario.setColumns(10);
		
		jTextFieldContrasenya = new JTextField();
		jTextFieldContrasenya.setBounds(53, 170, 353, 20);
		frame.getContentPane().add(jTextFieldContrasenya);
		jTextFieldContrasenya.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1.setBounds(53, 85, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(53, 145, 137, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
