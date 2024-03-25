package dambi.team1mongorest.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "gamedata")
public class GameData {
    @Id
    private ObjectId _id;

    private int partidaId;
    private String izena;
    private int idEnpresa;
    private LocalDate jaiotzeData;
    private int puntuazioa;
    private String lanpostua;
    private int jokoa;
    private LocalDateTime partidaData;

    public GameData() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getIdEnpresa() {
        return idEnpresa;
    }

    public void setIdEnpresa(int idEnpresa) {
        this.idEnpresa = idEnpresa;
    }


    public LocalDate getJaiotzeData() {
        return jaiotzeData;
    }

    public void setJaiotzeData(LocalDate jaiotzeData) {
        this.jaiotzeData = jaiotzeData;
    }

    public void setPartidaData(LocalDateTime partidaData) {
        this.partidaData = partidaData;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public String getLanpostua() {
        return lanpostua;
    }

    public void setLanpostua(String lanpostua) {
        this.lanpostua = lanpostua;
    }

    public int getJokoa() {
        return jokoa;
    }

    public void setJokoa(int jokoa) {
        this.jokoa = jokoa;
    }

    public LocalDateTime getPartidaData() {
        return partidaData;
    }

    public int getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }
}
