package Core;

import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private String nickname;
    private Date dob;
    private List<Product> productsSold;
    private List<Product> productsOwned;

    /**
     * 
     * @param id  id
     * @param fn  firstname
     * @param ln  lastname
     * @param nn  nickname
     * @param em  email
     * @param pw  password
     * @param dob Date of birth
     */
    public User(int id, String fn, String ln, String nn, String em, String pw, Date dob) {
        this.id = id;
        this.lastname = ln;
        this.firstname = fn;
        this.password = pw;
        this.email = em;
        this.nickname = nn;
        this.dob = dob;
    }

    /**
     * Getter method for the password
     * 
     * @return user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter method for the nickname
     * 
     * @return user's nickname
     */
    public String getNickname() {
        return this.nickname;
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
     * set the user's attributes relative to the products
     * 
     * @param owned list of products owned by the user
     * @param sold list of products sold by the user
     */
    public void setUsersProducts(List<Product> owned, List<Product> sold) {
        //TODO
    }
}
