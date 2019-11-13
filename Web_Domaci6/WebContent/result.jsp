
<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="app.Servlet_main"%>
<%@page import="model.Asistent"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>

	<%!
		
	private ArrayList<String> lista = new ArrayList();
	private ArrayList<Double> listaOcjena = new ArrayList();
	%>
	
	<%
	ArrayList<Asistent> l1 = (ArrayList<Asistent>)request.getAttribute("array");
	
	response.getWriter().write("Lista asistenata sa prosjecnom ocjenom");
	
	for(int i = 0;i<l1.size();i++){
		if(!lista.contains(l1.get(i).getName())){
			lista.add(l1.get(i).getName());
		}
	}
	
	int i = 0;
	int y = 0;
	int cnt = 0;
	int konacnaOcjena = 0;
	while(i < lista.size()){
		if(lista.get(i).equals(l1.get(y).getName())){
			konacnaOcjena += l1.get(y).getOcjena();
			cnt++;
			y++;
		}else{
			y++;
		}
		
		if(y == l1.size()){
			DecimalFormat f = new DecimalFormat("##.00");
			double roundOff = ((double)konacnaOcjena/cnt);
			listaOcjena.add(i, Double.parseDouble(f.format(roundOff)));
			i++;
			y = 0;
			cnt = 0;
			konacnaOcjena = 0;
		}
		
	}
	
	
	%>
	<br>
	<br>
	<%
	for(int k = 0;k<lista.size();k++){
	%>
	<br>
	<%= lista.get(k) + " " + listaOcjena.get(k)  %>
	<%
	}
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	%>
	<br>
	<br>
	<p>
	
	Datum i vrijeme: <%= dateFormat.format(date) %>
	</p>
	
	




</body>
</html>