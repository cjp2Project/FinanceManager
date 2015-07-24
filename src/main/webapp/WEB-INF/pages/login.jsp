<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>


    <link href="<c:url value="/resources/static/css/login.css" />" rel="stylesheet">

</head>
<body>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
    Bad username/password<br>
    Type again
</c:if>

        <div class="login">
            <form action="/j_spring_security_check" method="POST">

                <input id="username" name="username" type="text" placeholder="username"/><br>

                <input id="password" name="password" type="password" placeholder="password"/><br>

                <input type="submit" value="Log in"/>

            </form>
        </div>





</body>
</html>
