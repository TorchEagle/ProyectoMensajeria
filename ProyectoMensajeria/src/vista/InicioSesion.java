package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import conexion.Conexion;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InicioSesion {

	private JFrame frame;
	private JTextField jTextFieldNombreUsuario;
	private JPasswordField jPasswordFieldContrasenya;

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
		
		JLabel jLabelIniciarSesion = new JLabel("INICIAR SESI\u00D3N");
		jLabelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
		jLabelIniciarSesion.setBounds(10, 11, 437, 14);
		frame.getContentPane().add(jLabelIniciarSesion);
		
		jTextFieldNombreUsuario = new JTextField();
		jTextFieldNombreUsuario.setBounds(53, 108, 353, 20);
		frame.getContentPane().add(jTextFieldNombreUsuario);
		jTextFieldNombreUsuario.setColumns(10);
		
		JLabel jLabelNombreUsuario = new JLabel("Nombre de usuario:");
		jLabelNombreUsuario.setBounds(53, 85, 110, 14);
		frame.getContentPane().add(jLabelNombreUsuario);
		
		JLabel jLabelContrasenya = new JLabel("Contrase\u00F1a:");
		jLabelContrasenya.setBounds(53, 145, 137, 14);
		frame.getContentPane().add(jLabelContrasenya);
		
		JButton jButtonIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		jButtonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jButtonIniciarSesion.setBounds(53, 201, 110, 23);
		frame.getContentPane().add(jButtonIniciarSesion);
		
		JButton jButtonRegistrarse = new JButton("Registrarse");
		jButtonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion.ConectarBDD();
		        String nom_usuario = jTextFieldNombreUsuario.getText();
		        char[] contrasenya = jPasswordFieldContrasenya.getPassword();
		        String stringContrasenya = String.valueOf(contrasenya);
		        
		        Conexion.RegistrarUsuario(nom_usuario, stringContrasenya);
			}
		});
		jButtonRegistrarse.setBounds(296, 201, 110, 23);
		frame.getContentPane().add(jButtonRegistrarse);
		
		jPasswordFieldContrasenya = new JPasswordField();
		jPasswordFieldContrasenya.setBounds(53, 170, 353, 20);
		frame.getContentPane().add(jPasswordFieldContrasenya);
	}
}
