<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tuntilistaus</title>
</head>
<body>
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
	<p><a href="">Takaisin</a></p>
</body>
</html>
