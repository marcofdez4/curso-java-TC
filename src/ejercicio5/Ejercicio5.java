package ejercicio5;

import org.json.JSONArray;
import org.json.JSONObject;

public class Ejercicio5 {

	public static void main(String[] args) {
		JSONArray arrayJson = new JSONArray();
		
		JSONObject objeto1 = new JSONObject();
		objeto1.put("nombre", "Marco");
		objeto1.put("apellido", "Fernandez");
		objeto1.put("Ciudad", "Sevilla");
		objeto1.put("Edad", 24);
		objeto1.put("Email", "marco@indra.es");
		
		JSONObject objeto2 = new JSONObject();
		objeto2.put("nombre", "Pablo");
		objeto2.put("apellido", "Calle");
		objeto2.put("Ciudad", "Sevilla");
		objeto2.put("Edad", 24);
		objeto1.put("Email", "pablo@indra.es");
		
		JSONObject objeto3 = new JSONObject();
		objeto3.put("nombre", "Miguel");
		objeto3.put("apellido", "Reyes");
		objeto3.put("Ciudad", "Jaen");
		objeto3.put("Edad", 24);
		objeto1.put("Email", "miguel@indra.es");
		
		arrayJson.put(objeto1);
		arrayJson.put(objeto2);
		arrayJson.put(objeto3);
		
		
		
		System.out.println(arrayJson);
		
	}
}
