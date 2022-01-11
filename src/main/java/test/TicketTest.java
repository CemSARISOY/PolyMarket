package test;

import static org.junit.Assert.assertTrue;

import Core.Ticket;
import Persist.TicketDao;
import org.junit.Test;

import Persist.AbstractFactoryDao;

public class TicketTest {

    @Test
    void getTicketTest() {
        AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
        TicketDao ticketDao = abstractFactoryDao.createTicketDao();
        Ticket ticket = new Ticket(1,"Help Product Scam","I got scammed by a FDP",1,1,false);
        try {
            Ticket ticket1 = ticketDao.getTicketById(1);
            assertTrue(ticket.equals(ticket1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
