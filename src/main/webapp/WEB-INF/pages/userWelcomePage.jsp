<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>login result</title>
</head>
<body>
<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
<br>

<h2>Welcome user: ${user.userName}</h2>

<div align="center">

    <h3>Shopping list</h3>
    <table border="1">
        <th>Shop</th>
        <th>Shop Address</th>
        <th>Items</th>
        <th>Amount</th>
        <th>Currency</th>
        <core:forEach var="shoppingItem" items="${user.shoppingItems}">
            <tr>
                <td>${shoppingItem.shop.shopBranch.branchName}</td>
                <td>${shoppingItem.shop.street}</td>
                <td>${shoppingItem.description}</td>
                <td>${shoppingItem.amount}</td>
                <td>${shoppingItem.currency.currencyName}</td>
            </tr>
        </core:forEach>
    </table>
    <form action="/user/addshoppingitem.html" method="get">
        <input type="submit" value="add item"/>
    </form>
</div>
</body>
</html>
