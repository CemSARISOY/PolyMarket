package Core;


/**
* @generated
*/
public class Category {
    
    private int id;
    private String name;
    
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
    Getters and setters
     */
    public int getId() {
        return this.id;
    }
    
    public int setId(Integer id) {
        this.id = id;
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String setName(String name) {
        this.name = name;
        return this.name;
    }
    
}
