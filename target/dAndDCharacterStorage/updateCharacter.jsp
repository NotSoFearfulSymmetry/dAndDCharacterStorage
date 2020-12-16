<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="head.jsp" />

    <body>
    <p>To update this character, make the appropriate changes and click the button below.</p>
    <form class="pure-form pure-form-stacked" method="post" action="">
        <label for="name">Name</label>
        <input type="text" id="name" name="name">
        <label for="race">Race</label>
        <input type="text" id="race" name="race">
        <label for="gender">Gender</label>
        <input type="text" id="gender" name="gender">
        <label for="classAndLevel">Class and Level</label><br>
        <input type="text" id="classAndLevel" name="classAndLevel">
        <label for="strength">Strength</label>
        <input type="number" id="strength" name="strength">
        <label for="dexterity">Dexterity</label>
        <input type="number" id="dexterity" name="dexterity">
        <label for="constitution">Constitution</label>
        <input type="number" id="constitution" name="constitution">
        <label for="intelligence">Intelligence</label>
        <input type="number" id="intelligence" name="intelligence">
        <label for="wisdom">Wisdom</label>
        <input type="number" id="wisdom" name="wisdom">
        <label for="charisma">Charisma</label><br>
        <input type="number" id="charisma" name="charisma">
        <label for="hitPoints">Hit Points</label>
        <input type="number" id="hitPoints" name="hitPoints">
        <label for="skills">Skills</label>
        <input type="text" id="skills" name="skills">
        <label for="feats">Feats</label>
        <input type="text" id="feats" name="feats">
        <label for="classFeatures">Class Features</label>
        <input type="text" id="classFeatures" name="classFeatures">
        <label for="equipment">Equipment</label>
        <input type="text" id="equipment" name="equipment">
        <label for="description">Description</label>
        <input type="text" id="description" name="description">
        <label for="background">Background</label>
        <input type="text" id="background" name="background">
        <label for="secondUserAccess">Second User Access</label>
        <input type="radio" id="secondUserAccess" name="secondUserAccess">
        <label for="secondUsername">Second Username</label>
        <input type="text" id="secondUsername" name="secondUsername">
        <a href="characterUpdated.jsp">Save Updates</a>
    </form>
    </body>

</html>