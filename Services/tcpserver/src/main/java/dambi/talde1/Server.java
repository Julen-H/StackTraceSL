package dambi.talde1;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URI;
import java.net.URL;

public class Server extends Thread {
    Socket client;
    String apiConn = "http://192.168.65.111:8081/team1postgre/addgamedata?";
    String params;
    byte[] paramBytes;

    public Server(Socket client) {
        this.client = client;
    }

    // EJEMPLO REQUEST URL
    // http://192.168.65.111:8081/team1postgre/addgamedata?partidaId=1&izena=Unai&idEnpresa=1&jaiotzeData=1998-01-17&puntuazioa=150&lanpostua=Dev&jokoa=1&partidaData=2024-05-01T09%3A02%3A48
    @Override
    public void run() {
        try {
            System.out.println("new connection from " + client.getInetAddress());

            InputStream inputStream = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            params = reader.readLine();
            
            String requestString = apiConn + params;

            URL requestURL = new URI(requestString).toURL();
            HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();

            conn.setRequestMethod("POST");
            int response = conn.getResponseCode();
            System.out.println(response);

            if (response == 200) {
                System.out.println("Data was added correctly.");
            } else {
                System.out.println("There was an eror. Try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}