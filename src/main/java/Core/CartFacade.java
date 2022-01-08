package Core;

import UI.payment.PaymentView;
import UI.payment.ProductsPayment;

public class CartFacade extends AbstractProdcutList{
    

    //                          Operations                                  
    
    public CartFacade(int userId, String title) {
		super(userId, title);
		// TODO Auto-generated constructor stub
	}

	/**
     * Starts the process of purchasing the items in the cart
     */
    public void validate() {
        var t = new PaymentView();
        t.setVisible(true);
    }

    public static void main(String[] args) {

	}
    
}