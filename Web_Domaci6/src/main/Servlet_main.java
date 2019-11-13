package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.Asistent;

/**
 * Servlet implementation class Servlet_main
 */
@WebServlet(name = "Servlet_main", urlPatterns = {"/domaci6"})
public class Servlet_main extends HttpServlet {
	
	private ArrayList<Asistent> lista = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String ime = request.getParameter("asistent").toUpperCase();
		int ocjena = 0;
		
		if(!request.getParameter("ocjena").equals("")) {
			ocjena = Integer.parseInt(request.getParameter("ocjena"));
		}
		
		if(ime.equals("VUK")) {
			ocjena = 0;
		}
		if(!ime.equals("") && ocjena != 0) {
		
			Asistent a = new Asistent(ime, ocjena);
			lista.add(a);
			
		}
		
	
	
		request.setAttribute("array", lista);
		RequestDispatcher disp = request.getRequestDispatcher("/result.jsp");
		disp.forward(request, response);
		
		
	}

	public ArrayList<Asistent> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Asistent> lista) {
		this.lista = lista;
	}

	
	
	
	
	
}
