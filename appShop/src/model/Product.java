package model;

public abstract class Product {
    private String id;
    protected double price;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
    }
    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    public void calculatePrice(){
        
    }
    
}
