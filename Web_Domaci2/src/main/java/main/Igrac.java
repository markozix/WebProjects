package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;

public class Igrac {

	private Random tag = new Random();
	private int brIgraca;
	
	public Igrac() throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost", 2019);
		
		BufferedReader socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter socket_out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		brIgraca = tag.nextInt(1000);
		
		String poruka;
		
		Scanner sc = new Scanner(System.in);
		
		//saljemo ime igraca
		socket_out.println("Igrac" + brIgraca);
		
		while(true) {
			
			poruka = socket_in.readLine();
			
			//provjera ako nema mjesta gasi igraca
			if(poruka.equals("Nema mjesta")) {
				socket.close();
				break;
			}else {
			
				
				System.out.println("Krupijer: " + poruka);
				System.out.println(socket_in.readLine());
				socket_out.println(sc.nextLine());
				
				
				
			}
			
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			new Igrac();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
