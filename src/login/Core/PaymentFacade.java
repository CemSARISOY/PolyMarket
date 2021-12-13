package Core;

import Persist.AbstractFactoryDao;
import Persist.PaymentDAO;

/**
 */
public class PaymentFacade {
    
    private PaymentMean[] MeanList;
    private AbstractFactoryDao abstractFactoryDAO;
    private PaymentOrder paymentOrder;
    private PaymentDAO paymentDao;
    private PaymentMean paymentMean;
    
    
    /**
    Getters and setters
    */
    public PaymentMean[] getMeanList() {
        return this.MeanList;
    }
    
    public PaymentMean[] setMeanList(PaymentMean[] MeanList) {
        this.MeanList = MeanList;
        return this.MeanList;
    }

    public PaymentOrder getPaymentOrder() {
        return this.paymentOrder;
    }
    
    public PaymentOrder setPaymentOrder(PaymentOrder paymentOrder) {
        this.paymentOrder = paymentOrder;
        return this.paymentOrder;
    }

    public PaymentDAO getPaymentDAO() {
        return this.paymentDao;
    }
    
    public PaymentDAO setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDao = paymentDAO;
        return this.paymentDao;
    }

    public AbstractFactoryDao getAbstractFactoryDAO() {
        return this.abstractFactoryDAO;
    }
    
    public AbstractFactoryDao setAbstractFactoryDAO(AbstractFactoryDao abstractFactoryDAO) {
        this.abstractFactoryDAO = abstractFactoryDAO;
        return this.abstractFactoryDAO;
    }
    
    //Operations                                  
    public void buy() {
        //TODO
    }

    public void setUpMean() {
        //TODO
    }

    public void makeBid() {
        //TODO
    }   
}
