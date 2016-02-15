<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tuntilistaus</title>
</head>
<body>

	<!--  <form action="tunnit" method="post">-->
	<table>
		<h1>Tunnit</h1>
		<thead>
			<tr>
				<td>ID</td>
				<td>PVM</td>
				<td>Tunnit</td>
				<td>Selite</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tunnit}" var="h">
				<tr>
					<td><c:out value="${h.kayttaja_id}" /></td>
					<td><c:out value="${h.pvm}" /></td>
					<td><c:out value="${h.tuntien_maara}" /></td>
					<td><c:out value="${h.selite}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--  </form>-->

</body>
</html>