<%--
  Created by IntelliJ IDEA.
  User: bszewczyk
  Date: 2015-07-21
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add shopping item</title>
    <table>
        <tr>
            <td>User name</td>
            <td>${user.userName} </td>
        </tr>

        <tr>
            <td>user email:</td>
            <td>${user.email}</td>
        </tr>
    </table>

    <h2>Add shopping item</h2>

    <form method="post" action="/user/afteraddingItem.html">
        <table>
            <tr>
                <td>User id:</td>
                <td><input type="number" name="userId" value="${user.id}" disabled/></td>
            </tr>

            <tr>
                <td>Enter shopping date (yyyy/MM/dd):</td>
                <td><input type="text" name="date"/></td>
            </tr>

            <tr>
                <td>Select shop:</td>
                <td>
                    <select name="shop">
                        <c:forEach var="shop" items="${shops}">
                            <option value="${shop.id}">${shop}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Select shopping category:</td>
                <td>
                    <select name="shoppingCategory">
                        <c:forEach var="category" items="${shoppingCategories}">
                            <option value="${category.id}">${category}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Select currency:</td>
                <td>
                    <select name="currency">
                        <c:forEach var="currency" items="${currencies}">
                            <option value="${currency.id}">${currency}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Enter amount of money spent:</td>
                <td><input type="text" name="amount"/></td>s
            </tr>

            <tr>
                <td>Description (e.g.: items bought):</td>
                <td><input type="text" name="description"/></td>s
            </tr>
        </table>

        <input type="submit" value="add"/>
    </form>

</head>
<body>

</body>
</html>
