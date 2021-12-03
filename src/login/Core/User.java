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

    /*Login facade
     */
    private LoginFacade lf;

    
    /*Constructor
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


    /*Methods
     */
    public LoginFacade getLF() {
        return this.lf;
    }

    public String getPassword(){
        return this.password;
    }

    public String getNickname(){
        return this.nickname;
    }
    
    public LoginFacade setLF(LoginFacade l) {
        this.lf = l;
        return this.lf;
    }
    
}
