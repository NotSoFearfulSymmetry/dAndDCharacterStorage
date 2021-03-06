package persistence;

import entity.Character;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CharacterDao
 */
class CharacterDaoTest {
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
     * Verify successful retrieval of a character
     */
    @Test
    void getByIdSuccess() {
        Character retrievedCharacter = (Character)genericCharacter.getById(1);
        assertEquals("George Longshanks", retrievedCharacter.getName());
        assertEquals("human", retrievedCharacter.getRace());
        assertEquals("male", retrievedCharacter.getGender());
        assertEquals("Fighter 9", retrievedCharacter.getClassAndLevel());
    }

    /**
     * Verify successful insertion of a character
     */
    @Test
    void insertSuccess() {
        User user = (User)genericUser.getById(1);
        Character newCharacter = new Character("Vanessa Gearloose", "gnome", "female", "Sorcerer 12", 6, 7, 11, 13, 13, 15, 26, "Skills", "Feats", "Class Features", "Equipment", "Description", "Background", true, "RogueOneThird", user);
        user.addCharacter(newCharacter);
        int id = genericCharacter.insert(newCharacter);
        assertNotEquals(0, id);
        Character insertedCharacter = (Character)genericCharacter.getById(id);
        assertNotNull(insertedCharacter);
        assertNotNull(insertedCharacter.getUser());
        assertEquals(newCharacter, insertedCharacter);
    }

    /**
     * Verify successful update of a character
     */
    @Test
    void updateSuccess() {
        String newName = "Miri the Clumsy";
        Character characterToUpdate = (Character)genericCharacter.getById(2);
        characterToUpdate.setName(newName);
        genericCharacter.saveOrUpdate(characterToUpdate);
        Character characterAfterUpdate = (Character)genericCharacter.getById(2);
        assertEquals(newName, characterAfterUpdate.getName());
    }

    /**
     * Verify successful deletion of a character
     */
    @Test
    void deleteSuccess() {
        genericCharacter.delete(genericCharacter.getById(3));
        assertNull(genericCharacter.getById(3));
    }

    /**
     * Verify successful retrieval of all characters
     */
    @Test
    void getAllSuccess() {
        List<Character> characters = genericCharacter.getAll();
        assertEquals(3, characters.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Character> characters = genericCharacter.getByPropertyEqual("race", "elf");
        assertEquals(1, characters.size());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Character> characters = genericCharacter.getByPropertyLike("name", "shanks");
        assertEquals(1, characters.size());
    }
}