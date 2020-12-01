package persistence;

import entity.User;
import entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

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
        Database database = Database.getInstance();
        database.runSQL("setupTestDatabase.sql");
        dao = new UserDao();
        characterDao = new CharacterDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        //TODO: ask about a way to do this with hashcode and .equals()
        User retrievedUser = dao.getById(3);
        assertEquals("ElfLord", retrievedUser.getUserName());
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
        User newUser = new User("WeWillSquawkYou", "WeWillSquawkYou@yahoo.com");
        int userId = dao.insert(newUser);
        assertNotEquals(0, userId);
        User insertedUser = dao.getById(userId);
        assertNotNull(insertedUser);
        assertEquals(newUser, insertedUser);

        Character newCharacter = new Character("VanessaGearloose", "gnome", "female", "Sorcerer12", 6, 7, 11, 13, 13, 15, 26, "Skills", "Feats", "ClassFeatures", "Equipment", "Description", "Background", true, "RogueOneThird", newUser);
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
        List<User> users = dao.getByPropertyEqual("userName", "ElfLord");
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
