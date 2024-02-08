package app;

import java.util.ArrayList;
import java.util.List;

/**
 * The AdministrationServiceMain class serves as the entry point for the Administration Service application.
 * It initializes the necessary components, starts the administration service, and demonstrates interactions
 * with the server using the NetworkClient.
 */
public class AdministrationServiceMain {

    /**
     * The main method that is executed when the application is run.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of InventoryManager<String>
        InventoryManager<String> inventoryManager = new InventoryManager<>();

        // Create an instance of AdministrationService
        AdministrationService administrationService = new AdministrationService(inventoryManager);

        // Start the administration service
        administrationService.startServer();

        // Create an instance of NetworkClient
        NetworkClient networkClient = new NetworkClient("localhost", 6666); // Replace with your server details

        // Example: Send "U" command to update inventory
        sendUpdateCommand(networkClient);

        // Example: Send "R" command to retrieve inventory
        String inventoryText = sendRetrieveCommand(networkClient);
        System.out.println("Inventory received from the server:\n" + inventoryText);
    }

    /**
     * Sends the "U" (update) command to the server with a list of updated inventory data.
     *
     * @param networkClient The NetworkClient used for communication with the server.
     */
    private static void sendUpdateCommand(NetworkClient networkClient) {
        // Create a list of SalableProduct instances to represent the updated inventory
        List<SalableProduct<String>> updatedInventory = new ArrayList<>();
        // Add SalableProduct instances to the list

        // Send the "U" command with the updated inventory data
        networkClient.sendCommand("U", updatedInventory);
        System.out.println("Update command sent.");
    }

    /**
     * Sends the "R" (retrieve) command to the server and returns the received inventory text.
     *
     * @param networkClient The NetworkClient used for communication with the server.
     * @return The formatted string representing the received inventory from the server.
     */
    private static String sendRetrieveCommand(NetworkClient networkClient) {
        // Send the "R" command to retrieve the current inventory
        return networkClient.sendRetrieveCommand();
    }
}