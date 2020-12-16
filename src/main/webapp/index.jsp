<jsp:include page="head.jsp" />

<html>
  <body>
    <h1>Welcome, adventurer, to the D&D Character Storage Vault!</h1>
    <p>Here you can keep track of your D&D characters between games, and have
    them available wherever and whenever you connect to the web.  You'll be
    able to add, remove, and update characters as needed.  You'll even be able
    to share access with a friend!</p>
    <p>If you're new to D&D, click
      <a href="https://www.polygon.com/deals/21294556/dnd-how-to-play-dungeons-dragons-5e-guide-spells-dice-character-sheets-dm">here</a>
      for an introduction.</p>
    <ul>
      <li><a href="newUser.jsp">Sounds great - sign me up!</a></li>
      <li><a href="viewCharacters.jsp">I'm already signed up - show me my characters!</a></li>
      <li><a href="admin.jsp">Take me to the admin page (admins only - all others
      will be fed to the tarrasque!)</a></li>
    </ul>
    <form action="getMonsters" method="get">
    <p>If you're interested in setting up one or more encounters for your party,
    enter a challenge rating here and get a list of some of the monsters that
      would keep them on their toes.  (Service provided by the
      <a href="http://www.dnd5eapi.co/">Dungeons & Dragons API</a>).</p>
    <input type="number"><button>Get that list</button>
    </form>
  </body>
</html>
