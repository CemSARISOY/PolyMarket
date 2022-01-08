package Persist;

import Core.Notification;
import Core.User;

public interface NotificationDao {


	public void sendNotifications(Notification notif,User user);
	 /**
     * Gets the notification of the user based on an ID
     * 
     * @param id the id of the user to look for the notifications
     * 
     * @return a {@code Notification[]} of the notifications of the user
     */
	public Notification[] getNotificationsOfUser(User user);
	
	public void modifyNotification(int id,String type,String desc,int isRead);
	/**
     * Deletes a notification from the database
     * 
     * @param id id of the notification to delete
     * @return the deleted {@code Notification}
     */
	public Notification deleteNotification(int id);
	 /**
     * Creates a notification
     * 

     * @param type the type of notification (i.e : Product, Order, ...)
     * @param description a text explaining why the notification was created
     * 
     * @return the newly created {@code Notification}
     */

	public Notification createNotification(String type,String desc);
	 /**
     * Modifies the notification, it only sets its isRead attribute to true
     * 
     * @param id id of the notification to modify
     * @return the modified {@code Notification} 
     */
	Notification markAsRead(int id);
	/**
     * get a notification from the database
     * 
     * @param id used to get notification
     * @return  {@code Notification}
     */
	Notification getNotificationById(int id);
		
	

}
