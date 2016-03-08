<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Työtuntien kirjauslomake</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="<c:url value="/resources/styles/style.css" />"
	rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/index.js" />"></script>


</head>

<body>
	<div id="container">
		<div id="boxh2">
			<h2>Anna työtuntisi</h2>
		</div>
		<div id="box">

			<spring:hasBindErrors name="tunti">
				<p class="Virheotsikko">Otsikko:</p>
				<div class="Virheblokki">
					<form:errors path="*" />
				</div>
			</spring:hasBindErrors>

			<form:form modelAttribute="tunti" method="post">

				<table>
					<tr>
						<td><form:label path="kayttaja_id">Tunnus:</form:label> <br />
							<form:input path="kayttaja_id" class="enjoy-input"
								cssErrorClass="VirheellinenKentta" /></td>
						<form:errors path="kayttaja_id" cssClass="Virheteksti" />
						<td></td>
					</tr>
					<tr>
						<td><form:label path="paivamaara">Pvm:</form:label> <br /> <form:input
								path="paivamaara" type="text" id="datepicker"
								class="enjoy-input" cssErrorClass="VirheellinenKentta" /> <form:errors
								path="paivamaara" cssClass="Virheteksti" /></td>
						<td><form:label path="tuntien_maara">Tunnit:</form:label> <br />
							<form:input path="tuntien_maara" class="enjoy-input"
								style="width:40%" cssErrorClass="VirheellinenKentta" /> <form:errors
								path="tuntien_maara" cssClass="Virheteksti" /></td>
					</tr>
					<tr>
						<td><form:label path="selite">Selite:</form:label> <br /> <form:input
								path="selite" class="enjoy-input"
								cssErrorClass="VirheellinenKentta" /></td>
						<td></td>
					</tr>
				</table>

				<button type="submit" class="myButton">Tallenna</button>

			</form:form>
			<br> <a href="../tuntilista/lista">Tuntilista</a> <a
				href="../login">Kirjaudu sisään</a>
		</div>
	</div>

	
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p>


</body>


</html>