<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Työtuntien kirjauslomake</title>
</head>
<body>
	<h1>Lisää työtunnit</h1>
	<form>
		Tunnus*<br> <input type="text" name="kayttaja_id"><br>
		Pvm <br> <input type="text" name="pvm"><br>
		Tunnit*<br> <input type="text" name="tuntien_maara"><br>
		Selite<br> <textarea name="selite"></textarea><br>
		<input type="submit" value="Tallenna">
	</form>
	<br>
	<a href="tuntilista.jsp">Tuntilista</a>
	<a href="login.jsp">Kirjaudu sisään</a>

</body>
</html>