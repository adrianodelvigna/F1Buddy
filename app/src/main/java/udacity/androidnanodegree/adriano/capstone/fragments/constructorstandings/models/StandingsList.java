
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsList {

    @Json(name = "season")
    private String season;
    @Json(name = "round")
    private String round;
    @Json(name = "ConstructorStandings")
    private List<ConstructorStanding> constructorStandings = null;

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

    public List<ConstructorStanding> getConstructorStandings() {
        return constructorStandings;
    }

    public void setConstructorStandings(List<ConstructorStanding> constructorStandings) {
        this.constructorStandings = constructorStandings;
    }

}
