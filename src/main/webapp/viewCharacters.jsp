<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="head.jsp" />

<body>
    <p>Here are all the characters you are currently storing.
    If you would like to add, delete, or update a character, please
    fill out the following form and click the appopriate button.</p>

    <form class="pure-form pure-form-aligned">
        <label for="username">Username:</label>
        <input type="text" id="username">
        <label for="password">Password:</label>
        <input type="password" id="password">
        <label for="characterName">Character's name:</label>
        <input type="text" id="characterName">

        <button type="submit" formaction="addCharacter.jsp">Add a Character</button>
        <button type="submit" formaction="updateCharacter.jsp">Update a Character</button>
        <button type="submit" formaction="deleteCharacter.jsp">Delete a Character</button>
    </form>
    <a href="addCharacter.jsp">Add a Character</a>
    <a href="updateCharacter.jsp">Update a Character</a>
    <a href="deleteCharacter.jsp">Delete a Character</a></td>
    <h2>Characters: </h2>
    <table id="charactersTable" class="pure-table pure-table-bordered">
        <thead>
        <th>Name</th>
        <th>Race</th>
        <th>Gender</th>
        <th>Class and Level</th>
        <th>Strength</th>
        <th>Dexterity</th>
        <th>Constitution</th>
        <th>Intelligence</th>
        <th>Wisdom</th>
        <th>Charisma</th>
        <th>Hit Points</th>
        <th>Skills</th>
        <th>Feats</th>
        <th>Class Features</th>
        <th>Equipment</th>
        <th>Description</th>
        <th>Background</th>
        <th>Second User Access</th>
        <th>Second Username</th>
        </thead>
        <tbody>
        <jsp:useBean id="characters" scope="request" type="java.util.List" />
        <c:forEach var="character" items="${characters}">
            <tr>
                <td>${character.name}</td>
                <td>${character.race}</td>
                <td>${character.gender} ${trail.lengthUnits}</td>
                <td>${character.classAndLevel}</td>
                <td>${character.strength}</td>
                <td>${character.dexterity}</td>
                <td>${character.constitution}</td>
                <td>${character.intelligence}</td>
                <td>${character.wisdom}</td>
                <td>${character.charisma}</td>
                <td>${character.hitPoints}</td>
                <td>${character.skills}</td>
                <td>${character.feats}</td>
                <td>${character.classFeatures}</td>
                <td>${character.equipment}</td>
                <td>${character.description}</td>
                <td>${character.background}</td>
                <td>${character.secondUserAccess}</td>
                <td>${character.secondUsername}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>