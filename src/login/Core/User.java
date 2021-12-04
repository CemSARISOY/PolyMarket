package Core;


import java.util.Date;


public class User {

    /*User infos
     */
    private int id;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private String nickname;
    private Date dob;

    /**
     * 
     * @param id id
     * @param fn firstname
     * @param ln lastname
     * @param nn nickname
     * @param em email
     * @param pw password
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
     * @return user's passowrd
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Getter method for the nickname
     * @return user's nickname
     */
    public String getNickname(){
        return this.nickname;
    }
    
}
