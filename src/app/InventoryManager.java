/**
 * David Enriquez
 * CST-239
 * Assignment: CST-239 MilestoneProject
 * December 20, 2023
 * Citations(s):
 * Grand Canyon University CST-239 Milestone Guide
 */
package app;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The InventoryManager class represents an object
 * responsible for managing the inventory of salable
 * products in the store. It provides methods to
 * initialize the store with products and access
 * the current inventory.
 *
 * @param <T> Type of the SalableProduct.
 */
public class InventoryManager<T extends Comparable<T>> {
    private List<SalableProduct<T>> inventory;

    /**
     * Constructs an InventoryManager, initializing an empty inventory list.
     */
    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Saves the current inventory to a JSON file.
     *
     * @param filename The name of the JSON file.
     */
    public void saveToJsonFile(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filename), inventory);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (log, throw, etc.)
        }
    }

    /**
     * Loads inventory from a JSON file.
     *
     * @param filename The name of the JSON file.
     */
    public void loadFromJsonFile(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<SalableProduct<T>> items = objectMapper.readValue(new File(filename), new TypeReference<List<SalableProduct<T>>>() {});
            this.inventory = items;
        } catch (IOException e) {
            // Handle general file I/O errors
            System.err.println("Error reading inventory from JSON file: " + e.getMessage());
        }
    }

//    /**
//     * Initializes the store by loading inventory data from a JSON file.
//     * The default filename used is "inventory.json".
//     */
//    public void initializeStore() {
//        // Use the JSON file
//        loadFromJsonFile("inventory.json");
//    }
    
    public void initializeStore() {
        // Clear the existing inventory
        inventory.clear();

        // Read inventory from text file
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    // Parse the values and create a SalableProduct
                    String name = parts[0];
                    String description = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);

                    SalableProduct salableProduct = new SalableProduct();
                    salableProduct.setName(name);
                    salableProduct.setDescription(description);
                    salableProduct.setPrice(price);
                    salableProduct.setQuantity(quantity);

                    // Add the product to the inventory
                    inventory.add(salableProduct);
                }
            }

            System.out.println("Inventory loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading inventory from text file: " + e.getMessage());
        }
    }

    /**
     * This method retrieves the current inventory of salable products.
     *
     * @return A list of SalableProduct objects representing the current inventory.
     */
    public List<SalableProduct<T>> getInventory() {
        return inventory;
    }

    /**
     * This method adds a SalableProduct to the inventory.     *
     *
     * @param product The SalableProduct to be added to the inventory.
     */
    public void addToInventory(SalableProduct<T> product) {
        inventory.add(product);
    }

    /**
     * Sorts the inventory by name in ascending order.
     */
    public void sortByName() {
        Collections.sort(inventory, Comparator.comparing((SalableProduct<T> product) -> product.getName()));
    }

    /**
     * Sorts the inventory by name in descending order.
     */
    public void sortByNameDescending() {
        Collections.sort(inventory, Comparator.comparing((SalableProduct<T> product) -> product.getName()).reversed());
    }

    /**
     * Sorts the inventory by price in ascending order.
     */
    public void sortByPrice() {
        Collections.sort(inventory, Comparator.comparing((SalableProduct<T> product) -> product.getPrice()));
    }

    /**
     * Sorts the inventory by price in descending order.
     */
    public void sortByPriceDescending() {
        Collections.sort(inventory, Comparator.comparing((SalableProduct<T> product) -> product.getPrice()).reversed());
    }
}