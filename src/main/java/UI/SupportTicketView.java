package UI;

import Core.Ticket;
import Core.TicketCategory;
import Core.TicketFacade;
import Core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupportTicketView extends JFrame implements ActionListener {

    //Core variables
    User sender;
    private TicketFacade ticketFacade = TicketFacade.getTicketFacade();
    private ArrayList<TicketCategory> categories;
    private TicketCategory categorySelected;
    //View variables
    private Container contentPane = getContentPane();
    JTextArea descArea;
    JTextField titleArea;
    JComboBox categoryArea;

    public SupportTicketView(User u) {

        //GLOBAL VARIABLES INIT
        this.sender = u;
        try {
            this.categories = ticketFacade.getTicketCategories();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //INIT
        this.setTitle("Send a ticket");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CENTER CONTENT
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(50,100,100,500));
        center.setLayout(new GridLayout(0, 1));

        JLabel title = new JLabel("Title");
        titleArea = new JTextField(30);
        JPanel titlePanel = new JPanel(new FlowLayout(SwingConstants.WEST));
        titlePanel.add(titleArea);
        center.add(title);
        center.add(titlePanel);

        JLabel category = new JLabel("Category");
        JPanel selectPanel = new JPanel(new FlowLayout(SwingConstants.WEST));
        categoryArea = new JComboBox();
        categories.forEach((n) -> categoryArea.addItem(n.getName()));
        selectPanel.add(categoryArea);
        center.add(category);
        center.add(selectPanel);

        JLabel desc = new JLabel("Description");
        descArea = new JTextArea(4,40);
        descArea.setLineWrap(true);
        JScrollPane scrollDesc = new JScrollPane(descArea);
        JPanel p = new JPanel(new FlowLayout(SwingConstants.WEST));
        p.add(scrollDesc);
        center.add(desc);
        center.add(p);

        JButton send = new JButton("Send");
        send.setForeground(Color.WHITE);
        send.setBackground(Color.BLACK);
        send.addActionListener(this);
        JPanel panelBtn = new JPanel();
        panelBtn.add(send);
        panelBtn.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        center.add(panelBtn);

        //FINAL CONFIG
        contentPane.add(center, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = titleArea.getText();
        String desc = descArea.getText();
        String cat = (String) categoryArea.getSelectedItem();
        if(title.length() > 30){
            JOptionPane.showMessageDialog(null, "Your title is too long (>30 chars)");
            return;
        }
        if(desc.length() > 300){
            JOptionPane.showMessageDialog(null, "Your description is too long (>300 chars)");
            return;
        }
       for( int i=0; i< categories.size(); i++ ) {
           if(categories.get(i).getName().equals(cat)) {
               categorySelected = categories.get(i);
           }
       }
        Ticket ticketToSend = new Ticket(1, title, desc, categorySelected.getId(), sender.getId(), false);
        try{
            ticketFacade.send(ticketToSend);
            int res = JOptionPane.showOptionDialog(null, "Ticket send successfully", "Information", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
            while(res != 0 && res != -1){}
            setVisible(false);
        }
        catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    public static void main(String[] args) {
        SupportTicketView supportTicketView = new SupportTicketView(new User(1));
    }
}
