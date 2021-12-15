package Persist;

import Core.Delivery;
import Core.User;

public interface DeliveryDao {
 
    /**
     * Get a delivery from the DB by ID
     * @param id
     * @return the associated delivery from the DB
     */
    Delivery getDeliveryById(int id); 
}
