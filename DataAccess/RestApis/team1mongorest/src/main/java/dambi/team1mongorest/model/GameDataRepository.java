package dambi.team1mongorest.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepository {
    
    List<GameData> findAll();
    GameData findById(String match_id);
    GameData save(GameData gameData);
    long delete(String match_id);
}
