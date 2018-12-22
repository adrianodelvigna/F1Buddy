
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import java.util.List;
import com.squareup.moshi.Json;

public class RaceTable {

    @Json(name = "season")
    private String season;
    @Json(name = "Races")
    private List<Race> races = null;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

}
