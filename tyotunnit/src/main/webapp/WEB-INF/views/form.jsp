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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Työtuntien kirjauslomake</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Include Bootstrap Datepicker -->
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>



<link href="<c:url value="/resources/styles/style.css" />"
	rel="stylesheet">


</head>

<body>
	<div id="THEcontainer">


		<!-- -------NAVIGATION-------- -->

		<div id="custom-bootstrap-menu" class="navbar navbar-default "
			role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-menubuilder">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse navbar-menubuilder">
					<ul class="nav navbar-nav " style="margin-left: 90px;">
						<li><a href="../tunti/uusi">Lisää tunti</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Näytä tunnit <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="../tuntilista/lista">Kaikki</a></li>
								<li><a href="../tuntilista/kayttajantunnit">Käyttäjän</a></li>
							</ul></li>
						<li><a href="../loginpage">Kirjaudu</a></li>
					</ul>
				</div>
			</div>
		</div>


		<!-- -------HEADLINEBOX-------- -->
		<div id="boxh2">
			<h2 id="h2">Anna työtuntisi</h2>
		</div>

		<!-- -------WHITEBOX start-------- -->
		<div id="box">

			<!-- -------FORM-------- -->
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
								style="width:40%;" cssErrorClass="VirheellinenKentta" /> <form:errors
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







		</div>
	</div>

	<p>
		<a href="../j_spring_security_logout"> Kirjaudu ulos</a>
	</p>

</body>


</html>