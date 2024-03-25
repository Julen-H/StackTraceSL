package dambi.team1mongorest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.team1mongorest.model.GameData;
import dambi.team1mongorest.model.GameDataRepository;

@RestController
@RequestMapping(path = "/team1")
public class MainController {

    @Autowired
    private GameDataRepository gameDataRepository;

    @GetMapping(path = "/allgamesdata")
    public @ResponseBody Iterable<GameData> getGamesData() {
        return gameDataRepository.findAll();
    }

    @GetMapping(path = "/findgamedata")
    public @ResponseBody GameData findPrize(@RequestParam String id_partida) {
        return gameDataRepository.findById(id_partida);
    }

    @PostMapping(value = "/addgamedata")
    public @ResponseBody String addGameData(@RequestParam int match_id, @RequestParam String player_name,
            @RequestParam int company_id, @RequestBody LocalDate birth_date, @RequestParam int score,
            @RequestParam String work_position, @RequestParam int game_id, @RequestBody LocalDateTime match_date) {

        GameData gd = new GameData();
        gd.setPartidaData(match_date);
        gd.setIzena(player_name);
        gd.setIdEnpresa(company_id);
        gd.setJaiotzeData(birth_date);
        gd.setPuntuazioa(score);
        gd.setLanpostua(work_position);
        gd.setJokoa(game_id);
        gameDataRepository.save(gd);
        return "The game data was added";
    }

    @DeleteMapping(path = "/deletegamedata")
    public ResponseEntity<Void> deletePrize(@RequestParam String id_partida) {
        try {
            long zenbat = gameDataRepository.delete(id_partida);
            System.out.println("The game data was deleted, amount deleted: " + zenbat);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("An error ocurred deleting the game data, please try again...");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/updategamedata/{id_partida}")
    public ResponseEntity<GameData> updatePrize(@PathVariable String match_id, @RequestParam String player_name,
            @RequestParam int company_id, @RequestBody LocalDate birth_date, @RequestParam int score,
            @RequestParam String work_position, @RequestParam int game_id, @RequestBody LocalDateTime match_date) {
        try {
            GameData gd = gameDataRepository.findById(match_id);

            gd.setPartidaData(match_date);
            gd.setIzena(player_name);
            gd.setIdEnpresa(company_id);
            gd.setJaiotzeData(birth_date);
            gd.setPuntuazioa(score);
            gd.setLanpostua(work_position);
            gd.setJokoa(game_id);
            gameDataRepository.save(gd);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
