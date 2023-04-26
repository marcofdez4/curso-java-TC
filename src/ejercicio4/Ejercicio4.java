package ejercicio4;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame ("Ejercicio 4");
		JLabel etiqueta = new JLabel();
		
		
		
		try {
			URL url = new URL("https://s0.wklcdn.com/image_267/8037368/65079139/43082688.700x525.jpg");
			Image imagen = ImageIO.read(url);
			ImageIcon imagenArreglada = new ImageIcon(imagen.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH));
			etiqueta.setIcon(imagenArreglada);
			etiqueta.setForeground(Color.DARK_GRAY);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panelLabel = new JPanel();
		JPanel panelBoton = new JPanel();
		JButton boton = new JButton("Mostrar información");
		boton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Bienvenid@ a mi ciudad!");
				System.out.println("En Los Palacios y Villafranca hay un total de 38662 habitantes");
				System.out.println("Suele haber un clima cálido y agradable");
				System.out.println("La actividad más famosa en este pueblo es la agricultura, sobre todo el tomate");
				
				JFrame popup = new JFrame ("Información de mi ciudad");
				JLabel etiquetaPopup = new JLabel("<html><body>"
						+ "Bienvenid@ a mi ciudad! <br> "
						+ "En Los Palacios y Villafranca hay un total de 38662 habitantes <br>"
						+ "Suele haber un clima cálido y agradable <br>"
						+ "La actividad más famosa en este pueblo es la agricultura, sobre todo el tomate"
						+ "</body></html>");
				etiquetaPopup.setOpaque(true);
				etiquetaPopup.setForeground(Color.DARK_GRAY);
				etiquetaPopup.setBackground(Color.LIGHT_GRAY);
				popup.add(etiquetaPopup);
				popup.setSize(500,150);
				popup.setVisible(true);
				popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}	
		});
		panelLabel.add(etiqueta);
		panelBoton.add(boton);
		panelLabel.setLocation(700,700);
		panelBoton.setLocation(500,430);
		panelBoton.setSize(200,40);
		ventana.getContentPane().add(panelBoton);
		ventana.getContentPane().add(panelLabel);
		ventana.setSize(1200,800);
		ventana.setVisible(true);
	}
	
}
