package model;

public class Jeans extends Product implements Discounts{


    public final int PRICE_PER_CM = 1000;
    public final boolean MALE = true;
    public final  boolean FEMALE = false;
    public final double DISCOUNT = 0.25;
    private boolean gender; 
    private int length; 
   
    
    public Jeans(String id, boolean gender, int length, int price){
        super(id, price);
        this.gender = gender; 
        this.length = length; 

    }

    public boolean getGender(){

        return gender; 
    }

    public void setGender(boolean gender){

        this.gender = gender; 
    }
    
    public int getLength(){

        return length; 
    }

    public void setLength(int length){

        this.length = length;
    }

    public String toString(){

        String result = super.toString();
        result += "gender: " + gender + " length: " + length; 

        return result; 
    }

    @Override
    public void calculateDiscount() {
     
        double descuento = 0;
            if (gender == FEMALE){
                descuento = super.price * DISCOUNT;
                super.price = super.price - (int) descuento;

            }
    }

    @Override
    public void calculatePrice(){
       super.price = super.price + (PRICE_PER_CM * length);
        /* Como seria siendo private 
         int totalPrice = getPrice() + (PRICE_PER_CM * length);
         setPrice(totalPrice);
         */
    }
}
