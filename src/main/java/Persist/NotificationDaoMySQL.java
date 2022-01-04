package Persist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Core.Notification;
import Core.User;

public class NotificationDaoMySQL implements NotificationDao{
	
	   private AbstractFactoryDao creator;

	    public NotificationDaoMySQL(AbstractFactoryDao creator) {
	        this.creator = creator;
	    }

		@Override
		public void sendNotifications(Notification notif, User user) {
			String requete = 
	        		"INSERT INTO notifier (id_user, id_notif) VALUES  (\"" + user.getId() + "\" , \"" + notif.getId() + "\");";
	        Connection con = creator.getConnection();
	        try {
	            Statement stmt = con.createStatement();
	            int rs = stmt.executeUpdate(requete);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}
		@Override
		public Notification getNotificationById(int id) {
			String requete = "SELECT * from notifications where id = " + id;
	        Connection con = creator.getConnection();
	        Notification notif = null;
	        try {
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(requete);
	            while (rs.next())
	                notif = new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return notif;
		}

		@Override
		public Notification[] getNotificationsOfUser(User user) {
			
	    	  String requete = "SELECT COUNT(*) FROM notifier WHERE id_user =" + user.getId();
	    	  Connection con = creator.getConnection();
	    	  int dimension = -1;
	    	  try {
	              Statement stmt = con.createStatement();
	              ResultSet rs = stmt.executeQuery(requete);
	              while (rs.next()) {
	          
	                  dimension = rs.getInt(1);
	              }
	              
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	    	
	    	
	    	
	       requete = "SELECT id_notif from notifier where id_user = "+ user.getId();
	       Notification[] notifs = new Notification[dimension];
	        Notification notif = null;
	        try {
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(requete);
	            int i = 0;
	            while (rs.next()) {
	           
	                notif = getNotificationById(rs.getInt(1));
	                notifs[i] = notif;
	                i++;
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
	        return notifs;
	    }

		@Override
		public void modifyNotification(int id, String type, String desc, int isRead) {
			 String requete = " UPDATE notifications  SET type = \"" + type 
		        		+ "\", description = \"" + desc + "\", isRead = \"" + isRead 
		        		+"\"  where id = " + id;
		  
		        Connection con = creator.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		           stmt.executeUpdate(requete);
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		     
			
		}

		@Override
		public Notification markAsRead(int id) {
			 String requete = " UPDATE notifications  SET isRead = \"" + 1 
		        		+"\"  where id = " + id;
		  
		        Connection con = creator.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		           stmt.executeUpdate(requete);
		           return this.getNotificationById(id);
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		     
			
		}
		
		@Override
		public Notification deleteNotification(int id) {
			
			Notification notif = this.getNotificationById(id);
			  String requete = "DELETE from notifications where id = " + id;
		        Connection con = creator.getConnection();
		       
		        try {
		            Statement stmt = con.createStatement();
		           stmt.executeUpdate(requete);
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		         requete = "DELETE from notifier where id_notif = " + id;
		         con = creator.getConnection();
		       
		        try {
		            Statement stmt = con.createStatement();
		           stmt.executeUpdate(requete);
		           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return notif;
			
		}

		@Override
		public Notification createNotification(String type, String desc) {
		      String requete = 
		        		"INSERT INTO notifications (type, description) VALUES  (\"" + type + "\" , \"" + desc + "\");";
		        Connection con = creator.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            int rs = stmt.executeUpdate(requete);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		        String requete2 = "SELECT * from notifications where type  = " + type +" AND description = "+desc;
		        Notification notif = null;
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(requete2);
		            while (rs.next())
		                notif = new Notification(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		        return notif;
		}
		
		
		public static void main(String[] args) {
			AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
			NotificationDaoMySQL notif = new NotificationDaoMySQL(abstractFactoryDao);
			UserDaoMySQL userDaoMySql = new UserDaoMySQL(abstractFactoryDao);
	    	User user = userDaoMySql.getUserById(2);
	    	//Notification not = notif.getNotificationById(3);
	    	
	    	//notif.sendNotifications(not, user);
	    	//notif.createNotification("UserProfileView db", "test2");
			//notif.markAsRead(1);
			//notif.modifyNotification(1, "a", "aaa", 0);
			//notif.deleteNotification(1);
			//System.out.println(notif.getNotificationById(2).getDescription());
	    	Notification[] test = notif.getNotificationsOfUser(user);
	    	for (int i = 0 ; i<test.length;i++) {
	    		System.out.println(test[i].getDescription());
	    	}
		}
}
