package Core;

public class ProductList {

    private int id;
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;

    public ProductList(int id){
        this.id = id;
    }

    public void setp1(int p) {
        this.p1 = p;
    }
    public void resetp1(int p) {
        this.p1 = Integer.parseInt(null);
    }
    public void setp2(int p) {
        this.p2 = p;
    }
    public void setp3(int p) {
        this.p3 = p;
    }
    public void setp4(int p) {
        this.p4 = p;
    }
    public void setp5(int p) {
        this.p5 = p;
    }
}
