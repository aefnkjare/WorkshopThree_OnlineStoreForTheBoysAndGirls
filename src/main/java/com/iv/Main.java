package com.iv;
// Import Scanner class
// Import ArrayList class
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

// Import java.io.BufferedReader;
// Import java.io.FileReader;
// Import java.io.IOException;

public class Main {
    // Create static variable called inventory. It will be an ArrayList of Products
    static ArrayList<Product> inventory = new ArrayList<Product>();
    // Create static variable called cart. It will be an ArrayList of Products
    static ArrayList<Product> cart = new ArrayList<Product>();
    // Create static scanner instance
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadProductsFromFile();
        String input;
        do {
            System.out.println("Choose an option: ");
            System.out.println("\t 1: Show Products: ");
            System.out.println("\t 2: Show Cart: ");
            System.out.println("\t 3: EXIT: ");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    showProducts();
                    break;
                case "2":
                    showCart();
                    break;
                case "3":
                    System.out.println("EXITED");
                    break;
                default:
                    System.out.println("Invalid Input here as well Bozo, give me a right answer next time.");
            }

        } while (!input.equalsIgnoreCase("3"));

        System.out.println(inventory);
        // Run custom static method called loadProductsFromFile

        // Create main menu:
        // Initialize variable for user input
        // Show prompt for user showing the possible options and asking for an input
        // Create do-while loop that runs unless the user enters "3"
        // Create switch statement that handles cases related to each menu item
        // Case "1": Show Products
        // Runs custom static method called showProducts
        // Case "2": Show Cart
        // Runs custom static method called showCart
        // Case "3": Exit
        // Print message that says "Exiting"
        // Default:
        // Show message "Input command not found"

    }

    static void loadProductsFromFile() {
        try {
            FileReader inventoryReader = new FileReader("./src/main/java/com/iv/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(inventoryReader);

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                /// input split ||
                String[] splitInput = input.split(Pattern.quote("|"));

                String productIdInput = splitInput[0];
                String productNameInput = splitInput[1];
                float productPriceInput = Float.parseFloat(splitInput[2]);

                Product newProduct = new Product(productIdInput, productNameInput, productPriceInput);

                inventory.add(newProduct);

//                System.out.printf("Product Id: %s, Name: %s, Price: $%.2f\n",
//                        currentProduct.getId(),
//                        currentProduct.getName(),
//                        currentProduct.getPrice()
//                );
//                System.out.println(splitInput);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create static method called loadProductsFromFile that return nothing
        // Read data from file: From WorkingWithFileIO >> BufferedReaderExercise example
        // Create a try/catch statement to handle file import
        // Create an instance of FileReader with an approximate path of "./src/main/java/com/<YourInitial>/inventory.csv"
        // Create an instance of BufferedReader that takes in the FileInputStream instance above

        // Create a while loop that iterates through each line of the file
        // Parse/Split the line on "|" and store in variable: Hint .split("\\|");

        // Create variables that stores each property
        // int id
        // String name
        // float price

        // Create a variable that stores a Product instance using the data from the current line

        // Add the variable to the static inventory variable
        // Close the scanner instance
        // Handle catch/exception

        // Create static method called showProducts that return nothing

        // Create static method called showCart that return nothing
        // Create sub-menu
        // Initialize subInput variable for user input
        // Show prompt for user showing the possible options and asking for an input
        // Create do-while loop that runs unless the user enters "2"
        // Create switch statement that handles cases related to each menu item
        // Case "1": Checkout
        // Runs custom static method called checkout
        // Case "2": Go Back To Home Screen
        // Print message that says "Going back to home screen"
        // Default:
        // Show message "Input command not found"
    }

    public static void showProducts() {
        for (int i = 0; i < inventory.size();i++) {
            Product currentProduct = inventory.get(i);
            System.out.println(inventory.get(i));
        }
    }

    public static void showCart() {
        for (int i = 0; i < inventory.size();i++) {
            Product currentCart = inventory.get(i);
            System.out.println(inventory.get(i));
        }
    }
}