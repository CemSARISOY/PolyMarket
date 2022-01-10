package Core;

import java.sql.Date
;
import java.util.List;

import Persist.AbstractFactoryDao;
import Persist.AbstractFactoryDaoMySQL;
import Persist.ProductDao;
import Persist.ProductDaoMySQL;
import Persist.UserDao;
import Persist.UserDaoMySQL;

public class UserFacade {
	private User user;
	private UserDao userDao;
	private ProductDao productDao;
	
	
	public  UserFacade(User user) {
		this.productDao = ProductDaoMySQL.getProductDaoMySQL(AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL());
		this.user = user;
		this.userDao = UserDaoMySQL.getUserDaoMySQL(AbstractFactoryDaoMySQL.getAbstractFactoryDaoMySQL());
	}
    
	/**
     * Signs the user up in the application
     * 
     * @param nickname User's nick name
     * @param password User's password
     * @param firstname User's firstname
     * @param lastname User's lastname
     * @param email User's email
     * @param day User's date of birth
     * @param month User's date of birth
     * @param year User's date of birth
     * 
     *
     */
	public void signUp(String firstname,String lastname,String nickname, String email,String pw,int day ,int month , int year) throws Exception {
		
		if (firstname == "" || lastname== "" || nickname == "" || email == "" || pw == "") {
			throw new Exception("One of the field is empty");
		}
		else if (day<1 || day>31) {
			throw new Exception("Day field is incorret");
		}
		else if (month<1 || month>12) {
			throw new Exception("Month field is incorret");
		}
		else if (year<1900 && year >2022) {
			throw new Exception("Year field is incorret");
		}
		else {
		this.userDao.signUp(firstname,lastname,nickname,email,pw,new Date(year-1900, month-1, day));
		}
	}
	
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public User[] getAllUser() {
		return this.userDao.getAllUser();
	}
	 /**
     * Deletes one user from the database
     * 
     * @param id the id of the user to delete
	 * @return 
     * @return the {@code User} that has been deleted
     */
	public User deletUser(int id) {
	
		return this.userDao.deleteUser(id);
	}
	
	public User modifyUser(int id,String firstname, String lastname,String nickname, String email,String pw,Date dob, double balance) {
		return this.userDao.modifyUser(id,firstname,lastname,nickname,email,pw,dob, balance);
	}
	
	public List<Product> getProductByUser(User user ){
		return this.productDao.getProductByUser(user);
	}
	
	public List<Product> getProductsByAuthor(User user){
		return this.productDao.getProductByAuthor(user);
			
	}

}
