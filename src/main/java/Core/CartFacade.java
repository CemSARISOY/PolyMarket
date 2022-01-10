package Core;

import Core.LoginFacade;
import UI.payment.PaymentView; 

public class CartFacade extends AbstractProdcutList{
 
    private static CartFacade cartFacade;
     
    // Operations                                  
    
    private CartFacade(int userId, String title) {
		super(userId, title); 
	}

    public static CartFacade getCartFacade() {
        if (cartFacade != null) return cartFacade;
        if (LoginFacade.getLoginFacade().getUser() != null) return new CartFacade(LoginFacade.getLoginFacade().getUser().getId(), "title");
        return new CartFacade(1, "title");
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