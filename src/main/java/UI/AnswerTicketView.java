package UI;

import Core.Ticket;
import Core.TicketFacade;
import Core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerTicketView extends JFrame implements ActionListener {

    //Core variables
    private TicketFacade ticketFacade = TicketFacade.getTicketFacade();
    private Ticket ticket;
    private User sender;

    //View variables
    private Container contentPane = getContentPane();
    JTextArea ansArea;

    public AnswerTicketView(int ticketId){

        //GLOBAL VARIABLES INIT
        try {
            this.ticket = ticketFacade.getTicketById(ticketId);
            this.sender = ticketFacade.getUserById(this.ticket.getUserId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //FRAME INIT
        this.setTitle("Answer to a ticket");
        setVisible(true);

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
                TicketListView newTL = new TicketListView();
                dispose();
            }
        });
        north.add(backBtn);
        JLabel header = new JLabel("Give feedback to a ticket");
        header.setBorder(BorderFactory.createEmptyBorder(0,515,0,0));
        north.add(header);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

        //CENTER CONTENT
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,100,100,500));
        center.setLayout(new GridLayout(0, 1));

        JLabel title = new JLabel("Title of the ticket");
        JTextArea titleArea = new JTextArea(1,30);
        titleArea.setText(ticket.getTitle());
        titleArea.setEditable(false);
        JPanel titlePanel = new JPanel(new FlowLayout(SwingConstants.WEST));
        titlePanel.add(titleArea);
        center.add(title);
        center.add(titlePanel);

        JLabel desc = new JLabel("Description of the ticket");
        JTextArea descArea = new JTextArea(4,60);
        descArea.setText(ticket.getBody());
        descArea.setEditable(false);
        JScrollPane scrollDesc = new JScrollPane(descArea);
        JPanel descPanel = new JPanel(new FlowLayout(SwingConstants.WEST));
        descPanel.add(scrollDesc);
        center.add(desc);
        center.add(descPanel);

        JLabel answer = new JLabel("Your answer");
        ansArea = new JTextArea(3,60);
        ansArea.setLineWrap(true);
        JScrollPane scrollAns = new JScrollPane(ansArea);
        JPanel p = new JPanel(new FlowLayout(SwingConstants.WEST));
        p.add(scrollAns);
        center.add(answer);
        center.add(p);

        JButton send = new JButton("Send");
        send.setForeground(Color.WHITE);
        send.setBackground(Color.BLACK);
        send.addActionListener(this);
        JPanel panelBtn = new JPanel();
        panelBtn.add(send);
        panelBtn.setBorder(BorderFactory.createEmptyBorder(30,350,0,0));
        center.add(panelBtn);

        //FINAL CONFIG
        contentPane.add(north, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ansArea.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Your answer is empty");
            return;
        }
        int input = JOptionPane.showConfirmDialog(null,
                "Do you really want to send your answer ?",
                "Select an option",
                JOptionPane.OK_CANCEL_OPTION);
        while(input != JOptionPane.CANCEL_OPTION && input != JOptionPane.OK_OPTION) {}
        if(input == 0){
            try {
                ticketFacade.sendAnswer(ticket,sender,ansArea.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            int res = JOptionPane.showOptionDialog(null, "Answer successfully sent", "Information", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            while(res != 0 && res != -1){}
            dispose();
            TicketListView ticketListView = new TicketListView();
        }
    }
}
