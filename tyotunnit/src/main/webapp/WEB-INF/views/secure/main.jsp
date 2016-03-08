<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SUOJATTU PÄÄSIVU</h1>

<h3>Sisäänkirjautuneena: <sec:authentication property="principal.kayttaja_id"/></h3>
 
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p>

</body>
</html>