
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import com.squareup.moshi.Json;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import udacity.androidnanodegree.adriano.capstone.utils.TimeLeft;

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

    private Long epochSeconds;

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

    public Long getEpochSeconds() {
        if (epochSeconds == null) {
            epochSeconds = Instant.parse(date + "T" + time)
                    .atZone(ZoneId.systemDefault())
                    .toEpochSecond();
        }
        return epochSeconds;
    }

    public void setEpochSeconds(Long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    private Duration getDurationUntilRace() {
        return Duration.between(
                ZonedDateTime.now(),
                ZonedDateTime.ofInstant(Instant.ofEpochSecond(getEpochSeconds()), ZoneId.systemDefault())
        );
    }

    public TimeLeft getTimeLeftToRace() {
        return new TimeLeft(getDurationUntilRace());
    }
}
