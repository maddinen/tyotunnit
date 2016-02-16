<%@page import="java.util.ArrayList"%>
<%@ page import="fi.softala.bean.Tunti"%>
<jsp:useBean id="tunnit" type="java.util.ArrayList<Tunti>"
	scope="request" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tuntilistaus</title>
</head>
<body>
	<%
		ArrayList<Tunti> tunnitlista = new ArrayList<Tunti>();
		tunnitlista = (ArrayList<Tunti>) request.getAttribute("tunnit");
	%>

	<table>
		<h1>Tunnit</h1>
		<tr>
			<td>ID</td>
			<td>Pvm</td>
			<td>Tunnit</td>
			<td>Selite</td>
		</tr>
		<%
			for (int i = 0; i < tunnit.size(); i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(tunnit.get(i).getKayttaja_id());
				out.println("</td>");
				out.println("<td>");
				out.println(tunnit.get(i).getPaivamaara());
				out.println("</td>");
				out.println("<td>");
				out.println(tunnit.get(i).getTuntien_maara());
				out.println("</td>");
				out.println("<td>");
				out.println(tunnit.get(i).getSelite());
				out.println("</td>");
				out.println("</tr>");
			}
		%>
	</table>

</body>
</html>