package UI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.AbuseFacade;


/**
* @generated
*/
public class UserViewAbuse extends JFrame implements ActionListener {                                
    
    private AbuseFacade af;
    private int userId;
    private JTextField textField_1;
    private JTextField textField_2;
    
    public UserViewAbuse(int userId){
        this.userId = userId;
        af = AbuseFacade.getAbuseFacade();

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        JLabel panel = new JLabel("Title");
        container.add(panel);
        textField_1 = new JTextField();
        container.add(textField_1);
        textField_1.setColumns(10);

        JLabel panel2 = new JLabel("Description");
        container.add(panel2);
        textField_2 = new JTextField();
        container.add(textField_2);
        textField_2.setColumns(10);
        

        JButton button = new JButton("Send");
        container.add(button);
        button.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        af.sendAbuse(textField_1.getText(),textField_2.getText(), userId);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new UserViewAbuse(1);
    }
}
