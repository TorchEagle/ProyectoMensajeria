package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class ChatsContactos extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatsContactos dialog = new ChatsContactos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ChatsContactos() {
		setBounds(100, 100, 450, 300);

	}

}
