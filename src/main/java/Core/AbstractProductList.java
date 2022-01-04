package Core;

abstract class AbstractProdcutList {

    private Integer id = null;
    private String title;
    private int userId;

    /**
     * Constructor of AbstractProdcutList when id is known
     * @param id
     * @param title
     */
    public AbstractProdcutList(int id , int userId,  String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public AbstractProdcutList(int userId,  String title) {
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    /**
     * Getter of title
     * @return AbstractProdcutList's title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter of title
     * @param title AbstractProdcutList's title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
