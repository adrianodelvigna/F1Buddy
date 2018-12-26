
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import com.squareup.moshi.Json;

@Entity(primaryKeys = {"season", "round"})
public class Race {

    @Json(name = "season")
    private String season;
    @Json(name = "round")
    private String round;
    @Json(name = "url")
    private String url;
    @Json(name = "raceName")
    private String raceName;

    @Json(name = "Circuit")
    @Embedded(prefix = "circuit_")
    private Circuit circuit;

    @Json(name = "date")
    private String date;
    @Json(name = "time")
    private String time;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
