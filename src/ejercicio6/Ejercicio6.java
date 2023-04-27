package ejercicio6;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.net.HttpURLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONObject;

public class Ejercicio6 {

	private static URL urlGatito;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame ventana = new JFrame ("Ejercicio 6 - Gatitos");
		JLabel etiqueta = new JLabel();
		
		
		
		try {
			URL endpoint = new URL("https://api.thecatapi.com/v1/images/search");
			HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
			con.connect(); //Establece la conexion.
			int tiempoDeRespuesta = con.getResponseCode();
			if (tiempoDeRespuesta != 200)
			{
				throw new RuntimeException("HttpResponseCode" + tiempoDeRespuesta);			
			}
			else
			{
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(endpoint.openStream());
				while (sc.hasNext())
				{
					informacion.append(sc.nextLine());
				}
				sc.close();
				
				System.out.println(informacion);
				
				String informacionSinCorchetes = informacion.toString().replace("[", "").replace("]", "");
				
				JSONObject data = new JSONObject(informacionSinCorchetes);
				urlGatito = new URL(data.getString("url"));
				JPanel panelLabel = new JPanel();
				JPanel panelBoton = new JPanel();
				JButton boton = new JButton("Mostrar nuevo gatito");
				boton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						setUrlGatito();
						Image imagenGatito;
						try {
							imagenGatito = ImageIO.read(urlGatito);
							ImageIcon imagenArreglada2 = new ImageIcon(imagenGatito.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH));
							etiqueta.setIcon(imagenArreglada2);
							etiqueta.validate();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}	
				});
				Image imagen = ImageIO.read(urlGatito);
				ImageIcon imagenArreglada = new ImageIcon(imagen.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH));
				etiqueta.setIcon(imagenArreglada);
				panelLabel.add(etiqueta);
				panelBoton.add(boton);
				panelLabel.setLocation(700,700);
				panelBoton.setLocation(300,430);
				panelBoton.setSize(200,40);
				panelLabel.setBackground(Color.PINK);
				panelBoton.setBackground(Color.PINK);
				ventana.getContentPane().add(panelBoton);
				ventana.getContentPane().add(panelLabel);
				ventana.setSize(800,550);
				ventana.setVisible(true);
				
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void setUrlGatito() {
		try {
			
			URL endpoint = new URL("https://api.thecatapi.com/v1/images/search");
			HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
			con.connect(); //Establece la conexion.
			int tiempoDeRespuesta = con.getResponseCode();
			if (tiempoDeRespuesta != 200)
			{
				throw new RuntimeException("HttpResponseCode" + tiempoDeRespuesta);			
			}
			else
			{
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(endpoint.openStream());
				while (sc.hasNext())
				{
					informacion.append(sc.nextLine());
				}
				sc.close();
				
				System.out.println(informacion);
				
				String informacionSinCorchetes = informacion.toString().replace("[", "").replace("]", "");
				
				JSONObject data = new JSONObject(informacionSinCorchetes);
				urlGatito = new URL(data.getString("url"));
			}
		} catch (Exception e) {
			System.out.println("Error inesperado");
		}
	}
}
