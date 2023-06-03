import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            // Create input and output streams for the server connection
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send messages to the server
            out.println("Hello, server!");

            // Loop to send multiple messages
            while (true) {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String message = userInput.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user enters "exit"
                }

                // Send the message to the server
                out.println(message);

                // Read the response from the server
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);
            }

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
