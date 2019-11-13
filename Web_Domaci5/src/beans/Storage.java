package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

	private HashMap<String, String> mapa = new HashMap<>();
	private String key;
	private String value;
	
	public Storage() {
		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HashMap<String, String> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<String, String> mapa) {
		this.mapa = mapa;
	}
	
	
	
}
