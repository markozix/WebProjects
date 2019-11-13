package server_moj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import org.json.JSONObject;

import model.Asistent;

public class Klijent implements Runnable {
	private Socket socket;
	private Server server;
	private Asistent a;
	
	
	

	public Klijent(Socket socket, Server server) {
		super();
		this.socket = socket;
		//MARKO DEBILCINO INICIJALIZACIJA!!!!!!!!!!!!!!!!!!!!!!!
		this.server = server;
	}



	@Override
	public void run() {
		
		
		try {
			
			
			
				BufferedReader socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter socket_out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
				
				String msg = socket_in.readLine();
				
				//System.out.println(msg);
				
				JSONObject jsn = new JSONObject(msg);
				//System.out.println(jsn);
				server.getListaAsistenata().add(jsn);
				
				for(int i=0;i<server.getListaAsistenata().size();i++) {
					System.out.println(server.getListaAsistenata().get(i));
				}
				System.out.println("------------------------------------------------------------------------");
				
				socket.close();
				/*String[] bafer = msg.split(",");
				String ime = bafer[0].toUpperCase();
				int ocjena = Integer.parseInt(bafer[1]);
				
				if(ime == "Vuk") {
					ocjena = 0;
				}
				
				JSONObject jsn = new JSONObject();
				jsn.append("name", ime);
				jsn.append("ocjena", ocjena);
				
				
				server.getListaAsistenata().add(jsn);
				
				for(int i =0;i<server.getListaAsistenata().size();i++) {
					System.out.println(server.getListaAsistenata().get(i));
				}
				
				*/
				
				
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
