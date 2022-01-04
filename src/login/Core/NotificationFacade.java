package Core;

import java.util.List;

import Persist.NotificationDao;

public class NotificationFacade {
    
    
     NotificationDao notificationDao;
    

    //                          Operations                                  
    
    /**
     * Marks a notification as read
     * 
     * @param notification the notification to mark as read
     */
      public void markAsRead(Notification notification) {
            this.notificationDao.markAsRead(notif.getId());
        }
	
    
    
    /**
     * sends a notification to a user
     * @param notif the notification to send 
     * @param u user to send the notification to
     */
    public void sendNotifications(Notification notif,User user){
		this.notificationDao.sendNotifications(notif, user);
	}
    
    public Notification[] getNotificationsOfUser(User user) {
		return this.notificationDao.getNotificationsOfUser(user);
	}
	
	public void modifyNotification(int id,String type,String desc,int isRead) {
		this.notificationDao.modifyNotification(id, type, desc, isRead);
	}
	
	public void deleteNotification(int id) {
		this.notificationDao.deleteNotification(id);
	}
	
	public void createNotification(String type,String desc) {
		this.notificationDao.createNotification(type, desc);
	}
	Notification getNotificationById(int id) {
		return this.notificationDao.getNotificationById(id);
		}
    
}
