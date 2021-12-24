package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.AbstractListModel;
import java.awt.Color;

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
		setBounds(100, 100, 558, 387);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setForeground(Color.BLACK);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1, 2, 3, 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new TitledBorder(null, "Privados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBounds(10, 199, 152, -187);
		getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBorder(new TitledBorder(null, "Grupales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_1.setBounds(194, 199, 152, -187);
		getContentPane().add(list_1);
		
		JList list_2 = new JList();
		list_2.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list_2.setBounds(377, 199, 152, -187);
		getContentPane().add(list_2);

	}

}
