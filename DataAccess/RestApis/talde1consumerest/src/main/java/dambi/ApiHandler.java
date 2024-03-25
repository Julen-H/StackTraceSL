package dambi;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import dambi.model.GameData;
import dambi.mongodb.MongoAccess;
import dambi.postgresql.RestAccess;

public class ApiHandler extends Thread {
    MongoAccess ma;
    RestAccess ra;
    URL taldea;

    public ApiHandler(MongoAccess ma, RestAccess ra, URL taldea){
        this.ma = ma;
        this.ra = ra;
        this.taldea = taldea;
    }

    @Override
    public void run() {
        try {
            synchronized(ma){
                extractObjectFromJson(ma, ra, taldea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void extractObjectFromJson(MongoAccess ma, RestAccess ra, URL urlTeam)
            throws IOException, ParseException {
        JsonArray jsonArray = ra.readFromPostgre(urlTeam);

        for (JsonValue jValue : jsonArray) {
            GameData gd = new GameData();
            JsonObject jObject = jValue.asJsonObject();

            gd.setPartidaId(jObject.getInt("id"));
            gd.setIzena(jObject.getString("izena"));
            gd.setIdEnpresa(jObject.getInt("idEnpresa"));

            String jaiotzeDataStr = jObject.getString("jaiotzeData");
            LocalDate jaiotzeData = LocalDate.parse(jaiotzeDataStr);
            gd.setJaiotzeData(jaiotzeData);

            gd.setPuntuazioa(jObject.getInt("puntuazioa"));
            gd.setLanpostua(jObject.getString("lanpostua"));
            gd.setJokoa(jObject.getInt("jokoa"));

            String partidaDataStr = jObject.getString("partidaData");
            LocalDateTime partidaData = LocalDateTime.parse(partidaDataStr);
            gd.setPartidaData(partidaData);

            ma.insertDataToMongo(gd);
        }
    }
}