package UI;

import Core.Ticket;
import Core.TicketCategory;
import Core.TicketFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketListView extends JFrame implements ActionListener {

    //Core variables
    private TicketFacade ticketFacade = TicketFacade.getTicketFacade();
    private ArrayList<Ticket> tickets;
    private TicketCategory categorySelected;

    //View variables
    private Container contentPane = getContentPane();
    JTextArea descArea;
    JTextField titleArea;
    JComboBox categoryArea;

    public TicketListView() {

        //GLOBAL VARIABLES INIT
        try {
            this.tickets = ticketFacade.getListTickets();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //INIT
        this.setTitle("Send a ticket");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NORTH CONTENT
        JPanel north = new JPanel();
        JLabel title = new JLabel("List of tickets sent by users");
        north.add(title);
        north.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

        //CENTER CONTENT
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,100,100,500));
        center.setLayout(new GridLayout(0, 1));


        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        TicketListView ticketListView = new TicketListView();
    }
}
