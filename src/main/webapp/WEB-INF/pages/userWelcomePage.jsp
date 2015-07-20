<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>login result</title>
</head>
<body>
<h1>USER Clicked from login page</h1>

<p>Current user name : ${user.userName}</p>
<p>Current user's email: ${user.email}</p>

<form action="/user/shoplist.html" method="get">
  <input type="submit" value="view shopping list" />
</form>

<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</body>
</html>
