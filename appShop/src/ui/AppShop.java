package ui;

import model.Shop;

import java.util.Scanner;

public class AppShop {
    private Shop shop;
    
    public AppShop(){
		shop = new Shop("Tienda de ropa");
	}
    
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        AppShop obj=new AppShop();
        
        boolean salir = false;

        System.out.println("------------Bienvenido a tu control de tienda de ropa------------\n");
        while (!salir) {
            System.out.println("Menu:\n");
            System.out.println("1. Adicionar producto");
            System.out.println("2. Mostrar el catalogo de la tienda");
            System.out.println("3. Buscar cantidad de blusas por talla");
            System.out.println("4. Vender producto");
            System.out.println("5. Mostrar lista de productos vendidos");
            System.out.println("6. Probar y agregar productos con casos de prueba");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: \n-");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    obj.addProductToCatalog();
                    break;
                case 2:
                    obj.showCatalogP();
                    break;
                case 3:
                    obj.numSizeBlouse();
                    break;
                case 4:
                    obj.vender();
                    break;
                case 5:
                    obj.showSoldProductsList();
                    break;
                case 6:
                    obj.testCase();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        }
    }

    public void addProductToCatalog() {

        System.out.println("++++++++++++++++++++++++++++++++++++++\nSeleccione el tipo de producto a agregar: \n");
        System.out.println("1. Jeans");
        System.out.println("2. Blouse");
        System.out.println("3. Tie");
        System.out.print("Ingrese la opcion: \n");
        int productType = scanner.nextInt();
        scanner.nextLine();
        
        if (productType == 1) {
            // Agregar Jeans
            System.out.print("Ingrese el ID del producto: ");
            String id = scanner.nextLine();
            System.out.print("Ingrese el genero (true para hombre, false para mujer): ");
            boolean gender = scanner.nextBoolean();
            System.out.print("Ingrese la longitud: ");
            int length = scanner.nextInt();
            System.out.print("Ingrese el precio: ");
            int price = scanner.nextInt();
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            
            String message = shop.addProductToCatalog(id,price, gender, length);
            System.out.println(message);
            
        } else if (productType == 2) {
            // Agregar Blouse
            System.out.print("Ingrese el ID del producto: \n-");
            String id = scanner.nextLine();
            System.out.print("Ingrese el tamano (S, M, L, XL, etc.): \n-");
            String size = scanner.nextLine();
            System.out.print("Ingrese la cantidad de materiales: \n-");
            int numMaterials = scanner.nextInt();
            scanner.nextLine(); 
            String[] materials = new String[numMaterials];
            for (int i = 0; i < numMaterials; i++) {
                System.out.print("Ingrese el material #" + (i + 1) + ": \n-");
                materials[i] = scanner.nextLine();
            }
            System.out.print("Ingrese el color: \n-");
            String color = scanner.nextLine();
            System.out.print("Ingrese el precio: \n-");
            int price = scanner.nextInt();
            System.out.println("++++++++++++++++++++++++++++++++++++++");

            String message = shop.addProductToCatalog(id, size.toUpperCase(), materials, color, price);
            System.out.println(message);
            
        } else if (productType == 3) {
            // Agregar Tie
            System.out.print("Ingrese el ID del producto: \n-");
            String id = scanner.nextLine();
            System.out.print("Ingrese el material del lazo: \n-");
            String material = scanner.nextLine();
            System.out.print("Ingrese el ancho del lazo: \n-");
            int width = scanner.nextInt();
            System.out.print("Ingrese el precio: \n-");
            int price = scanner.nextInt();
            System.out.println("++++++++++++++++++++++++++++++++++++++");

            String message = shop.addProductToCatalog(id, material, width, price);
            System.out.println(message);
            
        } else {
            System.out.println("Opcion no valida.");
        }
  
    }

    public void showCatalogP() {
        System.out.println("++++++++++++++++++++++++++++++++++++++\nCatalogo de la tienda:");
        System.out.println(shop.showCatalog());
        //mostrar la matris de Product poruqe es una estanteria
        System.out.println("Estanteria de la tienda:");
        System.out.println(shop.showShelf() + "\n++++++++++++++++++++++++++++++++++++++");
        

        if(shop.showCatalog().equals("")){
            System.out.println("No hay productos en el catalogo\n++++++++++++++++++++++++++++++++++++++");
        }
        
    }

    public void numSizeBlouse() {
        System.out.println("Ingrese la talla de la blusa: \n-");
        String size = scanner.nextLine();
        String message = shop.searchNumSizeProduct(size);
        System.out.println(message);
    }

    public void testCase() {
        // Agregar algunos productos de prueba al catalogo
        shop.addProductToCatalog("001", 50, true, 32); // Jeans
        shop.addProductToCatalog("002", 45, false, 36); // Jeans

        shop.addProductToCatalog("003", "M", new String[]{"Algodon", "Poliester"}, "Azul", 25); // Blusa
        shop.addProductToCatalog("004", "L", new String[]{"Seda"}, "Rojo", 30); // Blusa
        shop.addProductToCatalog("005", "M", new String[]{"Algodon"}, "Verde", 20); // Blusa


        shop.addProductToCatalog("006", "Seda", 5, 15); // Tie
        shop.addProductToCatalog("007", "Algodon", 3, 10); // Tie
    
        // Mostrar el catalogo despues de agregar productos de prueba
        System.out.println("Catalogo despues de agregar productos de prueba:");
        showCatalogP();
    
        // Buscar la cantidad de blusas de talla "M"
        String size = "M";
        String numSizeMessage = shop.searchNumSizeProduct(size);
        System.out.println(numSizeMessage);
    }

    public void vender() {
        System.out.print("++++++++++++++++++++++++++++++++++++++\nIngrese el ID del producto a vender: \n-");
        String productIdToSell = scanner.nextLine();
        String sellMessage = shop.sellProduct(productIdToSell);
        System.out.println(sellMessage);
    }

    public void showSoldProductsList() {
        System.out.println(shop.showSoldProducts());
    }
          
}
