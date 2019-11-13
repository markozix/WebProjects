package model;

import java.util.ArrayList;

import org.json.JSONObject;

public class Asistent {

	
	ArrayList<JSONObject> lista = new ArrayList<>();

	public Asistent() {
		super();
		
	}

	public ArrayList<JSONObject> getLista() {
		return lista;
	}

	public void setLista(ArrayList<JSONObject> lista) {
		this.lista = lista;
	}
	
	/*public static void main(String[] args) {
		Asistent a = new Asistent();
		System.out.println(a.getLista());
	}*/
	
	
	
	
	
}
