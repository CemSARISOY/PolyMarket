package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.User;
import Core.UserFacade;
import Persist.AbstractFactoryDao;
import Persist.ProductDaoMySQL;
import Persist.UserDaoMySQL;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder; 
import java.awt.Dimension; 
import javax.swing.JScrollPane; 
import javax.swing.ImageIcon; 
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileView extends JPanel {  
	private static JLabel username;
	UserFacade userFacade;
	/**
	 * Launch the application.
	 */

	
    //                          Operations                                  
    
    /**
     * Opens up a frame to show one user's profile 
     * 
     * @param userToView user to show the profile of
     */
	public UserProfileView(User user, User userToView) { 
		
		this.setLayout(null);
		this.userFacade = new UserFacade(user, AbstractFactoryDao.getFactory("mysql").createUserDao(),AbstractFactoryDao.getFactory("mysql").createProductDao());
 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Integer realWidth = (int) Math.round(0.5 * screenSize.getWidth());
        Integer realHeight = (int) Math.round(0.5 * screenSize.getHeight());  
		
		username = new JLabel(userToView.getNickname());
		username.setFont(new Font("Tahoma", Font.BOLD, 19));
		username.setBounds(33, 20, 139, 33);
		this.add(username);
		
		
		if (user.equals(userToView)) {
			UserProfileView instance = this;
			JButton btnNewButton = new JButton("Edit Profile");
			btnNewButton.setBounds(558, 30, 85, 21); 
			var this10 = this;
			btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
             	  new UserEditProfileView(userFacade.getUser(),instance);
             	  this10.setEnabled(false);
             	  
                }
             });
			 this.add(btnNewButton);
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(10, 112, 671, 294);
		this.add(tabbedPane);
		
		JPanel activeSalesPanel = new JPanel();
		tabbedPane.addTab("Active Sales", null, activeSalesPanel, null);
		activeSalesPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(49, 55, 45, 13);
		activeSalesPanel.add(lblNewLabel_1);
		
		JPanel previousSalesPanel = new JPanel();
		tabbedPane.addTab("Previous Sales", null, previousSalesPanel, null);
		previousSalesPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(20, 10, 619, 243);
		previousSalesPanel.add(panel);
		panel.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 300, 50);

		this.add(panel); 
		this.setVisible(true); 
	}
	
	public void toFront() {
		this.toFront();
	}
	public void setEnabled(boolean bool) {
		this.setEnabled(bool);
	}

	public void update() {
		userFacade = new UserFacade(this.userFacade.getUserById(this.userFacade.getUser().getId()), AbstractFactoryDao.getFactory("mysql").createUserDao(), AbstractFactoryDao.getFactory("mysql").createProductDao());
		System.out.println(userFacade.getUser().getNickname());
		username.setText(userFacade.getUser().getNickname());
	}
	
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade(null, AbstractFactoryDao.getFactory("mysql").createUserDao(), null);
		User user = userFacade.getUserDao().getUserById(1);
		UserProfileView view = new UserProfileView(user, user);
	}
}
