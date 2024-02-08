package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The NetworkServer class represents a server that communicates with the Administration Application
 * to manage and update the inventory of salable products in the store.
 */
public class NetworkServer {
    private int port;
    private InventoryManager<String> inventoryManager;

    /**
     * Constructs a NetworkServer with the specified port and inventory manager.
     *
     * @param port             The port on which the server listens for connections.
     * @param inventoryManager The inventory manager responsible for managing the store's inventory.
     */
    public NetworkServer(int port, InventoryManager<String> inventoryManager) {
        this.port = port;
        this.inventoryManager = inventoryManager;
    }

    /**
     * Starts the server, listens for incoming connections, and processes client commands.
     */
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                processCommand(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the command received from the client and performs corresponding actions.
     *
     * @param clientSocket The socket connected to the client.
     */
    private void processCommand(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String command = in.readLine();

            switch (command) {
                case "U":
                    // Receive updated inventory data from the client
                    List<SalableProduct<String>> updatedInventory = receiveInventoryData(in);
                    inventoryManager.updateInventoryWithList(updatedInventory);
                    saveInventoryToFile();  // Save updated inventory to a file
                    out.println("Inventory updated successfully.");
                    break;
                case "R":
                    // Return all salable products in text format
                    String inventoryText = readInventoryFromFile();
                    out.println(inventoryText);
                    break;
                default:
                    out.println("Invalid command.");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receives updated inventory data from the client.
     *
     * @param in The BufferedReader for reading input from the client.
     * @return A list of SalableProduct instances representing the updated inventory.
     * @throws IOException If an I/O error occurs while reading from the client.
     */
    private List<SalableProduct<String>> receiveInventoryData(BufferedReader in) throws IOException {
        List<SalableProduct<String>> updatedInventory = new ArrayList<>();

        // Read inventory data from the client
        String line;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split(",");

            // Add the product to the updated inventory
            SalableProduct<String> product = new SalableProduct<>();
            updatedInventory.add(product);
        }

        return updatedInventory;
    }

    /**
     * Saves the current inventory to a text file.
     */
    private void saveInventoryToFile() {
        Path filePath = Paths.get("inventory.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (SalableProduct<String> product : inventoryManager.getInventory()) {
                writer.write(product.getName() + "," + product.getDescription() + ","
                        + product.getPrice() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the inventory from a text file and returns it as a formatted text.
     *
     * @return A formatted string representing the inventory.
     */
    private String readInventoryFromFile() {
        Path filePath = Paths.get("inventory.txt");
        StringBuilder inventoryText = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                inventoryText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventoryText.toString();
    }
}