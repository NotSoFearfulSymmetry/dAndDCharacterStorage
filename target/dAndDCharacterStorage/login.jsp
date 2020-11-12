<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 9/20/15
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <form action="j_security_check" method="POST">
        <table>
            <tr><td>User name: <input type="text" name="j_username">
            <tr><td>Password: <input type="password" name="j_password">
            <tr><th><input type="submit" VALUE="Log In">
        </table>
    </form>
</body>
</html>


