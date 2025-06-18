package br.edu.ifsuldeminas.mch.sd.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import com.cedarsoftware.util.io.JsonReader;
import br.edu.ifsuldeminas.mch.sd.pojos.Person;

public class JSONReader {
	public static void main(String[] args) {
		Person emerson = null;
		File jsonFile = new File("person.json");
//		JsonReader jsonReader;
//		try {
//			jsonReader = new JsonReader(new FileInputStream(jsonFile));
//			emerson = (Person) jsonReader.readObject();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if (emerson != null) {
//			System.out.println(emerson);
//			System.out.println(emerson.getAddress());
//		}
	}
}