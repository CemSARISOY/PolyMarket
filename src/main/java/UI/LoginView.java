package UI;

import Core.LoginFacade;
import Core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @generated
 */
public class LoginView implements ActionListener {
    private static JLabel password, label;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField passwordField;

    LoginFacade loginFacade = new LoginFacade();
    public LoginView() {

        // JFrame class
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Integer realWidth = (int) Math.round(0.5 * screenSize.getWidth());
        Integer realHeight = (int) Math.round(0.5 * screenSize.getHeight());

        frame.setTitle("PolyMarket Login");
        frame.setLocation(new Point(realWidth - 200, realHeight - 100));
        frame.setSize(new Dimension(400, 200));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("draw.png").getImage());


        // creating a JPanel class with gradient color
        JPanel panel = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 100;
                    final int G = 100;
                    final int B = 100;
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                            getWidth(), getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };
        panel.setLayout(null);

        // Username label constructor
        label = new JLabel("Username");
        label.setBounds(100, 8, 100, 20);
        panel.add(label);

        // Username TextField constructor
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);

        // Password Label constructor
        password = new JLabel("Password");
        password.setBounds(100, 55, 70, 20);
        panel.add(password);

        // Password TextField
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 75, 193, 28);
        panel.add(passwordField);

        // Button constructor
        button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        panel.add(button);

        // Display frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Operations
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();
        String pass = passwordField.getText();

        try {
            User u = this.loginFacade.login(user,pass);
            System.out.println("Connected : " + u.getNickname());
        } catch (Exception e1) { 
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
    }

    public static void main(String[] args) {
        LoginView login = new LoginView();
    }

}
