<jsp:include page="head.jsp" />

<html>
<body>
    <h1>Behold, adventurer!</h1>
    <p>Before you are all the personas you have stored in the vault.
    If you would like to add, delete, or update a character, please
    lay your hand on the appropriate sigil.</p>

    <a href="addCharacter.jsp">Add</a>
    <a href="updateCharacter.jsp">Update</a>
    <a href="deleteCharacter.jsp">Delete</a>

    <table class="pure-table pure-table-horizontal">
        <tbody>
        <%--@elvariable id="characters" type="java.util.List"--%>
        <c:forEach var="character" items="${characters}">
            <tr><td>Name</td><td>${character.name}</td></tr>
            <tr><td>Race</td><td>${character.race}</td></tr>
            <tr><td>Gender</td><td>${character.gender}</td></tr>
            <tr><td>Class and Level</td><td>${character.classAndLevel}</td></tr>
            <tr><td>Strength</td><td>${character.strength}</td></tr>
            <tr><td>Dexterity</td><td>${character.dexterity}</td></tr>
            <tr><td>Constitution</td><td>${character.constitution}</td></tr>
            <tr><td>Intelligence</td><td>${character.intelligence}</td></tr>
            <tr><td>Wisdom</td><td>${character.wisdom}</td></tr>
            <tr><td>Charisma</td><td>${character.charisma}</td></tr>
            <tr><td>Hit Points</td><td>${character.hitPoints}</td></tr>
            <tr><td>Skills</td><td>${character.skills}</td></tr>
            <tr><td>Feats</td><td>${character.feats}</td></tr>
            <tr><td>Class Features</td><td>${character.classFeatures}</td></tr>
            <tr><td>Equipment</td><td>${character.equipment}</td></tr>
            <tr><td>Description</td><td>${character.description}</td></tr>
            <tr><td>Background</td><td>${character.background}</td></tr>
            <tr><td>Second User Access</td><td>${character.secondUserAccess}</td></tr>
            <tr><td>Second Username</td><td>${character.secondUsername}</td></tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>