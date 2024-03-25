package dambi.talde1;

import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args )
    {
        final int port = 8082;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket client = server.accept();
                Server thread = new Server(client);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}