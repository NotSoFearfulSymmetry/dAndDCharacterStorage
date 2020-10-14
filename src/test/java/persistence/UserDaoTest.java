package persistence;

import entity.User;
import entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;
    CharacterDao characterDao;

    /**
    * Run set up tasks before each test:
    * 1. execute SQL which deletes everything from the table and inserts records
    * 2. Create any objects needed in the tests
    */
    @BeforeEach
    void setUp() {
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("setupTestDatabase.sql");
        dao = new UserDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertEquals("ElfLord", retrievedUser.getUserName();
        assertEquals("WoodElvesAreTheBest@juno.com", retrievedUser.getEmail());
    }

    /**
    * Verify successful updating of a property
    */
    @Test
    void saveOrUpdateSuccess() {
        String newUsername = "YourAccountIsPwned";
        User retrievedUser = dao.getById(2);
        retrievedUser.setUserName(newUsername);
        dao.saveOrUpdate(retrievedUser);
        User updatedUser = dao.getById(2);
        assertEquals(newUsername, updatedUser.getUserName());
    }

    /**
     * Verify successful insertion of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("IAmThatIAm", "lordGod@heaven.net");
        int userId = dao.insert(newUser);
        assertNotEquals(0, userId);
        User insertedUser = dao.getById(userId);
        assertNotNull(insertedUser);
        assertEquals(newUser, insertedUser);

        Character newCharacter = new Character('Vanessa Gearloose', 'gnome', 'female', 'Sorcerer 12', 6, 7, 11, 13, 13, 15, 26, 'Bluff 15, Concentration 15, Spellcraft 15', 'Combat Casting, Silent Spell, Still Spell, Empower Spell, Maximize Spell','Summon familiar, 9/5/5/4/3/2/1 spells known, 6/6/6/6/6/5/3 spells per day','Ring of Minor Spell Storing, Wand of Magic Missile','I\'m a petite powerhouse who likes bringing wonder into the lives of the people around me!', 'Well, it all started when I woke up to find my bed was on fire.  That was when I learned I had inborn arcane powers...');
        int characterId = characterDao.insert(newCharacter);
        assertNotEquals(0, characterId);
        Character insertedCharacter = characterDao.getById(characterId);
        assertNotNull(insertedCharacter);
        assertEquals(newCharacter, insertedCharacter);
    }

    /**
     * Verify successful deletion of a user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("username", "ElfLord");
        assertEquals(1, users.size());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("email", "burn");
        assertEquals(1, users.size());
    }
}
