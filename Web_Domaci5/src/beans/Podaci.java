package beans;

import java.util.ArrayList;

public class Podaci {
	
	
	private ArrayList<Storage> lista = new ArrayList<>();


	public Podaci(ArrayList<Storage> lista) {
		super();
		this.lista = lista;
	}

	public ArrayList<Storage> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Storage> lista) {
		this.lista = lista;
	}
	
	

}
