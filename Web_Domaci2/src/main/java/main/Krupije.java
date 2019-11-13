package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Krupije implements Runnable {

	private int[] stapici = {10,20,30,40,50,60};
	
	private KrupijeMain kpMain;
	private Socket socket;
	private String poruka;
	private Random random = new Random();
	private int redniBrIgraca = 0;
	private int low = 10;
	private int high = 70;
	private String msg;
	
	
	//ne stavljaj arrayListu ni za zivu glavu!
	
	
	
	public Krupije(Socket socket, KrupijeMain kpMain) {
		super();
		this.kpMain = kpMain;
		this.socket = socket;
		
		
	}



	public void run() {
		try {
			//podici sa 2 na 5 na kraju
			
			BufferedReader socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter socket_out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			while(true) {
				//probaj smao puniti niz, povecavas brojac i punis do 6 kad predje kazem kraj i startujes mec
				//to bi bilo u jednom ifu a u else bi
				//bio razrada same logike za igru
			boolean punSto = kpMain.isPun();
			int pun = kpMain.getP();
			String[] stoZaIgranje = kpMain.getStr();
			poruka = socket_in.readLine();
			int brOsobaZaStolom = kpMain.getBrOsoba();
			
			if(!punSto) {
				if(brOsobaZaStolom > 2) {
					
					kpMain.setPun(true);
					socket_out.println("Nema mjesta");
					socket.close();
					
				}
				stoZaIgranje[brOsobaZaStolom] = poruka;
				kpMain.setBrOsoba(brOsobaZaStolom + 1);
				System.out.println(stoZaIgranje[brOsobaZaStolom] + " je sjeo za sto");
				
				socket_out.println("Sacekajte da se sto napuni");
				//mora se promijeniti jer oni koji se vec konktuju ne registruju da je sto pun i ne krece igra
				//ostaju ovde ne prelaze u else ispod
				
				
			}
			else if(kpMain.isPun()){
				//krece igra da se izvrsava
				int stapic = random.nextInt(high-low) + low;
				
				
				
				
				socket_out.println("Pogadjate sa veci ili manji");
				msg = socket_in.readLine();
				socket_out.println(stoZaIgranje[redniBrIgraca++] + "Je izvukao stapic");
				int broj = 0;
				int izabraniBroj = 0;
				try {
					broj = Integer.parseInt(msg);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				if(broj > 0) {
					socket_out.println(stapici[broj]);
					izabraniBroj = stapici[broj];
				}
				else if(msg.contains("veci")) {
					if(izabraniBroj > 10) {
						System.out.println("dobijas bod");
					}
				}
				
				
				
				
					
					
					
				
			}
			
			
			
			
			
			
			
			
			
			/*if(!punSto) {
				if(pun <= 2) {
					//provjeravamo da li ima mjesta za stolom
					for(int i = 0; i <=2; i++) {
						
						if(niz[i].equals("")) {
							System.out.println("Ima mjesta za stolom");
							niz[i] = poruka;
							System.out.println(niz[i] + " je sjeo za sto");
							socket_out.println("Dobro dosli " + niz[i]);
							kpMain.setP(pun + 1);
							
							break;
						}
							
					}
				}else if(pun > 2){
					kpMain.setPun(true);
					for(int i =0; i <=2;i++) {
						System.out.println(niz[i]);
					}
					//mogli bi ovdje setovati da je sto pun
					
					socket_out.println("Nema mjesta");
					socket.close();
				}
			}else {
				//todo
				//ako je sto pun
				//ovo radi provjereno
				System.out.println("Sto je spreman za igru");
			}*/
			
			
					
				
					
		}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	
	
	
	
}
