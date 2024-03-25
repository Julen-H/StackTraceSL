package dambi;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import dambi.mongodb.MongoAccess;
import dambi.postgresql.RestAccess;

public class ConsumeRest {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {

        URL talde1 = new URI("http://192.168.65.111:8081/team1postgre/allgamesdata").toURL();
        URL talde2 = new URI("http://192.168.65.122:8081/api/partidak").toURL();
        URL talde3 = new URI("http://192.168.65.170:8080/api/partidak").toURL();
        URL talde4 = new URI("http://192.168.65.140:8080/api/v1/partidak").toURL();
        ArrayList<URL> urls = new ArrayList<>();
        urls.add(talde1);
        urls.add(talde2);
        urls.add(talde3);
        urls.add(talde4);

        MongoAccess ma = new MongoAccess();
        RestAccess ra = new RestAccess();

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("===============================================");
        System.out.println("WELCOME TO THE REST CONSUME APP          TALDE1");
        System.out.println("===============================================");
        System.out.println();
        System.out.println("What do you want to execute?");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Read from first group and insert to mongo");
        System.out.println("2) Read from second group and insert to mongo");
        System.out.println("3) Read from third group and insert to mongo");
        System.out.println("4) Read from fourth group and insert to mongo");
        System.out.println("5) Read from all groups and insert to mongo");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter selection please: ");
        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                try {
                    ApiHandler.extractObjectFromJson(ma, ra, talde1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    ApiHandler.extractObjectFromJson(ma, ra, talde2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    ApiHandler.extractObjectFromJson(ma, ra, talde3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 4:
                try {
                    ApiHandler.extractObjectFromJson(ma, ra, talde4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 5:
            try {
                for(int i = 0; i < urls.size(); i++){
                    ApiHandler reader = new ApiHandler(ma, ra, urls.get(i));
                    reader.run();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            default:
            System.out.println("No valid option selected. Execution stopped.");
                break;
        }
    }
}