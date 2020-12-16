package util;

import persistence.GenericDao;

/**
 * A factory for creating generic DAOs.
 *
 */
public class DaoFactory {

    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);
    }
}
