package model;

public class Blouse extends Product {
    private String polyester="polyester";
    private String silk="silk";
    private String cotton="cotton";
    private int pricePerMaterial=5000;
    private double discount=0.2;
    private String black="black";
    private String white="white";
    private String color;
    private char size;
    private String material[];

    public Blouse(int id, String polyester, String silk, String cotton, int pricePerMaterial, double discount, String black, String white, String color, char size, String[] material) {
        super(id);
        this.polyester = polyester;
        this.silk = silk;
        this.cotton = cotton;
        this.pricePerMaterial = pricePerMaterial;
        this.discount = discount;
        this.black = black;
        this.white = white;
        this.color = color;
        this.size = size;
        this.material = material;
    }
    
    public String getPolyester() {
        return polyester;
    }

    public void setPolyester(String polyester) {
        this.polyester = polyester;
    }

    public String getSilk() {
        return silk;
    }

    public void setSilk(String silk) {
        this.silk = silk;
    }

    public String getCotton() {
        return cotton;
    }

    public void setCotton(String cotton) {
        this.cotton = cotton;
    }

    public int getPricePerMaterial() {
        return pricePerMaterial;
    }

    public void setPricePerMaterial(int pricePerMaterial) {
        this.pricePerMaterial = pricePerMaterial;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String[] getMaterial() {
        return material;
    }

    public void setMaterial(String[] material) {
        this.material = material;
    }

    public void calculatePrice(){
     super.price=pricePerMaterial;  
    }
}
