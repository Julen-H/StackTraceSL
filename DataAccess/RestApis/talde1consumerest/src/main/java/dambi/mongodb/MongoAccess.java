package dambi.mongodb;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import dambi.model.GameData;

public class MongoAccess {
    /* Connection URL for the mongo database, max pool size is the maximum number of connections in each pool
     * TODO: Adjust the IP and the max pool size if it is neccesary
     */
    private String strUri = "mongodb://192.168.65.112:27017"; 
    /* Mongodb database name */
    private String strDb = "talde1";
    /* Name of the colection inside the database */
    private String strCol = "gamedata";
    
    public void insertDataToMongo(GameData gd) {

        /* Provider and registry (conversion of data) */
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    
        /* Make a connection using the mongo client and passing the URL connection, we get the database and collection 
         * and we insert the data one by one. In this case a GameData object is passed
        */
        try (MongoClient mongoClient = MongoClients.create(strUri)) {
            MongoDatabase database = mongoClient.getDatabase(strDb).withCodecRegistry(pojoCodecRegistry);
            MongoCollection<GameData> dataCollection = database.getCollection(strCol, GameData.class);

            InsertOneResult insert = dataCollection.insertOne(gd);
            System.out.println("Inserted document ID: " + insert.getInsertedId());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error ocurred inserting the data, please try again...");
        }
    }
}
