package Core;

abstract class AbstractProdcutList {

    private int id;
    private int productListID;
    private String title;
    private int userId;

    /**
     * Constructor of AbstractProdcutList
     * @param id
     * @param products
     * @param title
     */
    public AbstractProdcutList(int id, int userId,  String title, int products) {
        this.id = id;
        this.userId = userId;
        this.productListID = products;
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
     * Getter of products
     * @return AbstractProdcutList's products
     */
    public int getProducts() {
        return this.productListID;
    }

    /**
     * Setter of products
     * @param products
     */
    public void setProducts(int products) {
        this.productListID = products;
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


    /**
     * Add a product to products
     */
    public void addProduct() {
        //TODO
    }
}
