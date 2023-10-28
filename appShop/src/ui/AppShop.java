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

        while (!salir) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar producto");
            System.out.println("2. Mostrar el catalogo de la tienda");
            System.out.println("3. numero de blusas por talla");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

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
                    System.out.println("Saliendo del programa.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        }
    }

    private void addProductToCatalog() {

    System.out.println("Seleccione el tipo de producto a agregar:");
    System.out.println("1. Jeans");
    System.out.println("2. Blouse");
    System.out.println("3. Tie");
    System.out.print("Ingrese la opción: ");
    int productType = scanner.nextInt();
    scanner.nextLine(); // Limpia el salto de línea pendiente
    
    if (productType == 1) {
        // Agregar Jeans
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el género (true para hombre, false para mujer): ");
        boolean gender = scanner.nextBoolean();
        System.out.print("Ingrese la longitud: ");
        int length = scanner.nextInt();
        System.out.print("Ingrese el precio: ");
        int price = scanner.nextInt();
        
        // Llama al método correspondiente en el controlador
        //String message = shop.addProductToCatalog(id, gender, length, price);
        //System.out.println(message);
    } else if (productType == 2) {
        // Agregar Blouse
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el tamaño (S, M, L, XL, etc.): ");
        String size = scanner.nextLine();
        System.out.print("Ingrese la cantidad de materiales: ");
        int numMaterials = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea pendiente
        String[] materials = new String[numMaterials];
        for (int i = 0; i < numMaterials; i++) {
            System.out.print("Ingrese el material #" + (i + 1) + ": ");
            materials[i] = scanner.nextLine();
        }
        System.out.print("Ingrese el color: ");
        String color = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        int price = scanner.nextInt();

        // Llama al método correspondiente en el controlador
        String message = shop.addProductToCatalog(id, size, materials, color, price);
        System.out.println(message);
        
    } else if (productType == 3) {
        // Agregar Tie
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el material del lazo: ");
        String material = scanner.nextLine();
        System.out.print("Ingrese el ancho del lazo: ");
        int width = scanner.nextInt();
        System.out.print("Ingrese el precio: ");
        int price = scanner.nextInt();

        // Llama al método correspondiente en el controlador
        String message = shop.addProductToCatalog(id, material, width, price);
        System.out.println(message);
    } else {
        System.out.println("Opción no válida.");
    }
  
    }

    private void showCatalogP() {
        System.out.println("Catalogo de la tienda:");
        System.out.println(shop.showCatalog());       
    }

    private void numSizeBlouse() {
        System.out.println("Ingrese la talla de la blusa: ");
        String size = scanner.nextLine();
        String message = shop.searchNumSizeProduct(size);
        System.out.println(message);
    }
}
