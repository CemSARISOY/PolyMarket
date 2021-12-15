package Persist;

import java.util.List;

import Core.Notification;

public interface NotificationDao {

    /**
     * Gets the notification of the user based on an ID
     * 
     * @param id the id of the user to look for the notifications
     * 
     * @return a {@code List} of the notifications of the user
     */
    List<Notification> getNotificationsOfUser(int id);

    /**
     * Modifies the notification, it only sets its isRead attribute to true
     * 
     * @param id id of the notification to modify
     * @return the modified {@code Notification} 
     */
    Notification modifyNotification(int id);

    /**
     * Deletes a notification from the database
     * 
     * @param id id of the notification to delete
     * @return the deleted {@code Notification}
     */
    Notification deleteNotification(int id);


    /**
     * Creates a notification for a user
     * 
     * @param nickname the user for whom the notification is related to
     * @param type the type of notification (i.e : Product, Order, ...)
     * @param description a text explaining why the notification was created
     * 
     * @return the newly created {@code Notification}
     */
    Notification createNotification(String nickname, String type, String description);
    
}
