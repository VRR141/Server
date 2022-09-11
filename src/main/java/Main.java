import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {


    public static void main(String[] args) {
        System.out.println("SERVER STARTED");
        int port = 8089;


        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort());
                    String name2 = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name2, clientSocket.getPort()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
