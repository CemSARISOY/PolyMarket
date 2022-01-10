package Persist;

import Core.Delivery;

import java.util.ArrayList;

public interface DeliveryDao {

    /**
     * Get a delivery from the DB by ID
     * @param id
     * @return the associated delivery from the DB
     */
    Delivery getDeliveryById(int id);

    ArrayList<Delivery> getDeliveries();

    ArrayList<Delivery> getDeliveriesByBuyerId(int buyerId);

    Delivery addDelivery(Delivery d);
}
