package dambi.team1postgrerest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tournament_tournament")
public class GameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partidaId;
    private String izena;
    private Integer idEnpresa;
    
    private LocalDate jaiotzeData;
    private Integer puntuazioa;
    private String lanpostua;
    private Integer jokoa;
    private LocalDateTime partidaData;

    private LocalDateTime create_date;
    private LocalDateTime write_date;
    private Integer create_uid;

    private Integer write_uid;

    public GameData() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPartidaId() {
        return partidaId;
    }
    public void setPartidaId(String partidaId) {
        this.partidaId = partidaId;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public Integer getIdEnpresa() {
        return idEnpresa;
    }
    public void setIdEnpresa(Integer idEnpresa) {
        this.idEnpresa = idEnpresa;
    }

    public Integer getPuntuazioa() {
        return puntuazioa;
    }
    public void setPuntuazioa(Integer puntuazioa) {
        this.puntuazioa = puntuazioa;
    }
    public String getLanpostua() {
        return lanpostua;
    }
    public void setLanpostua(String lanpostua) {
        this.lanpostua = lanpostua;
    }
    public Integer getJokoa() {
        return jokoa;
    }
    public void setJokoa(Integer jokoa) {
        this.jokoa = jokoa;
    }
    
    public LocalDateTime getCreate_date() {
        return create_date;
    }
    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
    public LocalDateTime getWrite_date() {
        return write_date;
    }
    public void setWrite_date(LocalDateTime write_date) {
        this.write_date = write_date;
    }
    public Integer getCreate_uid() {
        return create_uid;
    }
    public void setCreate_uid(Integer create_uid) {
        this.create_uid = create_uid;
    }
    public Integer getWrite_uid() {
        return write_uid;
    }
    public void setWrite_uid(Integer write_uid) {
        this.write_uid = write_uid;
    }

    public LocalDate getJaiotzeData() {
        return jaiotzeData;
    }

    public void setJaiotzeData(LocalDate jaiotzeData) {
        this.jaiotzeData = jaiotzeData;
    }

    public LocalDateTime getPartidaData() {
        return partidaData;
    }

    public void setPartidaData(LocalDateTime partidaData) {
        this.partidaData = partidaData;
    }

}
