<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2015-07-19
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop List</title>
</head>
<body>


<c:url var="addAction" value="/shoplist.html" ></c:url>
<form:form action="${addAction}" modelAttribute="shopping_item">
  <table>

    <tr>
      <td>
        <form:label path="user">
          <spring:message text="User"/>
        </form:label>
      </td>
      <td>
        <form:input path="user"/>
      </td>
    </tr>

    <tr>
      <td>
        <form:label path="shop">
          <spring:message text="Shop"/>
        </form:label>
      </td>
      <td>
        <form:input path="shop" />
      </td>
    </tr>


    <tr>
      <td>
        <form:label path="shoppingCategory">
          <spring:message text="Shopping Category"/>
        </form:label>
      </td>
      <td>
        <form:input path="shoppingCategory" />
      </td>
    </tr>

    <tr>
      <td>
        <form:label path="currency">
          <spring:message text="Currency"/>
        </form:label>
      </td>
      <td>
        <form:input path="currency" />
      </td>
    </tr>


    <tr>
      <td>
        <form:label path="date">
          <spring:message text="Date"/>
        </form:label>
      </td>
      <td>
        <form:input path="date" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="amount">
          <spring:message text="Amount"/>
        </form:label>
      </td>
      <td>
        <form:input path="amount" />
      </td>
    </tr>
    <tr>
    <tr>
      <td>
        <form:label path="description">
          <spring:message text="Description"/>
        </form:label>
      </td>
      <td>
        <form:input path="description" />
      </td>
    </tr>


      <td>
        <form:label path="receipt">
          <spring:message text="Receipt"/>
        </form:label>
      </td>
      <td>
        <form:input path="receipt" />
      </td>
    </tr>

    <input type="submit"
           value="<spring:message text="Add Shopping Item"/>" />
  </table>
</form:form>

<%--<form:form method="POST" modelAttribute="city">--%>
  <%--<table>--%>
    <%--<tr>--%>
      <%--<td>Please select:</td>--%>
      <%--<td><form:select path="cityName">--%>
        <%--<form:option value="" label="...." />--%>
        <%--<form:options items="${cities}" />--%>
      <%--</form:select>--%>
      <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
      <%--<td><input type="submit" name="submit" value="Submit"></td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
  <%--</table>--%>
<%--</form:form>--%>
</body>
</html>
