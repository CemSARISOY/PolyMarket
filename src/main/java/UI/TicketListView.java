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

        //NORTH CONTENT
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(SwingConstants.NORTH_WEST));
        ImageIcon back = new ImageIcon(getClass().getResource("back.png"));
        Image newBack = back.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        ImageIcon finalBack = new ImageIcon(newBack);
        JButton backBtn = new JButton(finalBack);
        backBtn.setBackground(Color.WHITE);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        north.add(backBtn);
        JLabel title = new JLabel("List of tickets sent by users");
        title.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
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

            //Ticket Button action performed
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
                                JButton answer = new JButton("Answer");
                                answer.setName(String.valueOf(tickets.get(j).getId()));
                                answer.setBackground(Color.darkGray);
                                answer.setForeground(Color.WHITE);
                                answer.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JButton ans = (JButton) e.getSource();
                                        String id = ans.getName();
                                        int idOfTicket = Integer.parseInt(id);
                                        try {
                                            Ticket tempTick = ticketFacade.getTicketById(idOfTicket);
                                            if(tempTick.getIsAnswered()) {
                                                JOptionPane.showMessageDialog(null, "This ticket has already been answered");
                                            }
                                            else{
                                                dispose();
                                                AnswerTicketView atv = new AnswerTicketView(idOfTicket);
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
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
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
            JPanel statusPanel = new JPanel();
            JButton status = new JButton();
            status.setBorder(new RoundedBorder(5));
            if(tickets.get(i).getIsAnswered()) {
                status.setBackground(Color.green);
            }
            else{
                status.setBackground(Color.red);
            }
            statusPanel.add(status);
            statusPanel.setBorder(BorderFactory.createEmptyBorder(10,30,0,0));
            ImageIcon img = new ImageIcon(getClass().getResource("poubelle.png"));
            Image newimg = img.getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH);
            ImageIcon finalImg = new ImageIcon(newimg);
            JButton delBtn = new JButton(finalImg);
            delBtn.setName(String.valueOf(tickets.get(i).getId()));
            delBtn.setBackground(Color.WHITE);
            delBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton but = (JButton) e.getSource();
                    int input = JOptionPane.showConfirmDialog(null,
                            "Do you really want to delete this ticket ?",
                            "Select an option",
                            JOptionPane.OK_CANCEL_OPTION);
                    while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
                    if(input == 0) {
                        try {
                            ticketFacade.deleteTicketById(Integer.parseInt(but.getName()));
                            dispose();
                            TicketListView newTicketList = new TicketListView();
                        }
                        catch (Exception e2) {
                            JOptionPane.showMessageDialog(null, e2.getMessage());
                        }
                    }
                }
            });
            rightPanel.add(delBtn);
            rightPanel.add(statusPanel);


            //Grouping
            ticketPanel.add(ticketid);
            ticketPanel.add(btnPanel);
            ticketPanel.add(rightPanel);
            ticketPanel.setBorder(new LineBorder(Color.black, 1, true));
            center.add(ticketPanel);
        }

        //Scrollable
        JScrollPane scroll = new JScrollPane(center,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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
