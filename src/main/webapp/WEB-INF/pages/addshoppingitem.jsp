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

    <head>

        <meta charset="utf-8">


        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
        <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <link href="<c:url value="/resources/static/css/demo.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/static/css/menu.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/static/js/menu.js" />"></script>



        <div id='cssmenu'>
            <ul>
                <li><a href="/user/welcomePage.html"><span>Spends list</span></a></li>
                <li class='active'><a href="/user/addshoppingitem.html"><span>Add item</span></a></li>
                <li><a href='#'><span>View report</span></a></li>
                <li class='rightside'><a href="<c:url value="/j_spring_security_logout" />"><span>Logout</span></a></li>
            </ul>
        </div>



    <title>Add item</title>



    <h2>Add item to the shopping list</h2>

    <c:if test="${not empty errorMessage}">
        <c:out value="${errorMessage}"/>
    </c:if>

    <form method="post" action="/user/afteraddingItem.html">
        <table>

            <tr>
                <td>Enter shopping date (yyyy-MM-dd):</td>
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
<br>

        <button>Add
            <input type="submit" hidden/>

        </button>


    </form>
</head>



<body>

</body>
</html>
