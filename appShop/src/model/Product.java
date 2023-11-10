package model;

public abstract class Product {

    private String id; 
    protected int price;
    private boolean sold;


    public Product(String id, int price){
        this.id = id; 
        this.price = price;
        this.sold = false;
    }

    public String getId(){

        return id; 
    }

    public void setId(String id){

        this.id = id; 
    }

    public int getPrice(){

        return price; 
    }

    public void setPrice(int price){

        this.price = price; 
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getInfo(){

        return getInfo(); 
    }

    public String toString(){

        return " -id: " + id + " -price: " + price + " ";

    }

    public void calculatePrice(){

    }

    public void calculateDiscount(){

    }
}
