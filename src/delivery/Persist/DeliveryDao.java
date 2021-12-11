package Persist;

import Core.User;

public interface DeliveryDao {
 
    /**
     * Get a delivery from the DB by ID
     * @param id
     * @return
     */
    Delivery getDeliveryById(int id); 
}
