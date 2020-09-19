<%@include file="head.jsp"%>
<html>
<body>

<h1>Welcome to the D & D Character Vault!</h1>
    <form method="get" action="${pageContext.request.contextPath}/searchCharacters">
        <input type="submit" id="signIn">Sign In
        <input type="submit" id="createAccount">Create Account
    </form>
</body>
</html>