package Core;

import java.util.Date;

public class Bid {

    private int id;

    private boolean isPayed;

    private int idBider;

    private double amount;

    private Date dateOfBid;

    public Date setDate (Date d){
        this.dateOfBid = d;
        return this.dateOfBid;
    }

    public Date getDate() {
        return this.dateOfBid;
    }

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public int getId() {
        return this.id;
    }

    public int setIdBider(int id) {
        this.idBider = id;
        return this.idBider;
    }

    public int getIdBider() {
        return this.idBider;
    }

    public double setAmount(double am) {
        this.amount = am;
        return this.amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean setIsPayed(boolean p) {
        this.isPayed = p;
        return this.isPayed;
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }

}
