package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class KrupijeMain {
	private ArrayList<String> stoZaIgru = new ArrayList<String>(5);

	private String[] str  = {"","","","","",""};
	private int p = 0;
	private boolean pun = false;
	private int brOsoba = 0;
	
	public KrupijeMain() throws IOException {
		
		ServerSocket server_socket = new ServerSocket(2019);
		System.out.println("Krupije je aktivan");
		
		
		while(true) {
			
		
			Socket socket = server_socket.accept();
			//krupijer je tred
			Krupije krupije = new Krupije(socket,this);
			
			Thread thread = new Thread(krupije);
			thread.start();
			
			
		}
		
		
	}
	

	
	
	public static void main(String[] args) {
		
		try {
			new KrupijeMain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	public String[] getStr() {
		return str;
	}




	public int getP() {
		return p;
	}




	public void setP(int p) {
		this.p = p;
	}




	public void setStr(String[] str) {
		this.str = str;
	}




	public boolean isPun() {
		return pun;
	}




	public void setPun(boolean pun) {
		this.pun = pun;
	}




	public int getBrOsoba() {
		return brOsoba;
	}




	public void setBrOsoba(int brOsoba) {
		this.brOsoba = brOsoba;
	}






	
	
	

	
	
	
	
	
	

}
