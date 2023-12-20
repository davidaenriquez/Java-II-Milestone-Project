/**
 * David Enriquez
 * CST-239
 * Assignment: CST-239 MilestoneProject
 * December 20, 2023
 * Citations(s):
 * Grand Canyon University CST-239 Milestone Guide
 */
package app;
import java.util.List;
import java.util.Scanner;

/**
 * The StoreFrontApp class represents a console-based store front application
 * providing functionalities to view products, purchase items, and cancel purchases.
 */
public class StoreFrontApp {

	/**
     * The main method serves as the entry point of the application.
     * It displays a menu allowing users to interact with the store's functionalities.
     * @param
     */
    public static void main(String[] args) {
    	// Here we create an instance of the InventoryManager
    	// class named inventoryManager using the default constructor.
        InventoryManager inventoryManager = new InventoryManager();
        
        // Here we invokes the initializeStore() method of the
        // inventoryManager object to set up the initial store state.
        inventoryManager.initializeStore();
        
        // Here we create an instance of the ShoppingCart class
        // named cart using its default constructor to handle
        // items a user purchases.
        ShoppingCart cart = new ShoppingCart();
        
        // We initialize a Scanner object named userInput to
        // handle user input via the console.
        Scanner userInput = new Scanner(System.in);
        
        // Here we declare a boolean variable exit and
        // initializes it to false to control the loop
        // for the menu options.
        boolean exit = false;
        
        // We initiate a loop that continues to display
        // the store menu options as long as exit is false.
        while (!exit) {        	
        	// Here we print the welcome message and the
        	// menu options for the user to choose from.
            System.out.println("Welcome to the Store!");
            System.out.println("Select an option:");
            System.out.println("1. View Products");
            System.out.println("2. Purchase a Product");
            System.out.println("3. Cancel a Purchase");
            System.out.println("4. Exit");
            
            // Here we read the user's integer input
            // from the console to determine their choice.
            int choice = userInput.nextInt();
            
            // Here we execute different blocks of code based
            // on the user's selected option using a switch statement.
            // Each case inside the switch statement corresponds to
            // one of the menu options, invoking different methods
            // based on the user's selection.
            switch (choice) {
                case 1:
                	// Invokes the displayAvailableProducts() method from the InventoryManager.
                    displayAvailableProducts(inventoryManager);
                    break;
                case 2:
                	// Invokes the purchaseProduct() method with the inventoryManager, cart, and userInput.
                    purchaseProduct(inventoryManager, cart, userInput);
                    break;
                case 3:
                	// Invokes the cancelPurchase() method with the inventoryManager, cart, and userInput.
                    cancelPurchase(inventoryManager, cart, userInput);
                    break;
                case 4:
                	// Prints an exit message and sets exit = true, which exits the loop.
                    System.out.println("Exiting Store. Goodbye!");
                    exit = true;
                    break;
                default:
                	// This default case ensures that if the user enters an
                	// unexpected value, they receive this message and are
                	// prompted to make a valid choice.
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        userInput.close();
    }
    
    /**
     * This method declares a public, static method named
     * displayAvailableProducts that takes an InventoryManager
     * object as an argument. It will display product information.
     * @param inventoryManager The InventoryManager to retrieve product information.
     */
    public static void displayAvailableProducts(InventoryManager inventoryManager) {
    	// We retrieve a list of SalableProduct objects
    	// by calling the getInventory() method of the
    	// provided InventoryManager.
        List<SalableProduct> products = inventoryManager.getInventory();

        System.out.println("Available Products:");
        
        // Here we use a for-each loop to iterate through
        // the products list and print details of each product:
        for (SalableProduct product : products) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity Available: " + product.getQuantity());
            System.out.println("-----------------------------------");
        }
        
        // We output a message prompting the user to return to the main menu.
        System.out.println("Press any key to return to the main menu.");
        
        // Here we waits for any user input (a key press) before returning
        // to simulate going back to the main menu after viewing products.
        new Scanner(System.in).nextLine();
    }
    
    /**
     * This method declares a public static method named purchaseProduct
     * that takes in an InventoryManager, a ShoppingCart, and a Scanner as parameters.
     * @param inventoryManager Represents the manager responsible for managing the inventory of products.
     * @param cart Represents the shopping cart where purchased items are stored.
     * @param userInput Represents the Scanner object used to receive user input.
     */
    public static void purchaseProduct(InventoryManager inventoryManager, ShoppingCart cart, Scanner userInput) {
    	
    	// We retrieve a list of available SalableProduct objects
    	// by calling the getInventory() method of the provided InventoryManager.
        List<SalableProduct> products = inventoryManager.getInventory();
        
        // We print out the list of available products with
        // their corresponding numbers for selection using a for loop.
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }
        
        // We prompts the user to input the number of the desired product for purchase.
        System.out.println("Enter the number of the product to purchase:");
        int productChoice = userInput.nextInt();
        
        // Checks if the user's choice is valid. If valid, we retrieve
        // the selected product from the list, add it to both the
        // inventory and the shopping cart, and provides feedback
        // to the user on the successful purchase. If invalid, we display
        // a message indicating an invalid product choice.
        if (productChoice >= 1 && productChoice <= products.size()) {
            SalableProduct selectedProduct = products.get(productChoice - 1);
            inventoryManager.addToInventory(selectedProduct);
            cart.addProduct(selectedProduct);
            System.out.println("Purchase completed: " + selectedProduct.getName() + " purchased.");
        } else {
            System.out.println("Invalid product choice.");
        }
        
        // Here we display a message prompting the user to return to
        // the main menu and waits for any key press to simulate
        // going back to the main menu after the purchase process.
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }

    /**
     * This method declares a public static method named cancelPurchase
     * that takes in an InventoryManager, a ShoppingCart, and a Scanner as parameters.
     * @param inventoryManager The InventoryManager to manage product inventory.
     * @param cart The ShoppingCart to manage purchased items.
     * @param userInput The Scanner for user input.
     */
    public static void cancelPurchase(InventoryManager inventoryManager, ShoppingCart cart, Scanner userInput) {
    	
    	// We display a message to show the user their current
    	// cart contents using the viewCart() method of the ShoppingCart class.
        System.out.println("Your current cart contains:");
        cart.viewCart();
        
        // We prompt the user to enter the number of
        // the product they want to cancel from their cart.
        // Checks if the user's cancellation choice is valid. If valid,
        // we retrieve the selected product to cancel, remove it from
        // the cart, add it back to the inventory, and provide the user
        // feedback on the canceled purchase. If invalid, we display a
        // message indicating an invalid product choice.
        System.out.println("Enter the number of the product to cancel:");
        int cancelChoice = userInput.nextInt();

        if (cancelChoice >= 1 && cancelChoice <= cart.getCartSize()) {
            SalableProduct cancelledProduct = cart.getProduct(cancelChoice - 1);
            cart.removeProduct(cancelledProduct);
            inventoryManager.addToInventory(cancelledProduct);
            System.out.println("Purchase of " + cancelledProduct.getName() + " canceled.");
        } else {
            System.out.println("Invalid product choice.");
        }
        
        // Here we display a message prompting the user to return to
        // the main menu and waits for any key press to simulate
        // going back to the main menu after the purchase process.
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }
}