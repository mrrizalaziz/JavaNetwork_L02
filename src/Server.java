import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket and specify a port number
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for a client...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams for the client connection
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from the client
            String clientData = in.readLine();
            System.out.println("Received from client: " + clientData);

            // Send a response back to the client
            out.println("Message received!");

            // Close the streams and socket
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
