package server_moj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.json.JSONObject;

import model.Asistent;
import paket.main.ServerLet;


public class Server {
	
	public ArrayList<JSONObject> listaAsistenata;
	
	public Server() throws IOException {
		ServerSocket server_socket = new ServerSocket(2019);
		System.out.println("Server je aktivan");
		this.listaAsistenata = new ArrayList<>();
		
		while(true) {
			
		
			Socket socket = server_socket.accept();
			//krupijer je tred
			Klijent k = new Klijent(socket,this);
			
			Thread thread = new Thread(k);
			thread.start();
			
			
			}
	}
	
	
	





	public ArrayList<JSONObject> getListaAsistenata() {
		return listaAsistenata;
	}








	public void setListaAsistenata(ArrayList<JSONObject> listaAsistenata) {
		this.listaAsistenata = listaAsistenata;
	}








	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}