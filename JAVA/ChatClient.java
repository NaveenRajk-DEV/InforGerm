import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput, serverMessage;

        while (true) {
            System.out.print("Client: ");
            userInput = stdIn.readLine();
            out.println(userInput);

            if ("bye".equalsIgnoreCase(userInput)) {
                System.out.println("Connection closed by client.");
                break;
            }

            serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
        }

        stop();
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        try {
            client.start("127.0.0.1", 8080); // Connect to the server at localhost and port 8080
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
