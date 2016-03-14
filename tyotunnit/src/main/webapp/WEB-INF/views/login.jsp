<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!--  CSS  -->
<link href="<c:url value="/resources/styles/style.css" />"
	rel="stylesheet">

<title>Kirjaudu sisään</title>
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
						<li><a href="tunti/uusi">Lisää tunti</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Näytä tunnit <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="tuntilista/lista">Kaikki</a></li>
								<li><a href="tuntilista/kayttajantunnit">Käyttäjän</a></li>
							</ul></li>
						<li><a href="loginpage">Kirjaudu</a></li>
					</ul>
				</div>
			</div>
		</div>


		<!-- -------HEADLINEBOX-------- -->
		<div id="boxh2">
			<h2 id="h2">Kirjaudu sisään</h2>
		</div>

		<!-- -------WHITEBOX start-------- -->
		<div id="box">

			<!-- -------FORM-------- -->
			<c:if test="${not empty loginerror}">
				<p class="Error">Sisäänkirjautuminen epäonnistui. Käyttäjätunnus
					tai salasana on syötetty väärin.</p>
			</c:if>

			<c:if test="${not empty loggedout}">
				<p class="Info">Uloskirjautuminen onnistui</p>
			</c:if>

			<form action="j_spring_security_check" method="post">
				<table>
					<tr>
						<td class="bold">Käyttäjätunnus:<input type='text' name='j_username' value='' class="enjoy-input"></td>
					</tr>
					<tr>
						<td class="bold" >Salasana:<input type='password' name='j_password' class="enjoy-input" /></td>
					</tr>
					<tr>
						<td><button type="submit" class="myButton">Kirjaudu</button></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

</body>
</html>