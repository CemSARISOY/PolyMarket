package Persist;

import java.sql.*;
import Core.Delivery;

public class DeliveryDaoMySQL implements DeliveryDao {

    private AbstractFactoryDao creator;

    /**
     * Constructor of DeliveryDaoMySQL
     * @param creator
     */
    public DeliveryDaoMySQL(AbstractFactoryDao creator) {
        this.creator = creator;
    }

    /**
     * Get a delivery from the MySQL DB by ID
     * @param id
     * @return
     */
    @Override
    public Delivery getDeliveryById(int id) {
        // TODO
    } 
}