<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>login result</title>
</head>
<body>
  <h1>ADMIN Clicked from login page</h1>

  <p>Current user: ${user}</p>
  <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</body>
</html>
