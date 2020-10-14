package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    /**
    * Run set up tasks before each test:
    * 1. execute SQL which deletes everything from the table and inserts records
    * 2. Create any objects needed in the tests
    */
    @BeforeEach
    void setUp() {
        test.util.Database database = test.util.Database.getInstance();
        database.runSQL("setupDatabase.sql");
        dao = new UserDao();
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertEquals("Herbert Schilt", retrievedUser.getAuthor());
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedUser.getTitle());
        assertEquals("978-0071809252", retrievedUser.getIsbn());
        assertEquals(2014, retrievedUser.getPublicationYear());
    }

    /**
    * Verify successful updating of a property
    */
    @Test
    void saveOrUpdateSuccess() {
        Book retrievedBook = dao.getById(2);
        retrievedBook.setTitle("This is the New Title");
        dao.saveOrUpdate(retrievedBook);
        assertEquals("This is the New Title", retrievedBook.getTitle());
        assertEquals("joseph ottinger", retrievedBook.getAuthor());
        assertEquals("978-1-4842-2319-2", retrievedBook.getIsbn());
        assertEquals(2016, retrievedBook.getPublicationYear());
    }

    /**
     * Verify successful insertion of a user
     */
    @Test
    void insertSuccess() {
        Book newBook = new Book("How to Save a Life", "The Fray", "867-5309", 2009);
        int id = dao.insert(newBook);
        assertNotEquals(0,id);
        Book insertedBook = dao.getById(id);
        assertEquals("How to Save a Life", insertedBook.getTitle());
        assertEquals("The Fray", insertedBook.getAuthor());
        assertEquals("867-5309", insertedBook.getIsbn());
        assertEquals(2009, insertedBook.getPublicationYear());
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
        List<Book> books = dao.getAll();
        assertEquals(3, books.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Book> books = dao.getByPropertyEqual("title", "Beginning Hibernate");
        assertEquals(1, books.size());
        assertEquals(2, books.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Book> books = dao.getByPropertyLike("author", "Kat");
        assertEquals(1, books.size());
    }
}
