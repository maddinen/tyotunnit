<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/styles/style.css" />"
	rel="stylesheet">
<title>Tuntilistaus</title>
</head>
<body>

	<div id="container" style="height: 600px;">
		<div id="boxh2">
			<h2>Tuntilistaus</h2>
		</div>
		<div id="box" style="height: 80%;">


			<table>
				<c:forEach var="h" items="${tunnit}">
					<tr>
						<td><c:out value="${h.kayttaja_id}" /></td>
						<td><c:out value="${h.paivamaara}" /></td>
						<td><c:out value="${h.tuntien_maara}" /></td>
						<td><c:out value="${h.selite}" /></td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<a href="../tunti/uusi">Takaisin</a>
			</p>
		</div>
	</div>
</body>
</html>
