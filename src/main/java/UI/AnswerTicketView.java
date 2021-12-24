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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        ansArea = new JTextArea(4,60);
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
        contentPane.add(center, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticketFacade.sendAnswer(ticket,sender,ansArea.getText());
        dispose();
        TicketListView ticketListView = new TicketListView();
    }
}
