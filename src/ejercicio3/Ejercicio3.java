package ejercicio3;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio3 {

	public static void main(String[] args) {
		try {
			File f = new File("src\\ejercicio3\\Nombres.txt");
			Scanner sc = new Scanner(f);
			Set<String> nombres = new HashSet<>();
			System.out.println("nombrees sin filtrar: ");
			while(sc.hasNextLine()) {
				String nombre = sc.nextLine();
				System.out.println(nombre);
				nombres.add(nombre);
			}
			sc.close();
			System.out.println("nombres con set:\n"+nombres);
			
		} catch (Exception e) {
			System.out.println("Error en la lectura del fichero");
		}
	}
}
