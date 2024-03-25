package dambi.postgresql;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;



public class RestAccess {
    
    /* This method makes a connection to Postgre and extract the data in an JsonArray
     * then return the array and closes the connection. For making the connection it
     * takes as a parameter the URL connection
     */
    public JsonArray readFromPostgre(URL url) throws IOException {
        try {

            /* Open connection to the specified URL */
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            /* Set the request method, GET in this case for reading */
            conn.setRequestMethod("GET");

            /* We create a JSON reader and we use it to read an array */
            JsonReader jsonReader = Json.createReader(conn.getInputStream());
            JsonArray jsonArray = jsonReader.readArray();
            /* We close the reader and connection */
            jsonReader.close();
            conn.disconnect();

            return jsonArray;
        } catch (Exception e) {
            /* Exception handling */
            e.printStackTrace();
            System.out.println("An error ocurred reading from postgre, check the connection and try again...");
            return null;
        }
    }
}
