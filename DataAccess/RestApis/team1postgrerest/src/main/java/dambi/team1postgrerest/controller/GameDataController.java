package dambi.team1postgrerest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import dambi.team1postgrerest.model.GameDataRepository;
import dambi.team1postgrerest.model.GameData;

@Controller
@RequestMapping(path = "/team1postgre")
public class GameDataController {

    @Autowired
    private GameDataRepository gameDataRepository;

    @GetMapping(path = "/allgamesdata")
    public @ResponseBody Iterable<GameData> getgdsData() {
        Iterable<GameData> gameData = gameDataRepository.findAll();
        return gameData;
    }

    @GetMapping(path = "/gdData")
    public @ResponseBody Optional<GameData> getgdById(@RequestParam int id){
        return gameDataRepository.findById(id);
    }

    @PostMapping(value = "/addgamedata")
    public @ResponseBody String addgdData(@RequestParam String izena, @RequestParam int idEnpresa, 
    @RequestParam("jaiotzeData") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate jaiotzeData, 
    @RequestParam int puntuazioa, 
    @RequestParam String lanpostua, @RequestParam int jokoa, @RequestParam LocalDateTime partidaData) {

        try {
            GameData gd = new GameData();
            gd.setIzena(izena);
            gd.setIdEnpresa(idEnpresa);
            gd.setJaiotzeData(jaiotzeData);
            gd.setPuntuazioa(puntuazioa);
            gd.setLanpostua(lanpostua);
            gd.setJokoa(jokoa);
            gd.setPartidaId("t1000");
            gd.setPartidaData(partidaData);
            gd.setCreate_date(LocalDateTime.now());
            gd.setWrite_date(LocalDateTime.now());
            gd.setCreate_uid(2);
            gd.setWrite_uid(2);
            gameDataRepository.save(gd);
        } catch (MethodArgumentTypeMismatchException e) {
            GameData gd = new GameData();
            gd.setIzena(izena);
            gd.setIdEnpresa(idEnpresa);
            gd.setJaiotzeData(jaiotzeData);
            gd.setPuntuazioa(puntuazioa);
            gd.setLanpostua(lanpostua);
            gd.setPartidaId("t1000");
            gd.setJokoa(jokoa);
            gd.setPartidaData(LocalDateTime.now());
            gd.setCreate_date(LocalDateTime.now());
            gd.setWrite_date(LocalDateTime.now());
            gd.setCreate_uid(2);
            gd.setWrite_uid(2);
            gameDataRepository.save(gd);
        } finally{
            return "The game data was added correctly";
        }
        
    }
}