package Core;

import Persist.NotificationDao;

public class NotificationFacade {
    
    
    private NotificationDao notificationDao;
    

    //                          Operations                                  
    
    /**
     * Marks a notification as read
     * 
     * @param notification the notification to mark as read
     */
    public void markAsRead(Notification notification) {
        //TODO
    }
    
    
    /**
     * sends a notification to a user
     * 
     * @param u user to send the notification to
     * @return the sent {@code Notification}
     */
    public Notification sendNotification(User u) {
        //TODO
        return null;
    }
    
}
