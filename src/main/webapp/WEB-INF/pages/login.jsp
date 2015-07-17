<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="/loginresult.html" , method="post" >

        <table>
            <tr>
                <td>Login: </td>
                <td><input type="text" name="userName" /></td>
            </tr>

            <tr>
                <td>Password: </td>
                <td><input type="text" name="password" /></td>
            </tr>
        </table>

        <input type="submit" value="Submit" />
    </form>

</body>
</html>
