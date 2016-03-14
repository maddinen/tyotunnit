<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


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

<link href="<c:url value="/resources/styles/style.css" />"
	rel="stylesheet">

<title>Tuntilistaus</title>
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
			<h2 id="h2">Tuntilistaus</h2>
		</div>

		<!-- -------WHITEBOX start-------- -->
		<div id="box" style="height: 80%;">



			<!-- -------SEARCHFORM-------- -->

			<form id="search-form" class="form-inline" role="form" method="post"
				action="${kayttajantunnit}">
				<div class="input-group">
					<input type="text" class="form-control search-form"
						placeholder="Etsi">
					<!--DO NOT NEED TRAILING SLASH "/" As HTML5 FORMS SLASHES ARE NO LONGER REQUIRED-->
					<span class="input-group-btn"><button type="submit"
							class="btn btn-primary search-btn" data-target="#search-form"
							name="q">
							<i class="fa fa-search"> <!--FONT AWESOME font @ "http://fortawesome.github.io/Font-Awesome/" -->
							</i>
						</button></span>
				</div>
			</form>


			<!-- -------RESULTS-------- -->
			<table class="table table-borderless">
				<c:forEach var="h" items="${kayttajanTunnit}">
					<tr>
						<td><c:out value="${h.kayttaja_id}" /></td>
						<td><c:out value="${h.paivamaara}" /></td>
						<td><c:out value="${h.tuntien_maara}" /></td>
						<td><c:out value="${h.selite}" /></td>
					</tr>
				</c:forEach>
			</table>
			<!-- <p>
				<a href="../tunti/uusi"><button class="myButton">Takaisin</button></a>
			</p>-->
		</div>
		<!-- WHITEBOX close -->
	</div>
	<!-- CONTAINER close -->
</body>
</html>
