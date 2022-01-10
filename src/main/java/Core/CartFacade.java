package Core;
 
import UI.payment.PaymentView; 

public class CartFacade extends AbstractProdcutList{
 
    private static CartFacade cartFacade = new CartFacade(LoginFacade.getLoginFacade().getUser().getId(), "title");
     
    // Operations                                  
    
    private CartFacade(int userId, String title) {
		super(userId, title); 
	}

    public static CartFacade getCartFacade() { 
        return cartFacade;
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