package Persist;

import java.sql.Connection;

public abstract class AbstractFactoryDao {
    public static AbstractFactoryDao getFactory(String db) {
        if (db.equals("mysql")) return new AbstractFactoryDaoMySQL();
        return null;
    }
    public abstract UserDao createUserDao();
    public abstract Connection getConnection();
}
