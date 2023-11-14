package model;
import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<Product> catalog;
    private ArrayList<Product> soldProducts;
    private Product [][] shelf;
    public final int MAX_FIL = 4;
    public final int MAX_COL = 3;


    public Shop(String name) {
        catalog = new ArrayList<Product>();
        soldProducts = new ArrayList<Product>();
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
            for(int j = 0; j < MAX_COL && ! found; j++){
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
        String message = "   1   \t   2   \t   3 \n";
        message += "_______ _______ _______ _\n";
        for(int i = 0; i < MAX_FIL; i++){
            message += "|";
            for(int j = 0; j < MAX_COL; j++){
                if(shelf[i][j]==null){
                    message+="[FREE]\t";
                }
                else if(shelf[i][j] instanceof Tie){
                    message+="[Tie ]\t";
                }
                else if(shelf[i][j] instanceof Blouse){
                    message+="[Blou]\t";
                }
                else if(shelf[i][j] instanceof Jeans){
                    message+="[Jean]\t";
                }
                message += "|";
            }
            message+="\n";
        }
        message += "°°°°°°°°°°°°°°°°°°°°°°°°°\n";
        return message;
    }

    public String sellProduct(String productId) {
        Product product = searchProduct(productId);

        if (product == null) {
            return "\"-----------------\nEl producto no existe en el catalogo.\n++++++++++++++++++++++++++++++++++++++";
        }

        if (product.isSold()) {
            return "-----------------\nEl producto ya ha sido vendido.\n++++++++++++++++++++++++++++++++++++++";
        }

        product.setSold(true);
        removeProductFromShelf(product);
        return "-----------------\nProducto vendido correctamente.\n++++++++++++++++++++++++++++++++++++++";
    }

    public void removeProductFromShelf(Product product) {
        for (int i = 0; i < MAX_FIL; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (shelf[i][j] != null && shelf[i][j].getId().equals(product.getId())) {
                    //Agrega "Mueve" el producto de la estanteria a la lista de productos vendidos
                    soldProducts.add(shelf[i][j]);
                    shelf[i][j] = null;
                    return; //El retur asegura que se termine el metodod luego de encontrar y eliminar el producto
                }
            }
        }
    }

    public String showSoldProducts() {
        int totalJeans = 0;
        int totalBlouses = 0;
        int totalTies = 0;
        int total = 0;
    
        String message = "Productos vendidos\n";
        for (Product soldProduct : soldProducts) {
            message += soldProduct.toString() + "\n";
    
            if (soldProduct instanceof Jeans) {
                totalJeans++;
            } else if (soldProduct instanceof Blouse) {
                totalBlouses++;
            } else if (soldProduct instanceof Tie) {
                totalTies++;
            }
    
            total += soldProduct.getPrice();
        }
    
        message += "Total Jeans: \t" + totalJeans + "\n";
        message += "Total Blouses: \t" + totalBlouses + "\n";
        message += "Total Ties: \t" + totalTies + "\n";
        message += "      Total: \t" + total + "\n";
    
        return message;
    }
    
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
