package model;

public class Tie extends Product{

    public final String SILK = "Silk"; 
    public final String WOOL = "Wool"; 
    public final int SILK_PRICE = 45000;
    private int WOOL_PRICE = 30000;
    private String material;
    private int width;
    

    public Tie(String id, String material, int width, int price ){
        super(id, price);
        this.material = material;
        this.width = width;
    }

    public String getMaterial(){

        return material; 
    }

    public void setMaterial(String material){

        this.material = material;
    }

    public int width(){

        return width;
    }

    public void width(int width){   

        this.width = width;
    }

    public String toString(){

        String result = super.toString();
        result += "Material: " + material + " Width: " + width;

        return result;
    }

    @Override
    public void calculatePrice(){
        if(material.equals(SILK)){
        super.price = super.price + (SILK_PRICE*width);
        }else if(material.equals(WOOL)){
        super.price = super.price + ( WOOL_PRICE*width);
        }
    }
}
    
