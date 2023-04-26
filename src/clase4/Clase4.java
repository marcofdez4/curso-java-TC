package clase4;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clase4 {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Este es mi ejemplo de hola mundo!");
		JLabel etiqueta = new JLabel("Hola mundo!");
		
		ventana.add(etiqueta);
		ventana.setSize(800,600);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
