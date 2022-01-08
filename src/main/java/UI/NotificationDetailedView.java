package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import Core.Notification;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class NotificationDetailedView extends JFrame {
	
	private static NotificationListView notifview;
	private JFrame frmNotificationDetailed;
	public NotificationDetailedView(Notification notification,NotificationListView notifView) {
		this.notifview = notifView;
		
		frmNotificationDetailed = new JFrame();
		frmNotificationDetailed.setTitle("Notification Detailed");
		frmNotificationDetailed.setSize(new Dimension(196, 234));
		frmNotificationDetailed.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(notification.getType());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 145, 22);
		frmNotificationDetailed.getContentPane().add(lblNewLabel);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 162, 93);
		frmNotificationDetailed.getContentPane().add(scrollPane);
		
		JTextPane txtpnLoremIpsumDolor = new JTextPane();
		txtpnLoremIpsumDolor.setEditable(false);
		scrollPane.setViewportView(txtpnLoremIpsumDolor);
		txtpnLoremIpsumDolor.setText(notification.getDescription());
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNotificationDetailed.dispose();
				notifView.enable(true);
				notifView.bringToFg();
			}
		});
		btnNewButton.setBounds(49, 155, 85, 21);
		frmNotificationDetailed.getContentPane().add(btnNewButton);
		
		frmNotificationDetailed.setResizable(false);
		frmNotificationDetailed.setDefaultCloseOperation(onClose());
		frmNotificationDetailed.setVisible(true);
}
	private int onClose() {
		frmNotificationDetailed.dispose();
		//notifview.enable(true);
		return 0;
	}
	public static void main(String[] args) {
	
	
	}
}
