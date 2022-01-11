package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Core.Notification;
import Persist.AbstractFactoryDaoMySQL;
import Persist.NotificationDao;
import Persist.NotificationDaoMySQL;

public class NotificationDaoMySQLTest {
	  	@Test
	    void markAsReadTest() {
	       NotificationDao notificationDao =  new NotificationDaoMySQL(AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL());
	       Notification notification = notificationDao.createNotification("junit", "test");
	       notification = notificationDao.markAsRead(notification.getId());
	       assertTrue(notification.getIsRead());
	       notificationDao.deleteNotification(notification.getId());
	  }
}
