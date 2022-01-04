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
    private java.sql.Date dob;

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
    public User(int id, String fn, String ln, String nn, String em, String pw, java.sql.Date dob) {
        this.id = id;
        this.lastname = ln;
        this.firstname = fn;
        this.password = pw;
        this.email = em;
        this.nickname = nn;
        this.dob = dob;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", password=" + password
				+ ", email=" + email + ", nickname=" + nickname + ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

}
