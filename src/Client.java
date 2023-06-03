import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a Socket and specify the server's IP address and port number
            Socket socket = new Socket("localhost", 1234);

            // Create input and output streams for the server connection
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send data to the server
            out.println("Hello, server!");

            // Receive the server's response
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
