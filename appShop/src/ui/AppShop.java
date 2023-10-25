import model.Shop;

import java.util.Scanner;

public class AppShop {
    public Scanner scanner = new Scanner(System.in);
    public static Shop shop = new Shop("Tienda de ropa");    
    public static void main(String[] args) {

        

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
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();
        double price = calculateProductPrice(productId);
        if (price >= 0) {
            System.out.println("Precio del producto: $" + price);
        } else {
            System.out.println("El producto no se encuentra en el catalogo.");
        }
    }

    private static void addProductToCatalog() {
        System.out.print("Ingrese el ID del producto: ");
        int productId = scanner.nextInt();
        System.out.print("Material (silk o wool) de la corbata / Material (polyester, silk, cotton) de la blusa: ");
        String material = scanner.next();
        int width = 0; // Ancho de la corbata
        String[] materials = null; // Materiales de la blusa
        if (material.equals("silk") || material.equals("wool")) {
            System.out.print("Ancho (en centimetros) de la corbata: ");
            width = scanner.nextInt();
        } else if (material.equals("polyester") || material.equals("silk") || material.equals("cotton")) {
            System.out.print("Materiales (separados por comas) de la blusa: ");
            String materialInput = scanner.next();
            materials = materialInput.split(",");
        }
        String result = addProductToCatalog(productId, material, width, materials);
        System.out.println(result);
    }

    private static void addProductToShelf() {
        System.out.print("Ingrese el ID del producto a ubicar en la estanteria: ");
        int productId = scanner.nextInt();
        String result = addProductToShelf(productId);
        System.out.println(result);
    }
}
