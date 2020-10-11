package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.SessionFactoryProvider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new GenericDao
     *
     * @param type the entity type (e.g., User)
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Get entity by ID
     *
     * @param id the ID
     *
     * @return the entity
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Delete entity
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Get a list of all entities
     *
     * @return the list
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> entities = session.createQuery(query).getResultList();
        logger.debug("The list of entities: " + entities);
        session.close();
        return entities;
    }

    /**
     * Update entity
     *
     * @param entity entity to be updated
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        session.saveOrUpdate(entity);
        session.close();
    }

    /**
     * Insert new entity
     *
     * @param entity the entity
     *
     * @return the ID of the entity
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Get a list of entities by matching an exact property value
     *
     * @param propertyName the property
     *
     * @param value the value
     *
     * @return the list
     */
    public List<User> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();
        logger.debug("Searching for entities with " + propertyName + " = " + value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery(query).getResultList();
        logger.debug("Matching entities: " + entities);
        session.close();
        return entities;
    }

    /**
     * Get a list of entities by matching part of a property value
     *
     * @param propertyName the property
     *
     * @param value the value
     *
     * @return the list
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();
        logger.debug("Searching for entities with {} = {}",  propertyName, value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> entities = session.createQuery(query).getResultList();
        logger.debug("Matching entities: " + entities);
        session.close();
        return entities;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
