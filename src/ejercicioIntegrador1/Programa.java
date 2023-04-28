package ejercicioIntegrador1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Programa {

	private final static String NOMBRE_EMPRESA = "Iberia";

	public static void main(String[] args) {

		File f = new File("src\\ejercicioIntegrador1\\INFO_VUELOS.txt");

		List<Vuelo> vuelos = new ArrayList<>();
		try {
			Scanner sc = new Scanner(f);
			sc.nextLine();
			while (sc.hasNextLine()) {
				String vueloLinea = sc.nextLine();
				String[] vueloFormateado = lectorVuelo(vueloLinea);
				TipoPasaje tipoPasaje = null;
				if (vueloFormateado[2] == "ECONOMICO") {
					tipoPasaje = TipoPasaje.ECONOMICO;
				} else {
					tipoPasaje = TipoPasaje.PREMIER;
				}
				String[] fecha = vueloFormateado[4].split("/");
				Vuelo vuelo = new Vuelo(NOMBRE_EMPRESA, vueloFormateado[0], Integer.valueOf(vueloFormateado[1]),
						tipoPasaje, Double.valueOf(vueloFormateado[3]),
						LocalDate.of(Integer.valueOf(fecha[2]), Integer.valueOf(fecha[1]), Integer.valueOf(fecha[0])));
				vuelos.add(vuelo);
			}
			sc.close();
			// TODO: generar txt
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String rutaSalida = "src\\ejercicioIntegrador1\\salidaVuelos.txt";
			File archivoSalida = new File(rutaSalida);

			if (!archivoSalida.exists()) {
				archivoSalida.createNewFile();
			}
			
			FileWriter fw = new FileWriter(archivoSalida);
			BufferedWriter bw = new BufferedWriter(fw);
			Double montoFinal = 0.0;
			bw.write("PROGRAMA DE VUELOS\n");
			for(Vuelo v:vuelos) {
				bw.write("\nInformacion del vuelo "+v.getNombreVuelo());
				bw.write("\nValor final:  "+v.valorFinalPorVuelo());
				bw.write("\nDías de diferencia:  "+v.diasDeDiferencia());
				bw.write("\nsegmentacion:  "+v.segmentación());
				bw.write("\n----------------------------------------------------------------\n");
				montoFinal += v.valorFinalPorVuelo();
			}
			bw.write("\nMonto final:  "+montoFinal);
			bw.close();
			System.out.println("Programa finalizado con exito, tenga un buen dia");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String[] lectorVuelo(String linea) {
		String[] vuelo = linea.split("	");
		String[] vueloFormateado = new String[5];
		int pos = 0;
		for (String s : vuelo) {
			s = s.replace(" ", "");
			if (!s.contains("	") && !s.isEmpty() && pos < 5) {
				vueloFormateado[pos] = s;
				pos++;
			}
		}
		return vueloFormateado;
	}
}
