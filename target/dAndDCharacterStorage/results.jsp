<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h1>Welcome, userName!</h1>
    <h2>Here are your characters:</h2>
    <table>
        <c:forEach var="character" items="${characters}">
            <tr>
                <td>${character.name}</td>
                <td>${character.race}</td>
                <td>${character.class}</td>
                <td>${character.hitPoints}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
