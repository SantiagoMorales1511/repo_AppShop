package model;

public class Blouse extends Product{

    public final String SILK = "Silk"; 
    public final String POLYESTER = "Polyester"; 
    public final String COTTON = "cotton";
    public final int PRICE_PER_MATERIAL = 500;
    public final double DISCOUNT = 0.2;
    public final String BLACK = "Black"; 
    public final String WHITE = "White"; 
    private String color; 
    private char size; 
    private String[] materials;

    public Blouse(String id, int price, char size, String[] materials, String color){

       super(id,price);
       this.size = size; 
       this.materials = materials; 
       this.color = color; 


    }
    
    public char getSize(){

        return size; 
    }

    public void setSIze(char size){

        this.size = size; 
    }

    public String[] getMaterials(){

        return materials;
    }

    public void setMaterial(String []materials ){

        this.materials = materials;
    }

    public String getColor(){

        return color;
    }

    public void setColor(String color){

        this.color = color;
    }

    public void calculatePrice(){

         super.price = ( materials.length *PRICE_PER_MATERIAL );
    }
    
    public String toString(){

        String result = super.toString();
        result += "size: " + size + " materials: " + materials + " color: " + color; 

        return result;
    }

    @Override
    public void calculateDiscount() {

        double descuento = 0;
        descuento = super.price * DISCOUNT;
        super.price = super.price - (int) descuento;
    }
}
