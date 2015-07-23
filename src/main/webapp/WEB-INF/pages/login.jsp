<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    Bad username/password<br>
    Type again
</c:if>
    <form action="/j_spring_security_check" method="POST">
        <label for="username">username:</label>
        <input id="username" name="username" type="text"/><br>

        <label for="password">password:</label>
        <input id="password" name="password" type="password"/><br>

        <input type="submit" value="Log in"/>
    </form>
</body>
</html>
