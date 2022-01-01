package Core;


/**
* @generated
*/
public class Abuse {
    
    private int id;
    private String title;
    private String desc;
    private User userReporting;
    private User userTarget;
    
    public Abuse(int id, String title, String desc, User u1, User u2){
        this.id = id;
        this.title = title;
        this.desc = desc;
        userReporting = u1;
        userTarget = u2;
    }
    
    /**
    Getters and setters
    */
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public User getTarget() {
        return this.userTarget;
    }
    
    public void setTargetRef(User userRef) {
        this.userTarget = userRef;
    }

    public User getReporter() {
        return this.userReporting;
    }
    
    public void setReporter(User userRef) {
        this.userReporting = userRef;
    }


    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
