package model;

public class Shop {

    private String name;
    private Product[] catalog;
    public final int MAX_PRODUCTS = 150;

    public Shop(String name) {
        catalog = new Product[MAX_PRODUCTS];
        this.name = name; 
    }

    public double averagePrice(int product) {
        double averagePrice = 0.0;
        double sum = 0.0;
        double count = 0.0;
        for(int i = 0; i < MAX_PRODUCTS; i++){
            if(catalog[i] != null){
                sum += catalog[i].getPrice();
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
        for(int i = 0; i < catalog.length && !find; i++){
            if(catalog[i] != null){
                if(catalog[i].getId().equals(product)){
                    objEncontrado = catalog[i];
                    find = true;
                }
            }
        }
        return objEncontrado;
    }

    public int searchPosition(){
        int position = -1;
        boolean find = false;
        for(int i = 0; i < catalog.length && !find; i++){
            if(catalog[i] == null){
                position = i;
                find = true;
            }
        }
        return position;
    }

    public String addProductToCatalog(String id, int price, boolean gender, int lenght) { //Jeans
        
        String message = "Prodducto exitosamente agregado al catalogo";
            Product objP = searchProduct(id);
                if(objP != null){
                    message = "El producto ya existe";
                    }else{
                        int poss = searchPosition();
                        if(poss == -1){
                            message = "No hay espacio en el catalogo";
                        }else{

                            catalog[poss] = new Jeans(id, gender, lenght, price);
                        }
                    }
                
        return message;
    }

    public String addProductToCatalog(String id, char size, String[] materials, String color) { //blouse

        Product objP = searchProduct(id);
        if(objP != null){
            message = "El producto ya existe";
            }else{
            int poss = searchPosition();
            if(poss == -1){
                message = "No hay espacio en el catalogo";
            }else{
                catalog[poss] = new Blouse(id, price, size, materials, color);
            }
        }         
        return message;
    }

    public String addProductToCatalog(String id, String material, int width, int price ) { //Tie

        Product objP = searchProduct(id);
        if(objP != null){
            message = "El producto ya existe";
            }else{
            int poss = searchPosition();
            if(poss == -1){
                message = "No hay espacio en el catalogo";
            }else{
                catalog[poss] = new Tie(id, material, width,  price);
            }
            
        }
        return message;
    }
 

    public String addProducToShelf(String id){
        String message = "";
        return message; 
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
