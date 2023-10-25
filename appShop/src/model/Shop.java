package model;

public class Shop {

    private String name;
    private Product[] catalog;
    public final int MAX_PRODUCTS = 150;

    public Shop(String name) {
        catalog = new Product[MAX_PRODUCTS];
        this.name = name; 
    }
    
    public String addProductToCatalog(String id, String material, int width) { //tie
        
        return "El producto se agrego al catalogo";
    }

    public String addProductToCatalog(String id, boolean gender, int lenght) { //tie
        String message = "";
        
        Jeans obj = new Jeans(id, message, gender, lenght);

        return message;
    }

    public String addProductToShelf(int productId) {
        return "El producto se agrego a la estanteria";
    }

    public String displayCatalog(){
        return "El catalogo de la tienda es: ";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
