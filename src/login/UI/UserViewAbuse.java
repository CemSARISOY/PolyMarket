package UI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.AbuseFacade;


/**
* @generated
*/
public class UserViewAbuse extends JFrame implements ActionListener {                                
    
    private AbuseFacade af;
    
    public UserViewAbuse(){
        af = new AbuseFacade();

        Container container = this.getContentPane();
        JPanel panel = new JPanel();
        container.add(panel);
        JButton button = new JButton("Test");
        panel.add(button);
        button.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Test");
        af.sendAbuse("J'aime pas ce mec", "la dernière fois il a dit que j'étais pas beau ça m'a blessé", "cemsarisoy");
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        new UserViewAbuse();
    }
}
