<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rekisteröidy</title>
</head>
<body>

	<c:if test="${not empty param.onnistui }">
		<p class="Viesti">Rekisteröityminen onnistui!</p>
	</c:if>

	<c:if test="${not empty error }">
		<p class="Virhe">
			<c:out value="${error}" />
		</p>
	</c:if>
	
	<div id="register">

		<form action="rekisteroidy" method="post">
			<h1>Rekisteröityminen</h1>
			<table>
				<tr>
					<td>Etunimi</td>
					<td><input type="text" name="etunimi" /></td>
				</tr>
				<tr>
					<td>Sukunimi</td>
					<td><input type="text" name="sukunimi" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="<c:out value="${prev_reg_email}"/>"/></td>
				</tr>
				<tr>
					<td>Käyttäjätunnus</td>
					<td><input type="text" name="kayttajatunnus" value="<c:out value="${prev_reg_username}"/>"/></td>
				</tr>
				<tr>
					<td>Salasana</td>
					<td><input type="password" name="salasana" /></td>
				</tr>
				<tr>
					<td>Salasana uudestaan</td>
					<td><input type="password" name="salasana2" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button type="submit">Rekisteröidy</button></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>