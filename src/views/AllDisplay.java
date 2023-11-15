package views;
import controllers.CustomerDAO;
import controllers.FoodProductDAO;
import models.FoodProduct;

import java.util.*;

public class AllDisplay {
    public AllDisplay(){
        Scanner scanner = new Scanner(System.in);
        String selection;
        do {
            System.out.println("--------------------");
            System.out.println("The Food Store");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] Access Products");
            System.out.println("[2] Access Customers");
            System.out.println("[3] Access Orders");
            System.out.println("[4] Exit");
            System.out.println();

            selection = scanner.nextLine();
            switch (selection) {
                case "1" -> {
                    new ProductDisplay();
                    System.out.println();
                }
                case "2" -> {
                    new CustomerDisplay();
                    System.out.println();
                }
                case "3" -> {

                    System.out.println("Order access coming soon");
                }
            }
        }while (!selection.equals("4"));
    }
}
