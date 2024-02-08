package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The AdministrationService class represents a server that manages inventory updates
 * and provides information about salable products to connected clients.
 */
public class AdministrationService {
    private InventoryManager<String> inventoryManager;

    /**
     * Constructs an AdministrationService with the provided inventory manager.
     *
     * @param inventoryManager The inventory manager to be used by the service.
     */
    public AdministrationService(InventoryManager<String> inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    /**
     * Starts the server and listens for incoming connections.
     */
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            System.out.println("Administration Service running. Waiting for connections...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Read the command sent by the client
                    String command = in.readLine();

                    // Process the command and send the response back to the client
                    String response = processCommand(command);
                    out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the command received from the client.
     *
     * @param command The command received from the client.
     * @return The response to be sent back to the client.
     */
    private String processCommand(String command) {
        switch (command) {
            case "U":
                // Receive updated inventory data from the Administration Application
                // Update the inventory with the received data
                List<SalableProduct<String>> updatedInventoryData = receiveInventoryData();
                inventoryManager.updateInventoryWithList(updatedInventoryData);
                return "Inventory updated successfully.";

            case "R":
                // Return all salable products in text format
                String inventoryText = convertInventoryToText();
                return inventoryText;

            default:
                return "Invalid command";
        }
    }

    /**
     * Simulates receiving updated inventory data. Replace this with actual implementation.
     *
     * @return A list of salable products with updated data.
     */
    private List<SalableProduct<String>> receiveInventoryData() {
        // Simulate receiving updated inventory data, replace this with actual implementation
        List<SalableProduct<String>> updatedInventory = new ArrayList<>();

        // Assuming the data format is comma-separated values for demonstration purposes
        String data = "NewProduct,NewDescription,10.0,100";
        String[] parts = data.split(",");
        if (parts.length == 4) {
            String name = parts[0];
            String description = parts[1];
            double price = Double.parseDouble(parts[2]);
            int quantity = Integer.parseInt(parts[3]);

            SalableProduct<String> salableProduct = new SalableProduct<>();
            salableProduct.setName(name);
            salableProduct.setDescription(description);
            salableProduct.setPrice(price);
            salableProduct.setQuantity(quantity);

            updatedInventory.add(salableProduct);
        }

        return updatedInventory;
    }

    /**
     * Converts the inventory to text format.
     *
     * @return A string representation of the inventory in text format.
     */
    private String convertInventoryToText() {
        // Convert inventory to text format, replace this with actual implementation
        StringBuilder inventoryText = new StringBuilder();

        for (SalableProduct<String> product : inventoryManager.getInventory()) {
            inventoryText.append(product.getName()).append(",")
                         .append(product.getDescription()).append(",")
                         .append(product.getPrice()).append(",")
                         .append(product.getQuantity()).append("\n");
        }

        return inventoryText.toString();
    }
}