package Core;

import Persist.NotificationDao;

public class NotificationFacade {
	
	NotificationDao notificationDao;
	
	public NotificationFacade(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	
		
	}
	
	public void markAsRead(Notification notif) {
		this.notificationDao.markAsRead(notif.getId());
	}
	
	public void sendNotifications(Notification notif,User user){
		this.notificationDao.sendNotifications(notif, user);
	}
	
	/**
    * gets all the notifications of the user currently logged
    * 
    * @return a {@code List<Notification> } whether they are read or not
    */
	public Notification[] getNotificationsOfUser(User user) {
		return this.notificationDao.getNotificationsOfUser(user);
	}
	
	/**
     * gets all the notifications of the user currently logged
     * 
     * @return a {@code List<Notification> } whether they are read or not
     */
    public Notification[] getNotifications(){
        return null;
    }
	
	public void modifyNotification(int id,String type,String desc,int isRead) {
		this.notificationDao.modifyNotification(id, type, desc, isRead);
	}
	
	public void deleteNotification(int id) {
		this.notificationDao.deleteNotification(id);
	}
	
	public Notification createNotification(String type,String desc) {
		return this.notificationDao.createNotification(type, desc);
	}
	Notification getNotificationById(int id) {
		return this.notificationDao.getNotificationById(id);
		}
}
