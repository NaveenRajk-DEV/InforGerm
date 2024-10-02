import java.io.*;
import java.net.*;

public class ChatServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for client...");

        clientSocket = serverSocket.accept(); // Waits for a client to connect
        System.out.println("Client connected!");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput, clientMessage;

        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Client: " + clientMessage);

            // Server's response
            System.out.print("Server: ");
            userInput = stdIn.readLine();
            out.println(userInput);

            if ("bye".equalsIgnoreCase(userInput)) {
                System.out.println("Connection closed by server.");
                break;
            }
        }

        stop();
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}