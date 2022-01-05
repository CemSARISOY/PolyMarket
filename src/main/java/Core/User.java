package Core;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private int id;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private String nickname;
    private Date dob;
    private ArrayList<Product> productsOwned;
    private boolean isAdmin;
    private double balance;

    /**
     * 
     * @param id  id
     * @param fn  firstname
     * @param ln  lastname
     * @param nn  nickname
     * @param em  email
     * @param pw  password
     * @param dob Date of birth
     * @param isAdmin isAdmin
     * @param balance balance
     */
    public User(int id, String fn, String ln, String nn, String em, String pw, Date dob, boolean isAdmin, double balance) {
        this.id = id;
        this.lastname = ln;
        this.firstname = fn;
        this.password = pw;
        this.email = em;
        this.nickname = nn;
        this.dob = dob;
        this.isAdmin = isAdmin;
        this.balance = balance;
    }

    //Useless constructor, just temporarily for DeliveryView constructor
    public User(int id) {
        this.id = id;
    }

    /**
     * Getter method for the password
     * 
     * @return user's passowrd
     */
    public String getPassword() {
        return this.password;
    } 

    public ArrayList<Product> getProducts() {
        return this.productsOwned;
    }

    public ArrayList<Product> setProducts(ArrayList<Product> p) {
        this.productsOwned = p;
        return this.productsOwned;
    }

    /**
     * Getter method for the nickname
     * 
     * @return user's nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof User))
            return false;
        User u2 = (User) obj;
        if (this.id != u2.id || !this.lastname.equals(u2.lastname) || !this.firstname.equals(firstname)
                || !this.nickname.equals(u2.nickname) || !this.email.equals(u2.email) || !this.dob.equals(u2.dob))
            return false;
        return true;
    }


    /**
     * Getter method for the id
     * @return
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter method for the isAdmin
     * @return isAdmin
     */
    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    /**
     * Getter method for the isAdmin
     * @return isAdmin
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Getter method for the isAdmin
     * @return isAdmin
     */
    public double setBalance(double newBalance) {
        this.balance = newBalance;
        return this.balance;
    }
}
