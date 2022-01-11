package test;

import org.junit.jupiter.api.Test;
import Core.Auction;
import Core.AuctionFacade;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionTest {

    @Test
    void bidLessThanHighestTest(){
        AuctionFacade af = AuctionFacade.getAuctionFacade();
        Auction a = af.getAuctionById(1);

        boolean thrown = false;
        try {
            af.participate(a.getHighestOffer()-10, a);
        } catch (Exception e) {
            //TODO: handle exception
            thrown = true;
        }

        assertTrue(thrown);
    }
    
}
