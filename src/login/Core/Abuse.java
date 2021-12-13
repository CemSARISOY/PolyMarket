package Core;


/**
* @generated
*/
public class Abuse {
    
    private Integer id;
    private String title;
    private Integer userTargetRef;
    private String desc;
    
    
    /**
    Getters and setters
    */
    public String getTitle() {
        return this.title;
    }
    
    public String setTitle(String title) {
        this.title = title;
        return this.title;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public Integer setId(Integer id) {
        this.id = id;
        return this.id;
    }
    
    public Integer getTargetRef() {
        return this.userTargetRef;
    }
    
    public Integer setTargetRef(Integer userRef) {
        this.userTargetRef = userRef;
        return this.userTargetRef;
    }

    public String getDesc() {
        return this.desc;
    }
    
    public String setDesc(String desc) {
        this.desc = desc;
        return this.desc;
    }
    
}
