<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="head.jsp" />

<body>
    <form action="j_security_check" method="POST">
        <table class="pure-table pure-table-bordered">
            <tr><td>User name: <input type="text" name="j_username">
            <tr><td>Password: <input type="password" name="j_password">
            <tr><th><input type="submit" VALUE="Log In">
        </table>
    </form>
</body>
</html>


