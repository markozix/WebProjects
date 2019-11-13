package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import sun.dc.pr.Rasterizer;

public class ServerThread implements Runnable {
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	
	public ServerThread(Socket sock){
		this.client = sock;
		
		 try {
			//inicijalizacija ulaznog sistema
			in = new BufferedReader(
				        new InputStreamReader(
				          client.getInputStream()));
			
			//inicijalizacija izlaznog sistema
		    out = new PrintWriter(
		    	        new BufferedWriter(
		    	          new OutputStreamWriter(
		    	            client.getOutputStream())), true);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void run(){
		try {
			String komanda = in.readLine();
			String response = "";
			
			response = napraviOdogovor(komanda);
			
			//ovaj deo nam sluzi samo da bismo ispisali na konzoli servera ceo HTTP zahtev
			System.out.println("HTTP ZAHTEV KLIJENTA:\n");
			do{
				System.out.println(komanda);
				komanda = in.readLine();
			} while(!komanda.trim().equals(""));
			
			
		
			
			//treba odgovoriti browser-u po http protokolu:
			out.println(response);
			
			in.close();
			out.close();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String randomIzreka() {
		String rez = "";
		
		String izreke[] = {	"Jednostavnost �?ini ljude sretnima.",
							"Strategije koje trate vrijeme i iscrpljuju sredstva nikad ne uspijevaju.",
							"Sretno oženjen je samo onaj �?ovjek koji razumije svaku rije�? koju njegova žena nije rekla.",
							"Jednom prodan, zauvijek prodan.",
							"Ko rano rani sam u nju pada"
							};
		String autori[] = {	"Alicia Keys",
							"Donald Krause",
							"Alfred Hitchock",
							"Filip David",
							"Marko Vukicevic"	
							};
		
		Random rnd = new Random();
		int brojCitata = rnd.nextInt(5);
		
		
		rez = izreke[brojCitata] + " " + autori[brojCitata];
		
		return rez;
	}
	
	
	private String napraviOdogovor(String komanda){
		
		String retVal = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
		
		
		//provjera
		System.out.println("------------------------------------------- " +  komanda);
		
		if (komanda.contains("citati" )) {
			String s = randomIzreka();
			retVal += "<html><head><title>Odgovor servera</title></head>\n";
			retVal += "<body><h1>Citat: "+s+"</h1>\n";
			retVal += "</body></html>";
			
			System.out.println("HTTP odgovor:");
			System.out.println(retVal);
			
			
			
			
			
		}else {
			retVal = "niste unijeli kljucnu rijec citati";
		}
		return retVal;
		
	}
	
}
