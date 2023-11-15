package views;

import controllers.CustomerDAO;
import models.Address;
import models.Customer;

import java.util.*;

public class CustomerDisplay {
    public CustomerDisplay(){
        Scanner scanner = new Scanner(System.in);
        String selection;
        do {
            System.out.println("--------------------");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] List all customers");
            System.out.println("[2] Search for a customer by ID");
            System.out.println("[3] Add a new customer");
            System.out.println("[4] Update a customer by ID");
            System.out.println("[5] Delete a customer by ID");
            System.out.println("[0] Go Back");
            System.out.println("[6] Exit");
            System.out.println();

            selection = scanner.nextLine();
            switch (selection) {
                case "1" -> {
                    ArrayList<Customer> customers = CustomerDAO.findAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    System.out.println();
                }
                case "2" -> {
                    System.out.println("\nSearch for a customer by ID");
                    int id = new Scanner(System.in).nextInt();
                    Customer customer = CustomerDAO.findCustomer(id);
                    System.out.println(customer);
                    System.out.println();
                }
                case "3" -> {
                    System.out.println(CustomerDAO.addCustomer(setUpCustomerDataFromConsole(0)));
                    System.out.println();
                }
                case "4" -> {
                    System.out.println("\nEnter customer ID to update");
                    int id = new Scanner(System.in).nextInt();
                    Customer customer = CustomerDAO.findCustomer(id);
                    if(customer == null){
                        System.out.println("\nCustomer with this ID does not exist");
                    }else{
                        System.out.println(CustomerDAO.updateCustomer(setUpCustomerDataFromConsole(id)));
                    }
                    System.out.println();
                }
                case "5" -> {
                    System.out.println("\nEnter the customer ID to delete");
                    int id = new Scanner(System.in).nextInt();
                    Customer customer = CustomerDAO.findCustomer(id);
                    if(customer == null){
                        System.out.println("\nCustomer with this ID does not exist");
                    }else {
                        System.out.println(CustomerDAO.deleteCustomer(id));
                        System.out.println();
                    }
                }
                case "0" -> {
                    return;
                }
            }
        }while (!selection.equals("6"));
    }
    private Customer setUpCustomerDataFromConsole(int id){
        System.out.println("\nEnter customer name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer telephone");
        String phone = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer address one (required)");
        String add1 = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer address two (optional)");
        String add2 = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer address three (optional)");
        String add3 = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer country");
        String country = new Scanner(System.in).nextLine();
        System.out.println("\nEnter customer post code");
        String postCode = new Scanner(System.in).nextLine();
        if(id <= 0){
            return new Customer(name,new Address(add1,add2,add3,country,postCode),phone);
        }
        return new Customer(id,name,new Address(add1,add2,add3,country,postCode),phone);
    }
}
