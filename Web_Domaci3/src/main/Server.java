package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static final int TCP_PORT = 2019;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(TCP_PORT);
			System.out.println("Server is running...");
			while(true){
				Socket sock = ss.accept();
				new Thread(new ServerThread(sock)).start();
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
