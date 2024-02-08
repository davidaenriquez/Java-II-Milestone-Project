package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The NetworkClient class represents a client that can send commands and data to a server.
 */
public class NetworkClient {
    private String serverAddress;
    private int serverPort;

    /**
     * Constructs a NetworkClient with the specified server address and port.
     *
     * @param serverAddress The address of the server.
     * @param serverPort    The port number of the server.
     */
    public NetworkClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    /**
     * Sends a retrieve command to the server.
     *
     * @return The response from the server.
     */
    public String sendRetrieveCommand() {
        return sendCommand("R", new ArrayList<>());
    }

    /**
     * Sends a command and pay load to the server.
     *
     * @param command The command to be sent.
     * @param payload The pay load to be sent.
     * @param <T>     The type of the pay load.
     * @return The response from the server.
     */
    public <T> String sendCommand(String command, List<T> payload) {
        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            // Send command to the server
            writer.write(command);
            writer.newLine();

            // Send the pay load to the server
            for (T item : payload) {
                if (item instanceof SalableProduct) {
                    SalableProduct<?> product = (SalableProduct<?>) item;
                    writer.write(product.getName() + "," + product.getDescription() + "," +
                            product.getPrice() + "," + product.getQuantity());
                    writer.newLine();
                }
                // Add more conditions for other pay load types if needed
            }

            // Flush the writer to ensure data is sent
            writer.flush();

            // server responds with a simple message
            return "Command sent successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error sending command";
        }
    }
}