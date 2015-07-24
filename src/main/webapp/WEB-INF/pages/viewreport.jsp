<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Report</title>

    <h3>Report by categories</h3>
    <table id="Report">
        <tbody>
        <core:forEach var="items" items="${items}">
            <tr>
                <td>${items.key}</td>
                <td>${items.value}</td>
            </tr>
        </core:forEach>
        </tbody>
    </table>
</head>
<body>

</body>
</html>
