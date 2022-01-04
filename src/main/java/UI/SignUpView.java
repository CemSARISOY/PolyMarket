package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.ToIntFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Core.User;
import Core.UserFacade;
import Persist.AbstractFactoryDao;
import Persist.UserDaoMySQL;

public class SignUpView implements ActionListener {
	
	 private static JLabel password, label, emailLabel,firstnameLabel,lastnameLabel,dateLabel;
	    private static JTextField username,emailField, firstnameField, lastnameField,dateDayField, dateMonthField, dateYearField;
	    private static JButton button;
	    private static JPasswordField passwordField;

	    UserFacade userFacade = new UserFacade(null, new UserDaoMySQL(AbstractFactoryDao.getFactory("mysql")), null);
	    
	    public SignUpView() {
	        // JFrame class
	        JFrame frame = new JFrame();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Integer realWidth = (int) Math.round(0.5 * screenSize.getWidth());
	        Integer realHeight = (int) Math.round(0.5 * screenSize.getHeight());

	        frame.setTitle("PolyMarket Sign Up");
	        frame.setLocation(new Point(realWidth - 200, realHeight - 100));
	        frame.setSize(new Dimension(400, 400));
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
	        
	        // email label constructor
	        emailLabel = new JLabel("Email");
	        emailLabel.setBounds(100, 104, 100, 20);
	        panel.add(emailLabel);

	        // email TextField constructor
	        emailField = new JTextField();
	        emailField.setBounds(100, 123, 193, 28);
	        panel.add(emailField);
	        
	        // fisrtname label constructor
	        firstnameLabel = new JLabel("Firstname");
	        firstnameLabel.setBounds(100, 152, 100, 20);
	        panel.add(firstnameLabel);

	        // firstname TextField constructor
	        firstnameField = new JTextField();
	        firstnameField.setBounds(100, 171, 193, 28);
	        panel.add(firstnameField);
	        
	        // lastname label constructor
	        lastnameLabel = new JLabel("Lastname");
	        lastnameLabel.setBounds(100, 200, 100, 20);
	        panel.add(lastnameLabel);

	        // lastname TextField constructor
	        lastnameField = new JTextField();
	        lastnameField.setBounds(100, 219, 193, 28);
	        panel.add(lastnameField);
	        
	       
	        
	        // date label constructor
	        dateLabel = new JLabel("Date of birth");
	        dateLabel.setBounds(100, 250, 100, 20);
	        panel.add(dateLabel);

	        // date TextField constructor
	        dateDayField = new JTextField();
	        dateDayField.setBounds(100, 270, 40, 28);
	        panel.add(dateDayField);
	        
	        // date TextField constructor
	        dateMonthField = new JTextField();
	        dateMonthField.setBounds(150, 270, 40, 28);
	        panel.add(dateMonthField);
	        
	        // date TextField constructor
	        dateYearField = new JTextField();
	        dateYearField.setBounds(200, 270, 80, 28);
	        panel.add(dateYearField);

	        // Button constructor
	        button = new JButton("Sign Up");
	        button.setBounds(100, 310, 90, 25);
	        button.setForeground(Color.WHITE);
	        button.setBackground(Color.BLACK);
	        button.addActionListener(this);
	        panel.add(button);

	        // Display frame
	        frame.getContentPane().add(panel);
	        frame.setVisible(true);
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
	        String nickname = username.getText();
	        String pass = passwordField.getText();
	        String email = emailField.getText();
	        String firstname = firstnameField.getText();
	        String lastname = lastnameField.getText();
	        
	        String day = dateDayField.getText();
	        String month = dateMonthField.getText();
	        String year = dateYearField.getText();
	        

	        try {
	            this.userFacade.signUp(firstname,lastname,nickname,email,pass,Integer.valueOf(day),Integer.valueOf(month),Integer.valueOf(year));
	            JOptionPane.showMessageDialog(null, "Successfully Signed up");
	        } catch (Exception e1) { 
	            JOptionPane.showMessageDialog(null, e1.getMessage());
	        }
	        
	    }
			
		


	public static void main(String[] args) {
		SignUpView signUp = new SignUpView();
	}



}
