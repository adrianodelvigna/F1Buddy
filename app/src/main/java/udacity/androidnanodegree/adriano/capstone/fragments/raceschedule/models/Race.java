
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.squareup.moshi.Json;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

@Entity(primaryKeys = {"season", "round"})
public class Race {

    @NonNull
    @Json(name = "season")
    public Integer season;

    @NonNull
    @Json(name = "round")
    public Integer round;

    @Json(name = "url")
    public String url;

    @Json(name = "raceName")
    public String raceName;

    @Json(name = "Circuit")
    @Embedded(prefix = "circuit_")
    public Circuit circuit;

    @Json(name = "date")
    public String date;

    @Json(name = "time")
    public String time;

    public Boolean isReminderSet = false;

    private Long epochSeconds;

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
