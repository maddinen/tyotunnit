<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl -->
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Työtuntien kirjauslomake</title>
</head>
<body>
	<h1>Lisää työtunnit</h1>
	<form:form modelAttribute="tunti" method="post">
		Tunnus:<br> <input type="text" name="kayttaja_id"><br>
		Pvm:<br> <input type="text" name="pvm"><br>
		Tunnit:<br> <input type="text" name="tuntien_maara"><br>
		Selite:<br> <textarea name="selite"></textarea><br>
		<input type="submit" value="Tallenna">
	</form:form>
	<br>
	<a href="tunnit">Tuntilista</a>
	<a href="login">Kirjaudu sisään</a>

</body>
</html>