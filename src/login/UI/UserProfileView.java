package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.User;
import Core.UserFacade;
import Persist.AbstractFactoryDao;
import Persist.ProductDaoMySql;
import Persist.UserDaoMySQL;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileView extends JFrame {
	
	private static JFrame frame;

	private static JPanel contentPane;

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
		
		
		this.userFacade = new UserFacade(user,new UserDaoMySQL(AbstractFactoryDao.getFactory("mysql")), new ProductDaoMySql());

        frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Integer realWidth = (int) Math.round(0.5 * screenSize.getWidth());
        Integer realHeight = (int) Math.round(0.5 * screenSize.getHeight());

        frame.setTitle("PolyMarket Edit Profile");
        frame.setLocation(new Point(realWidth - 200, realHeight - 100));
        frame.setSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("draw.png").getImage());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JLabel(userToView.getNickname());
		username.setFont(new Font("Tahoma", Font.BOLD, 19));
		username.setBounds(33, 20, 139, 33);
		frame.add(username);
		
		
		if (user.equals(userToView)) {
			UserProfileView instance = this;
			JButton btnNewButton = new JButton("Edit Profile");
			btnNewButton.setBounds(558, 30, 85, 21);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
             	  new UserEditProfileView(userFacade.getUser(),instance);
             	  frame.setEnabled(false);
             	  
                }
             });
			frame.add(btnNewButton);
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(10, 112, 671, 294);
		frame.add(tabbedPane);
		
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
		
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500,400));
		contentPane.add(scrollPane);

		frame.add(panel);
		frame.setVisible(true);
		
		
	}
	
	public void toFront() {
		frame.toFront();
	}
	public void setEnabled(boolean bool) {
		frame.setEnabled(bool);
	}

	public void update() {
		userFacade = new UserFacade(this.userFacade.getUserById(this.userFacade.getUser().getId()),new UserDaoMySQL(AbstractFactoryDao.getFactory("mysql")), new ProductDaoMySql());
		System.out.println(userFacade.getUser().getNickname());
		username.setText(userFacade.getUser().getNickname());
	}
	
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade(null,new UserDaoMySQL(AbstractFactoryDao.getFactory("mysql")), null);
		User user = userFacade.getUserDao().getUserById(1);
		UserProfileView view = new UserProfileView(user, user);
	}
}
