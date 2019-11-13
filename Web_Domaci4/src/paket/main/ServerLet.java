package paket.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Asistent;
import server_moj.Klijent;
import server_moj.Server;


@WebServlet(name = "ServerLet", urlPatterns = {"/ser1"})
public class ServerLet extends HttpServlet {
	
	private Server server;
	
	private static final long serialVersionUID = 1L;
    
    /**
     
     * @see HttpServlet#HttpServlet()
     */
    public ServerLet(){
        super();
       
       
        // TODO Auto-generated constructor stub
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Nije proradilo
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String asistent = request.getParameter("asistent");
		String ocj = request.getParameter("ocjena");
		
		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body><h1>Evo sta ste uneli:</h1>");
        out.println("Asistent: "+asistent+"<br />");
        out.println("Ocjena: "+ocj+"<br />");
        out.println("</body>");
        out.close();
		
        
        Socket socket = new Socket("localhost", 2019);
        BufferedReader socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter socket_out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		
		JSONObject json = new JSONObject();
		if(asistent.equals("Vuk")) {
			ocj = "0";
			json.append("grade", ocj);
		}else {
			json.append("grade", ocj);
		}
		String as = asistent.toUpperCase();
		json.append("name", as);
		
		//System.out.println(json);
		
		socket_out.println(json);
		socket.close();
		
		
		
		
		
		
		
	}

}
