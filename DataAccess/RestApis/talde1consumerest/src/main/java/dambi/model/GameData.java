package dambi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GameData {
    private int partidaId;
    private String izena;
    private int idEnpresa;
    private LocalDate jaiotzeData;
    private int puntuazioa;
    private String lanpostua;
    private int jokoa;
    private LocalDateTime partidaData;
}
