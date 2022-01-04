package Core;

import java.util.Date;

public class Product {

    private int id;
    private String name;
    private String token;
    private int content;
    private int categoryId;
    private String body;
    private int author;
    private double price;
    private Date startDate;

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, String token, int content, int categoryId,
                   String body, int author, double price, Date startDate){
        this.id = id;
        this.name = name;
        this.token = token;
        this.content = content;
        this.categoryId = categoryId;
        this.body = body;
        this.author = author;
        this.price = price;
        this.startDate = startDate;
    }

    public Product(String name, String token, int content, int categoryId,
                   String body, int author, double price, Date startDate){
        this.name = name;
        this.token = token;
        this.content = content;
        this.categoryId = categoryId;
        this.body = body;
        this.author = author;
        this.price = price;
        this.startDate = startDate;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getBody() {
        return this.body;
    }
    
}
