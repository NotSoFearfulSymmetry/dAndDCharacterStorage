package persistence;

import entity.User;
import entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UserDao
 */
class UserDaoTest {
    GenericDao genericUser;
    GenericDao genericCharacter;

    /**
    * Run set up tasks before each test:
    * 1. execute SQL which deletes everything from the table and inserts records
    * 2. Create any objects needed in the tests
    */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("setupTestDatabase.sql");
        genericUser = new GenericDao(User.class);
        genericCharacter = new GenericDao(Character.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericUser.getById(1);
        assertEquals("ElfLord", retrievedUser.getUserName());
        assertEquals("WoodElvesAreBestElves@juno.com", retrievedUser.getEmail());
    }

    /**
    * Verify successful updating of a property
    */
    @Test
    void saveOrUpdateSuccess() {
        String newUsername = "YourAccountIsPwned";
        User retrievedUser = (User)genericUser.getById(2);
        retrievedUser.setUserName(newUsername);
        genericUser.saveOrUpdate(retrievedUser);
        User updatedUser = (User)genericUser.getById(2);
        assertEquals(newUsername, updatedUser.getUserName());
    }

    /**
     * Verify successful insertion of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("WeWillSquawkYou", "testPassword4", "WeWillSquawkYou@yahoo.com", null);
        int userId = genericUser.insert(newUser);
        assertNotEquals(0, userId);
        User insertedUser = (User)genericUser.getById(userId);
        assertNotNull(insertedUser);
        assertEquals(newUser, insertedUser);

        Character newCharacter = new Character("Vanessa Gearloose", "gnome", "female", "Sorcerer 12", 6, 7, 11, 13, 13, 15, 26, "Skills", "Feats", "Class Features", "Equipment", "Description", "Background", true, "RogueOneThird", insertedUser);
        int characterId = genericCharacter.insert(newCharacter);
        assertNotEquals(0, characterId);
        Character insertedCharacter = (Character)genericCharacter.getById(characterId);
        assertNotNull(insertedCharacter);
        assertEquals(newCharacter, insertedCharacter);
    }

    /**
     * Verify successful deletion of a user
     */
    @Test
    void deleteSuccess() {
        genericUser.delete(genericUser.getById(3));
        assertNull(genericUser.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericUser.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericUser.getByPropertyEqual("userName", "ElfLord");
        assertEquals(1, users.size());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericUser.getByPropertyLike("email", "burn");
        assertEquals(1, users.size());
    }
}
