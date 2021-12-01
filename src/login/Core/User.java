package Core;


import java.util.Date;

/**
* @generated
*/
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
    public User(int id, String ln, String fn, String pw, String em, String nn, Date dob, LoginFacade lf) {
        this.id = id;
        this.lastname = ln;
        this.firstname = fn;
        this.password = pw;
        this.email = em;
        this.nickname = nn;
        this.dob = dob;
        this.lf = lf;
    }


    /*Methods
     */
    public LoginFacade getLF() {
        return this.lf;
    }
    
    public LoginFacade setLF(LoginFacade l) {
        this.lf = l;
        return this.lf;
    }
    
}
