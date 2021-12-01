package UI;

import javax.swing.*;

import Core.LoginFacade;

import java.awt.*;
import java.awt.event.*;
/**
* @generated
*/
public class LoginView extends JFrame implements ActionListener {

    /*Global view variables
    */
    private Container contentPane = getContentPane();
    
    private JTextField nick = new JTextField(30);
    private JTextField pass = new JTextField(20);
    
   /*Variables
    */
    private String nickname;
    private String password;
    private LoginFacade lf;
    
    
    /*Constructor
    */
    public LoginView() {
        super("LoginView");
        setVisible(true);
        pack();
    }

    /*View
    */
    public void lauchView() {

        //INTERFACE
        
        //NORTH 

        JPanel panelNorth = new JPanel();
        JLabel jl = new JLabel("Bienvenue !");
        panelNorth.add(jl);

        //CENTER

        JPanel panelCenter = new JPanel();

        JPanel panelForms =  new JPanel();
        panelForms.setLayout(new BoxLayout(panelForms, BoxLayout.Y_AXIS));

        JPanel panelText =  new JPanel();
        panelText.setLayout(new BoxLayout(panelText, BoxLayout.Y_AXIS));

        var fields = new String[]{"Nickname", "Mot de passe"};

        for(String e : fields) {
            var label = new JLabel(e);
            label.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            panelForms.add(label);
        }

        panelText.add(nick);
        panelText.add(pass);

        panelCenter.add(panelForms);
        panelCenter.add(panelText);

        //SOUTH

        JPanel panelButtons =  new JPanel();
        var butts = new String[]{"Login"};

        for(String e : butts) {
            JButton but = new JButton(e);
            if(e.equals("Login")) {
                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        nickname = nick.getText();          
                        password = pass.getText();
                        login(nickname, password);   
                    }
                });
            }

            panelButtons.add(but);
        }

        //DISPLAY ON THE WINDOW
        contentPane.add(panelNorth, BorderLayout.NORTH);
        contentPane.add(panelCenter, BorderLayout.CENTER);
        contentPane.add(panelButtons, BorderLayout.SOUTH);
    }


    /*User functions
    */
    public String getNickname() {
        return this.nickname;
    }
    
    public String setNickname(String nickname) {
        this.nickname = nickname;
        return this.nickname;
    }
    
    public String getPassword() {
        return this.password;
    }
    
   
    public String setPassword(String password) {
        this.password = password;
        return this.password;
    }

    public void login(String nick, String pw) {
        lf.login(nick, pw);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public LoginFacade setLoginFacade(LoginFacade lf) {
        this.lf = lf;
        return this.lf;
    }

    public static void main(String args[]) {
        LoginView lv = new LoginView();
        lv.lauchView();
    }
    
}
