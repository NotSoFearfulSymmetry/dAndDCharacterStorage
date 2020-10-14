package persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

import entity.Character;

/**
 * A class that represents a character data object.
 */
public class CharacterDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get character by ID
     * @param id the ID
     * @return the character
     */
    public Character getById(int id) {
        Session session = sessionFactory.openSession();
        Character character = session.get(Character.class, id);
        session.close();
        return character;
    }

    /**
     * update character
     * @param character character to be updated
     */
    public void saveOrUpdate(Character character) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(character);
        session.close();
    }

    /**
     * Inserts new character
     * @param character the character
     * @return the ID of the character
     */
    public int insert(Character character) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(character);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a character
     * @param character character to be deleted
     */
    public void delete(Character character) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(character);
        transaction.commit();
        session.close();
    }

    /**
     * Return a list of all characters
     *
     * @return the list
     */
    public List<Character> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Character> query = builder.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        List<Character> characters = session.createQuery(query).getResultList();
        logger.debug("The list of characters: " + characters);
        session.close();
        return characters;
    }

    /**
     * Gets one or more characters by matching an exact property value.
     * @param propertyName the property
     * @param value the value
     * @return the character or characters
     */
    public List<Character> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("Searching for character with " + propertyName + " = " + value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Character> query = builder.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Character> characters = session.createQuery(query).getResultList();
        session.close();
        return characters;
    }

    /**
     * Gets a character or characters by matching part of a property value.
     * @param propertyName the property
     * @param value the value
     * @return the character or characters
     */
    public List<Character> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("Searching for character with {} = {}",  propertyName, value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Character> query = builder.createQuery(Character.class);
        Root<Character> root = query.from(Character.class);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Character> characters = session.createQuery(query).getResultList();
        session.close();
        return characters;
    }
}
