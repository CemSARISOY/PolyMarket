package UI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Core.User;
import Core.UserFacade;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class UserProfileView extends JPanel {
	UserFacade userFacade;
	 public ProductView2 productView;
	 public Container products;
	 //public Container productsActiveSales;
	 //public Container productsPreviousSales;
	public static JLabel username;
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

		
		this.productView =  new ProductView2(userToView);
		this.products  = productView.createListView();
		products.setVisible(true);
	//	this.productsActiveSales = productsArray[0];
	//	this.productsPreviousSales =  productsArray[1];
		
	//	this.productsActiveSales.setVisible(false);
	//	this.productsPreviousSales.setVisible(false);
		
		this.userFacade = new UserFacade(user);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{168, 95, 0};
		gridBagLayout.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		 username = new JLabel((String)userFacade.getUser().getNickname());
		 username.setFont(new Font("Tahoma", Font.BOLD, 23));
		GridBagConstraints gbc_username_1 = new GridBagConstraints();
		gbc_username_1.insets = new Insets(0, 0, 5, 5);
		gbc_username_1.anchor = GridBagConstraints.NORTH;
		gbc_username_1.gridx = 0;
		gbc_username_1.gridy = 0;
		add(username, gbc_username_1);
		
		JPanel salesPanel = new JPanel();
		salesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_salesPanel = new GridBagConstraints();
		gbc_salesPanel.gridheight = 3;
		gbc_salesPanel.insets = new Insets(0, 0, 5, 5);
		gbc_salesPanel.fill = GridBagConstraints.BOTH;
		gbc_salesPanel.gridx = 0;
		gbc_salesPanel.gridy = 2;
		add(salesPanel, gbc_salesPanel);
		salesPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		salesPanel.add(content, BorderLayout.CENTER);
		//content.setLayout(new BorderLayout(0, 0));
		
		JPanel head = new JPanel();
		salesPanel.add(head, BorderLayout.NORTH);
		head.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Active Sales");
		head.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	//productsPreviousSales.setVisible(false);
            	//productsActiveSales.setVisible(true);
            	productView.activesSales(true);
            	productView.previousSales(false);
            	
            }
		});
	
		
		JButton btnNewButton_2 = new JButton("Previous Sales");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//productsActiveSales.setVisible(false);
				//productsPreviousSales.setVisible(true);
			 	productView.activesSales(false);
            	productView.previousSales(true);
				
			}
		});
		head.add(btnNewButton_2);
		
		JPanel boutonPanel = new JPanel();
		GridBagConstraints gbc_boutonPanel = new GridBagConstraints();
		gbc_boutonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_boutonPanel.fill = GridBagConstraints.BOTH;
		gbc_boutonPanel.gridheight = 3;
		gbc_boutonPanel.gridx = 1;
		gbc_boutonPanel.gridy = 2;
		add(boutonPanel, gbc_boutonPanel);
		
		if (user.equals(userToView)) {
			JButton btnNewButton = new JButton("Edit Profile");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			boutonPanel.setLayout(new GridLayout(0, 1, 0, 0));
			boutonPanel.add(btnNewButton);
			var this10 = this;
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				UserEditProfileView editView =	 new UserEditProfileView(userFacade.getUser(),this10);
				//	 setEnabled(false);
					
				}
			});
			
			
			JButton btnNotifications = new JButton("Notifications");
			btnNotifications.setBackground(Color.LIGHT_GRAY);
			boutonPanel.add(btnNotifications);
			btnNotifications.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				NotificationListView notificationView =	 new NotificationListView(user);
				//	 setEnabled(false);
					
				}
			});
			
			JButton btnSendTicket = new JButton("Send ticket");
			btnSendTicket.setBackground(Color.LIGHT_GRAY);
			boutonPanel.add(btnSendTicket);
			btnSendTicket.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			JButton btnSignOut = new JButton("Sign Out");
			boutonPanel.add(btnSignOut);
			btnSignOut.setBackground(Color.RED);
			btnSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window[] windows = JFrame.getWindows();
					for (Window w :windows) {
						w.dispose();
					}
					new LoginView();
				}
			});
		}
	
	
		
		JLabel label = new JLabel("");
		boutonPanel.add(label);
		
		if (user.equals(userToView) && user.getIsAdmin()) {
			JButton btnAllTickets = new JButton("All tickets");
			boutonPanel.add(btnAllTickets);
			btnAllTickets.setBackground(Color.ORANGE);
			btnAllTickets.setForeground(Color.BLACK);
			btnAllTickets.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			JButton btnAllUsers = new JButton("All Users");
			boutonPanel.add(btnAllUsers);
			btnAllUsers.setBackground(Color.ORANGE);
			btnAllUsers.addActionListener(e -> {
				UserListView userListView = new UserListView();
			});
			
		}
		

		JLabel label_1 = new JLabel("");
		boutonPanel.add(label_1);
		

	/*	JLabel username = new JLabel((String) null);
		username.setFont(new Font("Tahoma", Font.BOLD, 19));
		this.add(username, BorderLayout.NORTH);*/
		
		
		/*if (user.equals(userToView)) {
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
		}*/
		

		

		//content.add(productsActiveSales);
		//content.add(productsPreviousSales);
		content.add(products);
		this.setVisible(true);  
	}
	
	public void toFront() {
		this.toFront();
	}
	public void setEnabled(boolean bool) {
		this.setEnabled(bool);
	}

	public void update() {
		userFacade = new UserFacade(this.userFacade.getUserById(this.userFacade.getUser().getId()));
		System.out.println(userFacade.getUser().getNickname());
		username.setText(userFacade.getUser().getNickname());
	}
	
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade(null);
		User user = userFacade.getUserDao().getUserById(1);
		UserProfileView view = new UserProfileView(user, user);
	}
}
