<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>login result</title>

    <meta charset="utf-8">


    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <link href="<c:url value="/resources/static/css/demo.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/static/css/menu.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/static/js/menu.js" />"></script>

    <link href="<c:url value="/resources/static/css/jquery.dataTables.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/static/js/jquery.dataTables.js" />"></script>
    <script src="<c:url value="/resources/static/js/jquery.js" />"></script>

    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>



</head>

<div id='cssmenu'>
    <ul>
        <li class='active'><a href="/user/welcomePage.html"><span>Spends list</span></a></li>
        <li><a href="/user/addshoppingitem.html"><span>Add item</span></a></li>
        <li><a href=/user/viewreport${user.id}><span>View report</span></a></li>
        <li class='rightside'><a href="<c:url value="/j_spring_security_logout" />"><span>Logout</span></a></li>
    </ul>
</div>

<body>

<h2>Welcome ${user.userName}</h2>

<div align="center">

    <h3>List of your spends</h3>
    <table id="shoplist">
        <thead>
            <th class = "shop">Shop</th>
            <th class = "shop_adress">Shop Address</th>
            <th class = "items">Items</th>
            <th class = "amount">Amount</th>
            <th class = "currency">Currency</th>
            <th class = "date">Date</th>
            <th class = "delete">Delete</th>
            <th class = "edit">Edit</th>
        </thead>
        <tbody>
            <core:forEach var="shoppingItem" items="${user.shoppingItems}">
                <tr>
                    <td>${shoppingItem.shop.shopBranch.branchName}</td>
                    <td>${shoppingItem.shop.street}</td>
                    <td>${shoppingItem.description}</td>
                    <td>${shoppingItem.amount}</td>
                    <td>${shoppingItem.currency.currencyName}</td>
                    <td>${shoppingItem.date}</td>
                    <td><a href="<c:url value="/user/delete-shopping-item${shoppingItem.id}"/>">delete</a></td>
                    <td><a href="<c:url value="/user/editshoppingitem${shoppingItem.id}"/>">edit</a></td>
                </tr>
            </core:forEach>
        </tbody>
    </table>

    <br>


<script>
    $(function(){
        $("#shoplist").dataTable();
    })
</script>




</div>
</body>
</html>
