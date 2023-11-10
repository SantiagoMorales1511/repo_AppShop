package model;
import java.util.ArrayList;
//Adicionar la matris de los product porque son estanteria
public class Shop {

    private String name;
    private ArrayList<Product> catalog;
    private Product [][] shelf;
    public final int MAX_FIL = 4;
    public final int MAX_COL = 3;


    public Shop(String name) {
        catalog = new ArrayList<Product>();
        shelf = new Product[MAX_FIL][MAX_COL];
        this.name = name; 
    }

    public String showCatalog() {
        String message = "";
        for(int i = 0; i < catalog.size(); i++){
            if(catalog.get(i) != null){
                message += catalog.get(i).toString() + "\n";
            }
        }
        return message;
    }

    public String searchNumSizeProduct(String size){

        String messageNumSize = "";
        int count = 0;
        for(int i = 0; i < catalog.size(); i++){
            if(catalog.get(i) != null){
                if(catalog.get(i) instanceof Blouse){ //verificacion de clase objeto
                    Blouse objBlouse = (Blouse) catalog.get(i);
                    if(objBlouse.getSize().equalsIgnoreCase(size)){
                        count++;
                    }
                }
            }
        }
        messageNumSize = "El numero de blusas de talla " + size + " es: " + count;
        return messageNumSize;
    }

    public double averagePrice(int product) {
        double averagePrice = 0.0;
        double sum = 0.0;
        double count = 0.0;
        for(int i = 0; i < catalog.size(); i++){
            if(catalog.get(i) != null){
                sum += catalog.get(i).getPrice();
                count++;
            }
        }
        if(count != 0){
            averagePrice = sum / count;
        }
        return averagePrice;
    }
    
    public Product searchProduct(String product){
        Product objEncontrado = null;
        boolean find = false;
        for(int i = 0; i < catalog.size() && !find; i++){
            
                if(catalog.get(i).getId().equals(product)){
                    objEncontrado = catalog.get(i);
                    find = true;
                }
            
        }
        return objEncontrado;
    }

   
    public String addProductToCatalog(String id, int price, boolean gender, int lenght) { //Jeans
        
        String message = "Prodducto exitosamente agregado al catalogo";
            Product objP = searchProduct(id);
                if(objP != null){
                    message = "El producto ya existe";
                    }else{
                    objP = new Jeans(id, gender, lenght, price);
                    catalog.add(objP);
                    addProducToShelf(objP);
                    }
    
        return message;
    }

    public String addProductToCatalog(String id, String size, String[] materials, String color, int price) { //blouse
        String message = "";
        Product objP = searchProduct(id);
        if(objP != null){
            message = "El producto ya existe";
            }else{
                objP = new Blouse(id, price, size, materials, color);
                catalog.add(objP);
                addProducToShelf(objP);
            }
        return message;
    }

    public String addProductToCatalog(String id, String material, int width, int price ) { //Tie
        String message = "";
        Product objP = searchProduct(id);
        if(objP != null){
            message = "El producto ya existe";
            }else{
                objP = new Tie(id, material, width,  price);
                catalog.add(objP);
                addProducToShelf(objP);
            }
        return message;
    }
 

    public void addProducToShelf(Product objP){
        boolean found=false;
        for(int i = 0; i < MAX_FIL && ! found; i++){
            for(int j = 0; i < MAX_COL && ! found; i++){
                if(shelf[i][j]==null){
                    shelf[i][j] = objP;
                    found=true;
                }
            }
        }
    }

    public boolean checkShelf(){
        boolean found=false;
        for(int i = 0; i < MAX_FIL && ! found; i++){
            for(int j = 0; i < MAX_COL && ! found; i++){
                if(shelf[i][j]==null){
                    found=true;
                }
            }
        }
        return found;
    }

    public String showShelf(){
        String message = " ";
        for(int i = 0; i < MAX_FIL; i++){
            for(int j = 0; i < MAX_COL; i++){
                if(shelf[i][j]==null){
                    message+="FREE ";
                }
                else if(shelf[i][j] instanceof Tie){
                    message+="Tie ";
                }
                else if(shelf[i][j] instanceof Blouse){
                    message+="Blouse  ";
                }
                else if(shelf[i][j] instanceof Jeans){
                    message+="Jeans ";
                }
            }
            message+="\n";
        }
        return message;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
