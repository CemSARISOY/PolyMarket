package UI;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.*;

import Core.Abuse;
import Core.AbuseFacade;
/**
* @generated
*/
public class AdminViewAbuse extends JFrame implements ActionListener {

    private AbuseFacade abf;
    private JTextField search = new JTextField();
    List<Abuse> abuses;
    List<Abuse> sortedAbuses;
    public AdminViewAbuse(){
        abf = AbuseFacade.getAbuseFacade();
        this.setTitle("Abuses - list");
        search.setPreferredSize(new Dimension(100,30));
        getList();
    }

    public Container getList(){
        setContentPane(new Container());
        abuses = abf.consult();
        sortedAbuses = new ArrayList<>();
        if(!search.getText().equals("")){
            for(Abuse a : abuses){
                if(a.getTitle().contains(search.getText())) sortedAbuses.add(a);
            }
        }else{
            sortedAbuses = abuses;
        }
        setLayout(new BorderLayout());
        Container top = new Container();
        top.setLayout(new FlowLayout());
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        top.add(search);
        top.add(searchButton);
        add(top, BorderLayout.NORTH);

        Container cbis = new Container();
        cbis.setLayout(new BoxLayout(cbis, BoxLayout.PAGE_AXIS));

        for(Abuse a : sortedAbuses){

            Container card = new Container();
            card.setLayout(new BorderLayout());
            card.add(new JLabel(a.getTitle()), BorderLayout.CENTER);

            Container buttons = new Container();
            buttons.setLayout(new FlowLayout());
            JButton jb1 = new JButton("Send warning");
            JButton jb2 = new JButton("Ban user");
            buttons.add(jb1);
            buttons.add(jb2);
            card.add(buttons, BorderLayout.SOUTH);
            cbis.add(card);
            
        }

        JScrollPane js = new JScrollPane(cbis);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(js, BorderLayout.CENTER); 
        return getContentPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        getList();
        
    }  
}
