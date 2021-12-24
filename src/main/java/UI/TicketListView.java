package UI;

import Core.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JButton _lastButtonPressed;

    public TicketListView() {

        //GLOBAL VARIABLES INIT
        try {
            this.tickets = ticketFacade.getListTickets();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //FRAME INIT
        this.setTitle("List of tickets");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //NORTH CONTENT
        JPanel north = new JPanel();
        JLabel title = new JLabel("List of tickets sent by users");
        north.add(title);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        //CENTER CONTENT
        //Center config
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,200,200,200));
        center.setLayout(new GridLayout(0,1));

        //Reactive panel
        JPanel south = new JPanel();
        south.setBorder(BorderFactory.createEmptyBorder(40,0,40,0));
        south.setVisible(false);

        //Tickets management
        for(var i =0; i< tickets.size(); i++) {
            TicketCategory category = null;
            User sender = null;
            try {
                category = ticketFacade.getTicketCategory(tickets.get(i).getCategory());
                sender = ticketFacade.getUserById(tickets.get(i).getUserId());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            //Main Button
            JPanel ticketPanel =new JPanel();
            JButton ticketButton = new JButton(tickets.get(i).getTitle());
            ticketButton.setPreferredSize(new Dimension(500,75));
            ticketButton.setBackground(Color.darkGray);
            ticketButton.setForeground(Color.white);

            //Button action performed
            ticketButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e1) {
                    JButton b = (JButton) e1.getSource();
                    if (_lastButtonPressed == b)
                    {
                        south.setVisible(false);
                    }
                    else
                    {
                        for(int j =0; j< tickets.size(); j++) {
                            if(b.getText().equals(tickets.get(j).getTitle())){
                                //Title management
                                JPanel titlePanel = new JPanel();
                                JLabel southTitle = new JLabel("<html>Ticket title :<br>");
                                JTextArea titleText = new JTextArea(2,20);
                                titleText.setText(tickets.get(j).getTitle());
                                titleText.setEditable(false);
                                JScrollPane scrollTitle = new JScrollPane(titleText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                                titlePanel.add(southTitle);
                                titlePanel.add(scrollTitle);
                                titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
                                titlePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

                                //Description Management
                                JPanel descPanel = new JPanel();
                                JLabel descTitle = new JLabel("<html>Ticket description :<br>");
                                JTextArea descText = new JTextArea(3,50);
                                descText.setText(tickets.get(j).getBody());
                                descText.setEditable(false);
                                JScrollPane scrollDesc = new JScrollPane(descText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                                descPanel.add(descTitle);
                                descPanel.add(scrollDesc);
                                descPanel.setLayout(new BoxLayout(descPanel, BoxLayout.Y_AXIS));
                                descPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

                                //Answer button management
                                JButton answer = new JButton("Answer to ticket "+tickets.get(j).getId());
                                answer.setBackground(Color.darkGray);
                                answer.setForeground(Color.WHITE);
                                answer.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JButton ans = (JButton) e.getSource();
                                        String[] parts = ans.getText().split(" ");
                                        int idOfTicket = Integer.parseInt(parts[3]);
                                        AnswerTicketView atv = new AnswerTicketView(idOfTicket);
                                        dispose();
                                        atv.setVisible(true);
                                    }
                                });
                                JPanel btnPanel = new JPanel();
                                btnPanel.add(answer);
                                btnPanel.setBorder(BorderFactory.createEmptyBorder(0,75,0,0));

                                //Updating south reactive panel
                                south.setVisible(false);
                                south.removeAll();
                                south.add(titlePanel);
                                south.add(descPanel);
                                south.add(btnPanel);
                                south.setVisible(true);
                            }
                        }
                    }
                    _lastButtonPressed = b;
                }
            });
            JPanel btnPanel = new JPanel();
            btnPanel.add(ticketButton);
            btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Left Label infos
            JLabel ticketid = new JLabel("<html> Ticket id : "+String.valueOf(tickets.get(i).getId())+"<br>" +
                    "Category : "+category.getName()+"<br>" +
                    "Sender id :"+sender.getId());
            ticketid.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

            //Status Button
            JButton status = new JButton();
            status.setBorder(new RoundedBorder(5));
            if(tickets.get(i).getIsAnswered()) {
                status.setBackground(Color.green);
            }
            else{
                status.setBackground(Color.red);
            }

            //Grouping
            ticketPanel.add(ticketid);
            ticketPanel.add(btnPanel);
            ticketPanel.add(status);
            ticketPanel.setBorder(new LineBorder(Color.white, 1, true));
            center.add(ticketPanel);
        }

        //Scrollable
        JScrollPane scroll = new JScrollPane(center);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(scroll, BorderLayout.CENTER);
        contentPane.add(south, BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        TicketListView ticketListView = new TicketListView();
    }
}
