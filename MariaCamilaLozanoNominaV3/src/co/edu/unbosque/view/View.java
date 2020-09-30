package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	public void escribirDato(String dato, String proyecto) {
		JOptionPane.showMessageDialog(null, dato, proyecto, JOptionPane.INFORMATION_MESSAGE);
	}

}
