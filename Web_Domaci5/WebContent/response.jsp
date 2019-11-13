<%@page import="java.util.HashMap"%>
<%@page import="beans.Storage"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEWARRAY"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.List"%>
<%@page import="javax.xml.ws.Response"%>
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
		public static HashMap<String,String > applicationHes = new HashMap<>();
	    public static HashMap<String,String > requestHes = new HashMap<>();
	    public static HashMap<String,String > sessionHes = new HashMap<>();
			
	%>
    
    <%
	
		response.getWriter().write( "Izabrani scope: " + request.getParameter("izbor" ) );
		String s = request.getParameter("izbor");
		
		if(request.getParameter("key") != null && request.getParameter("value") != null){
			if(s.equals("session")){
				sessionHes.put(request.getParameter("key"),	request.getParameter("value"));
				
			}else if (s.equals("request")){
				requestHes.put(request.getParameter("key"),	request.getParameter("value"));
			}else if (s.equals("application")){
				applicationHes.put(request.getParameter("key"),	request.getParameter("value"));
			}
		}
	%>
	
	
	<%
	
		if(sessionHes.size() != 0){

	%>
		<h1>Session</h1>
		<h3>Session ID</h3><%= session.getId() %>
	    <div style="background: blue;">
	        <%
	            for (String ses: sessionHes.keySet()) {
	        %>
	        <p>
	            <%= ses + ": " +  sessionHes.get(ses) %>
	        </p>
	        <%
	            }
	        %>
	    </div>
    <%} %>
    
		<%
	
		if(applicationHes.size() != 0){

	%>
		<h1>Application</h1>
	    <div style="background: red;">
	        <%
	            for (String apl: applicationHes.keySet()) {
	        %>
	        <p>
	            <%= apl + ": " +  applicationHes.get(apl) %>
	        </p>
	        <%
	            }
	        %>
	    </div>
    <%} %>
    
    
    	<%
	
		if(requestHes.size() != 0){

	%>
		<h1>Request</h1>
	    <div style="background: yellow;">
	        <%
	            for (String req: requestHes.keySet()) {
	        %>
	        <p>
	            <%= req + ": " +  requestHes.get(req) %>
	        </p>
	        <%
	            }
	        %>
	    </div>
    <%} %>
    
    
	

    
    
</body>
</html>