package model;

public class Jeans extends Product {
    private int pricePerCM=1000;
    private boolean male=true;
    private boolean female=false;
    private double discount=0.25;
    private boolean gender;
    private int length;

   
    public Jeans(String id, boolean gender, int length, int price){
        super(id, price);
        this.gender = gender; 
        this.length = length; 

    }
    
   
    public int getPricePerCM() {
        return pricePerCM;
    }

    public void setPricePerCM(int pricePerCM) {
        this.pricePerCM = pricePerCM;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void calculateDicount() {
        double descuento = 0;

        if(gender == female){
            descuento = super.price * discount;
            super.price = super.price - (int)descuento;
        }

        
    }

    @Override
    public void calculatePrice(){
        super.price = super.price + (pricePerCM * length);

        /* Como seria siendo privado 

        int totalPrice = getPrice() + (pricePerCM * length);

        setPrice(totalPrice);
        */
    }

    

    
}
