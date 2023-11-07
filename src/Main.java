import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selection;
        do {
            System.out.println("--------------------");
            System.out.println("The Food Store");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] List all products");
            System.out.println("[2] Search for product by ID");
            System.out.println("[3] Add a new product");
            System.out.println("[4] Update a product by ID");
            System.out.println("[5] Delete a product by ID");
            System.out.println("[6] Exit");
            System.out.println();

            selection = scanner.nextLine();
            switch (selection) {
                case "1" -> {
                    ArrayList<FoodProduct> products = FoodProductDAO.findAllProducts();
                    for (FoodProduct product : products) {
                        System.out.println(product);
                    }
                    System.out.println();
                }
                case "2" -> {
                    System.out.println("\nSearch for a product by ID");
                    int id = new Scanner(System.in).nextInt();
                    FoodProduct product = FoodProductDAO.findProduct(id);
                    System.out.println(product);
                    System.out.println();
                }
                case "3" -> {
                    System.out.println("\nEnter product SKU");
                    String sku = new Scanner(System.in).nextLine();
                    System.out.println("\nEnter product description");
                    String desc = new Scanner(System.in).nextLine();
                    System.out.println("\nEnter product category");
                    String category = new Scanner(System.in).nextLine();
                    System.out.println("\nEnter product price");
                    int price = new Scanner(System.in).nextInt();
                    System.out.println(FoodProductDAO.addProduct(new FoodProduct(sku,desc,category,price)));
                    System.out.println();
                }
                case "4" -> {
                    System.out.println("\nEnter product ID to update");
                    int id = new Scanner(System.in).nextInt();
                    FoodProduct product = FoodProductDAO.findProduct(id);
                    if(product == null){
                        System.out.println("\nProduct with this ID does not exist");
                    }else{
                        System.out.println("\nEnter product SKU");
                        String sku = new Scanner(System.in).nextLine();
                        product.setSKU(sku);
                        System.out.println("\nEnter product description");
                        String desc = new Scanner(System.in).nextLine();
                        product.setDescription(desc);
                        System.out.println("\nEnter product category");
                        String category = new Scanner(System.in).nextLine();
                        product.setCategory(category);
                        System.out.println("\nEnter product price");
                        int price = new Scanner(System.in).nextInt();
                        product.setPrice(price);
                        System.out.println(FoodProductDAO.updateProduct(product));
                    }
                    System.out.println();
                }
                case "5" -> {
                    System.out.println("\nEnter the product ID to delete");
                    int id = new Scanner(System.in).nextInt();
                    FoodProduct product = FoodProductDAO.findProduct(id);
                    if(product == null){
                        System.out.println("\nProduct with this ID does not exist");
                    }else {
                        System.out.println(FoodProductDAO.deleteProduct(id));
                        System.out.println();
                    }
                }
            }
        }while (!selection.equals("6"));



    }
}