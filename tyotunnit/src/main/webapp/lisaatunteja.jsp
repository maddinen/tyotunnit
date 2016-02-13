<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Työtuntien kirjauslomake</title>
</head>
<body>
	<h1>Lisää työtunnit</h1>
	<form:form action="lisaa" method="post" modelAttribute="h">
		<table>
			<tr>
				<td>Tunnus*</td>
				<td><form:input path="kayttaja" /></td>
			</tr>
			<tr>
				<td>Pvm</td>
				<td><form:input path="paivamaara" /></td>
			</tr>
			<tr>
				<td>Tunnit*</td>
				<td><form:input path="maara" /></td>
			</tr>
			<tr>
				<td>Selite</td>
				<td><form:input path="selite" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Tallenna"></td>
			</tr>

		</table>
	</form:form>
	<br>
	<a href="tuntilista.jsp">Tuntilista</a>
	<a href="login.jsp">Kirjaudu sisään</a>

</body>
</html>-->