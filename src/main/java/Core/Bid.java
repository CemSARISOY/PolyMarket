package Core;

import java.util.Date;

public class Bid {

    private int id;
    private boolean isPaid;
    private int idBider;
    private double amount;

    private Date dateOfBid;

    public void setDate (Date d){
        this.dateOfBid = d;
    }

    public Date getDate() {
        return this.dateOfBid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setIdBider(int id) {
        this.idBider = id;
    }

    public int getIdBider() {
        return this.idBider;
    }

    public void setAmount(double am) {
        this.amount = am;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setIsPaid(boolean p) {
        this.isPaid = p;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

}
