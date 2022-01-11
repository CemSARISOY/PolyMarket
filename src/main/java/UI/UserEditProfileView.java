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
import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import Core.LoginFacade;
import Core.User;
import Core.UserFacade; 

public class UserEditProfileView extends Observable implements ActionListener {
		private static JFrame frame;
		private static JLabel password, label, emailLabel,firstnameLabel,lastnameLabel,nicknameLabel,dateLabel;
	    private static JTextField username,emailField, firstnameField, lastnameField,nicknameField,dateDayField, dateMonthField, dateYearField, passwordField;
	    private static JButton button;


	    UserFacade userFacade; 
	    UserProfileView userProfile;
	    public UserEditProfileView(User user,UserProfileView userProfile) {
	    	this.userFacade = new UserFacade(user);
	    	this.userProfile = userProfile;
	    	 // JFrame class
	        frame = new JFrame();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Integer realWidth = (int) Math.round(0.5 * screenSize.getWidth());
	        Integer realHeight = (int) Math.round(0.5 * screenSize.getHeight());

	        frame.setTitle("PolyMarket Edit Profile");
	        frame.setLocation(new Point(realWidth - 200, realHeight - 100));
	        frame.setSize(new Dimension(400, 400));
	        frame.setResizable(false);
	        //frame.setDefaultCloseOperation(onClose());
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
	        username = new JTextField(this.userFacade.getUser().getNickname());
	        username.setBounds(100, 27, 193, 28);
	        panel.add(username);

	        // Password Label constructor
	        password = new JLabel("Password");
	        password.setBounds(100, 55, 70, 20);
	        panel.add(password);

	        // Password TextField
	        passwordField = new JTextField(this.userFacade.getUser().getPassword());
	        passwordField.setBounds(100, 75, 193, 28);
	        panel.add(passwordField);
	        
	        // email label constructor
	        emailLabel = new JLabel("Email");
	        emailLabel.setBounds(100, 104, 100, 20);
	        panel.add(emailLabel);

	        // email TextField constructor
	        emailField = new JTextField(this.userFacade.getUser().getEmail());
	        emailField.setBounds(100, 123, 193, 28);
	        panel.add(emailField);
	        
	        // fisrtname label constructor
	        firstnameLabel = new JLabel("Firstname");
	        firstnameLabel.setBounds(100, 152, 100, 20);
	        panel.add(firstnameLabel);

	        // firstname TextField constructor
	        firstnameField = new JTextField(this.userFacade.getUser().getFirstname());
	        firstnameField.setBounds(100, 171, 193, 28);
	        panel.add(firstnameField);
	        
	        // lastname label constructor
	        lastnameLabel = new JLabel("Lastname");
	        lastnameLabel.setBounds(100, 200, 100, 20);
	        panel.add(lastnameLabel);

	        // lastname TextField constructor
	        lastnameField = new JTextField(this.userFacade.getUser().getLastname());
	        lastnameField.setBounds(100, 219, 193, 28);
	        panel.add(lastnameField);
	           
	        // date label constructor
	        dateLabel = new JLabel("Date of birth");
	        dateLabel.setBounds(100, 250, 100, 20);
	        panel.add(dateLabel);

	        // date TextField constructor
	        dateDayField = new JTextField(""+this.userFacade.getUser().getDob().getDate());
	        dateDayField.setBounds(100, 270, 40, 28);
	        panel.add(dateDayField);
	        
	        // date TextField constructor
	        dateMonthField = new JTextField(""+(this.userFacade.getUser().getDob().getMonth()+1));
	        dateMonthField.setBounds(150, 270, 40, 28);
	        panel.add(dateMonthField);
	        
	        // date TextField constructor
	        dateYearField = new JTextField(""+(this.userFacade.getUser().getDob().getYear()+1900));
	        dateYearField.setBounds(200, 270, 80, 28);
	        panel.add(dateYearField);

	        // Button constructor
	        button = new JButton("Update");
	        button.setBounds(100, 310, 90, 25);
	        button.setForeground(Color.WHITE);
	        button.setBackground(Color.BLACK);
	        button.addActionListener(this);
	        panel.add(button);
	       
	        UserEditProfileView instance = this;
	        JButton cancel = new JButton("Cancel");
	        cancel.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent ae) {
	        	   frame.dispose();
	        	 //  userProfile.setEnabled(true);
	        	   userProfile.toFront();
	           }
	        });
	        
	        cancel.setBounds(200, 310, 90, 25);
	        cancel.setForeground(Color.BLACK);
	        cancel.setBackground(Color.WHITE);
	        panel.add(cancel);

	        // Display frame
	        frame.add(panel);
	        frame.setVisible(true);
	        
	        
	    }
	    
		// private int onClose() {
		// 	 //userProfile.setEnabled(true);
		// 	//return JFrame.EXIT_ON_CLOSE;
		// }

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
	            this.userFacade.modifyUser(this.userFacade.getUser().getId(),firstname,lastname,nickname,email,pass,new Date(Integer.valueOf(year)-1900,Integer.valueOf(month)-1,Integer.valueOf(day)), LoginFacade.getLoginFacade().getUser().getBalance());
	            frame.dispose();
	            JOptionPane.showMessageDialog(null, "Profile Updated");
	        //    userProfile.setEnabled(true);
	            userProfile.update();
	            userProfile.toFront();
	            
	            
	        } catch (Exception e1) { 
	        	e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, e1.getMessage());
	        }
	     
	    }
			
		


	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade(null);
		User user = userFacade.getUserDao().getUserById(1);
		//UserEditProfileView view = new UserEditProfileView(user);
	}



}
