package dambi.team1mongorest.model;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.annotation.PostConstruct;

@Repository
public class MongoDBGameDataRepository implements GameDataRepository {
    
    @Autowired
    private MongoClient client;
    private MongoCollection<GameData> gameDataCollection;
    
    @PostConstruct
    void init() {
        gameDataCollection = client.getDatabase("talde1").getCollection("gamedata", GameData.class);
    }

    @Override
    public List<GameData> findAll() {
        List<GameData> data =  gameDataCollection.find().into(new ArrayList<>());
        return data;
    }

    @Override
    public GameData findById(String id_partida) {
        return gameDataCollection.find(eq("id_partida", id_partida)).first();
    }

    @Override
    public GameData save(GameData gameData) {
        gameDataCollection.insertOne(gameData);
        return gameData;
    }

    @Override 
    public long delete(String id_partida) {
        return gameDataCollection.deleteMany(eq("id_partida", id_partida)).getDeletedCount();
    }
}
