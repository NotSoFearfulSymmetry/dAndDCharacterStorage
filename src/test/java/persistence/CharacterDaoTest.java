package edu.matc.persistence;

import entity.User;
import entity.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.CharacterDao;
import persistence.UserDao;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/** Unit test for CharacterDao
 *
 * @author Paula Waite
 */
class CharacterDaoTest {

    UserDao userDao;
    CharacterDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute SQL which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("setupTestDatabase.sql");
        dao = new CharacterDao();
        userDao = new UserDao();
    }

    /**
     * Verify successful retrieval of a Character
     */
    @Test
    void getByIdSuccess() {
        //TODO: ask about a way to do this with hashcode and .equals()
        Character retrievedCharacter = dao.getById(1);
        assertEquals("George Longshanks", retrievedCharacter.getName());
        assertEquals("human", retrievedCharacter.getRace());
        assertEquals("male", retrievedCharacter.getGender());
        assertEquals("Fighter 9", retrievedCharacter.getClassAndLevel());
    }

    /**
     * Verify successful insertion of a Character
     */
    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Character newCharacter = new Character("Vanessa Gearloose", "gnome", "female", "Sorcerer 12", 6, 7, 11, 13, 13, 15, 26, "Bluff 15, Concentration 15, Spellcraft 15", "Combat Casting, Silent Spell, Still Spell, Empower Spell, Maximize Spell", "Summon familiar, 9/5/5/4/3/2/1 spells known, 6/6/6/6/6/5/3 spells per day", "Ring of Minor Spell Storing, Wand of Magic Missile", "I'm a petite powerhouse who likes bringing wonder into the lives of the people around me!", "Well, it all started when I woke up to find my bed was on fire.  That was when I learned I had inborn arcane powers...", true, "RogueOneThird", user);
        user.addCharacter(newCharacter);
        int id = dao.insert(newCharacter);
        assertNotEquals(0, id);
        Character insertedCharacter = dao.getById(id);
        assertNotNull(insertedCharacter);
        assertNotNull(insertedCharacter.getUser());
        assertEquals(newCharacter, insertedCharacter);
    }

    /**
     * Verify successful update of a Character
     */
    @Test
    void updateSuccess() {
        String newName = "Miri the Clumsy";
        Character characterToUpdate = dao.getById(2);
        characterToUpdate.setName(newName);
        dao.saveOrUpdate(characterToUpdate);
        Character characterAfterUpdate = dao.getById(2);
        assertEquals(newName, characterAfterUpdate.getName());
    }

    /**
     * Verify successful deletion of a Character
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all Characters
     */
    @Test
    void getAllSuccess() {
        List<Character> characters = dao.getAll();
        assertEquals(3, characters.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Character> characters = dao.getByPropertyEqual("race", "elf");
        assertEquals(1, characters.size());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Character> characters = dao.getByPropertyLike("name", "shanks");
        assertEquals(1, characters.size());
    }
}