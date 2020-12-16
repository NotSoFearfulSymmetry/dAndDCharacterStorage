<jsp:include page="head.jsp" />

<html>
<body>
    <h1>Hold a moment, adventurer!</h1>
    <p>Before you proceed, we must verify your identity.</p>
    <form action="j_security_check" method="POST">
        <table class="pure-table pure-table-bordered">
            <tr><td>User name: <input type="text" name="j_username">
            <tr><td>Password: <input type="password" name="j_password">
            <tr><th><input type="submit" VALUE="Log In">
        </table>
    </form>
</body>
</html>


