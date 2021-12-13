package Persist;

import Core.Bid;
import Core.PaymentMean;
import Core.PaymentOrder;

/**
* @generated
*/
public interface PaymentDAO {

     /**
     * 
     * @param The payment mean to add to the DB 
     */
    public void addUpdateMean(PaymentMean pm);
    
    /**
     * 
     * @param The PaymentOrder to add to the DB
     */
    public void addPaymentOrder(PaymentOrder po);
    /**
     * 
     * @param The bid to add to the user
     */
    public void addUpdateBid(Bid b);
}