<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP domaci5</title>
</head>
<body>




<form action="response.jsp">
	<select name="izbor">
	  <option value="choose">choose</option>
	  <option value="session">session</option>
	  <option value="request">request</option>
	  <option value="application">application</option>
	</select>
	
	
	
	
	
      Key: <input type="text" name="key" />
      Value: <input type="text" name="value" />
      <input type="submit" value="Submit" />
    </form>

</body>
</html>