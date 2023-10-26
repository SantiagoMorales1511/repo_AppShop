import model.Shop;

import java.util.Scanner;

public class AppShop {
    
    public static Shop shop = new Shop("Tienda de ropa");    
    public static void main(String[] args) {
    public Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Calcular el precio del producto");
            System.out.println("2. Mostrar el catalogo de la tienda");
            System.out.println("3. Agregar producto al catalogo");
            System.out.println("4. Agregar producto a la estanteria");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    calculateProductPrice();
                    break;
                case 2:

                    break;
                case 3:
                    addProductToCatalog();
                    break;
                case 4:
                    addProductToShelf();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        }
    }

   private static void calculateProductPrice() {
       
    }

    private static void addProductToCatalog() {
        
    }

    private static void addProductToShelf() {
       
    }
}
