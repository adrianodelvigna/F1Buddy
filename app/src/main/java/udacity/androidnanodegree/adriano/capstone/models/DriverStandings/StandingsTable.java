
package udacity.androidnanodegree.adriano.capstone.models.DriverStandings;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsTable {

    @Json(name = "season")
    private String season;
    @Json(name = "StandingsLists")
    private List<StandingsList> standingsLists = null;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<StandingsList> getStandingsLists() {
        return standingsLists;
    }

    public void setStandingsLists(List<StandingsList> standingsLists) {
        this.standingsLists = standingsLists;
    }

}
