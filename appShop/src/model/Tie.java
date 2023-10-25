package model;

public class Tie extends Product {
    private String silk="silk";
    private String wool="wool";
    private int silkPrice=45000;
    private int woolPrice=30000;
    private String material;
    private int width;

    public Tie(int id, String silk, String wool, int silkPrice, int woolPrice, String material, int width) {
        super(id);
        this.silk = silk;
        this.wool = wool;
        this.silkPrice = silkPrice;
        this.woolPrice = woolPrice;
        this.material = material;
        this.width = width;
    }
    
    public String getSilk() {
        return silk;
    }

    public void setSilk(String silk) {
        this.silk = silk;
    }

    public String getWool() {
        return wool;
    }

    public void setWool(String wool) {
        this.wool = wool;
    }

    public int getSilkPrice() {
        return silkPrice;
    }

    public void setSilkPrice(int silkPrice) {
        this.silkPrice = silkPrice;
    }

    public int getWoolPrice() {
        return woolPrice;
    }

    public void setWoolPrice(int woolPrice) {
        this.woolPrice = woolPrice;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void calculatePrice(){
        if(material.equals(silk)){
            price=silkPrice;
        }else if(material.equals(wool)){
            price=woolPrice;
        }
        super.price=price;
    }
    
}
    
