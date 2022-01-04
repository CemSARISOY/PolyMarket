package Persist;

import java.sql.Connection;

public abstract class AbstractFactoryDao {

    /**
     * Gets an AbstractFactoryDao implementation object based on the specified
     * database
     * 
     * @param db Name of the db type
     * @return an {@code AbstractFactoryDao} implementation, or {@code null} if the
     *         specified database is not supported
     */
    public static AbstractFactoryDao getFactory(String db) {
        if (db.equals("mysql"))
            return AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL();
        return null;
    }

    /**
     * Get the UserDao according to the factory
     * 
     * @return a {@code UserDao} implementation
     */
    public abstract UserDao createUserDao();

    public abstract DeliveryDao createDeliveryDao();

    public abstract ProductDao createProductDao();

    public abstract TicketDao createTicketDao();

    public abstract WishlistDao createWishlistDao();

    /**
     * Gets an instance of Connection to the database
     * 
     * @return a {@code Connection} object if the connection was established,
     *         {@code null} otherwise
     */
    public abstract Connection getConnection();
}
