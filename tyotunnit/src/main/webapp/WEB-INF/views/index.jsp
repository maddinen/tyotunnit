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
		<fieldset>
		<legend>Tiedot</legend>
			<p>
				<form:label path="kayttaja_id">Tunnus:</form:label>	<br />
				<form:input path="kayttaja_id" />
			</p>
			<p>
				<form:label path="paivamaara">Pvm:</form:label><br />
				<form:input path="paivamaara" />
			</p>
			<p>
				<form:label path="tuntien_maara">Tunnit:</form:label><br/>
				<form:input path="tuntien_maara" />
			</p>
			<p>
				<form:label path="selite">Selite:</form:label><br />
				<form:input path="selite" />
			</p>
			<button type="submit">Tallenna</button>
		</fieldset>
	</form:form>
	<br>
	<a href="tuntilista">Tuntilista</a>
	<a href="login">Kirjaudu sisään</a>

</body>
</html>