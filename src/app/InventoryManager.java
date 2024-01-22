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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The InventoryManager class represents a object
 * responsible for managing the inventory of salable
 * products in the store. It provides methods to
 * initialize the store with products and access
 * the current inventory.
 */
public class InventoryManager {
    private List<SalableProduct> inventory;

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
            List<SalableProduct> items = objectMapper.readValue(new File(filename), new TypeReference<List<SalableProduct>>() {});
            this.inventory = items;
        } catch (IOException e) {
            // Handle general file I/O errors
            System.err.println("Error reading inventory from JSON file: " + e.getMessage());
        }
    }
    
    /**
     * Initializes the store by loading inventory data from a JSON file.
     * The default filename used is "inventory.json".
     */
    public void initializeStore() {
        // Use the JSON file
        loadFromJsonFile("inventory.json");
    }

    /**
     * This method retrieves the current inventory of salable products.
     * @return A list of SalableProduct objects representing the current inventory.
     */
    public List<SalableProduct> getInventory() {
        return inventory;
    }

    /**
     * This method adds a SalableProduct to the inventory.     *
     * @param product The SalableProduct to be added to the inventory.
     */
    public void addToInventory(SalableProduct product) {
        inventory.add(product);
    }
}
