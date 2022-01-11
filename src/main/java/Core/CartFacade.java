package Core;
 
import UI.payment.PaymentView; 

public class CartFacade extends AbstractProdcutList{
 
    private static CartFacade cartFacade;
     
    // Operations                                  
    
    private CartFacade(int userId, String title) {
		super(userId, title); 
	}

    /**
     * FOR TESTING PURPOSES, DO NOT USE
     */
    public CartFacade(){
        super(1,"test");
    }

    public static CartFacade getCartFacade() { 
        if(cartFacade == null) cartFacade = new CartFacade(LoginFacade.getLoginFacade().getUser().getId(), "title");
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