
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsList {

    @Json(name = "season")
    private String season;
    @Json(name = "round")
    private String round;
    @Json(name = "DriverStandings")
    private List<DriverStanding> driverStandings = null;

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

    public List<DriverStanding> getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(List<DriverStanding> driverStandings) {
        this.driverStandings = driverStandings;
    }

}
