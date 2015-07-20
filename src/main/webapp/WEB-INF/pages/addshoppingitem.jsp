<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<c:url var="addAction" value="/user/addshoppingitemresult.html"></c:url>
<form action="${addAction}" modelAttribute="shopping_item">
    <table>

        <tr>
            <td>User name:</td>
            <td>${user.userName}</td>
        </tr>

        <tr>
            <td>Please select shop:</td>
            <td><form:select path="shop">
                <form:option value="" label="...."/>
                <form:options items="${shops}"/>
            </form:select>
            </td>
        </tr>

        <tr>
            <td>Please select currency:</td>
            <td><form:select path="currency">
                <form:option value="" label="...."/>
                <form:options items="${currencies}"/>
            </form:select>
            </td>
        </tr>

        <tr>
            <td>Please select category:</td>
            <td><form:select path="category">
                <form:option value="" label="...."/>
                <form:options items="${categories}"/>
            </form:select>
            </td>
        </tr>

        <%--<tr>--%>
        <%--<td>Date:</td>--%>
        <%--<td><input type="text" name="date"/></td>--%>
        <%--</tr>--%>

        <tr>
            <td>Amount:</td>
            <td><input type="text" name="amount"/></td>
        </tr>

        <tr>
            <td>Description:</td>
            <td><input type="text" name="description"/></td>
        </tr>

        <%--<tr>--%>
        <%--<td>Receipt:</td>--%>
        <%--<td><input type="text" name="receipt"/></td>--%>
        <%--</tr>--%>
    </table>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
</body>
</html>