
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

import java.util.List;

public class StandingsList {

    @Json(name = "season")
    public Integer season;

    @Json(name = "round")
    public Integer round;

    @Json(name = "ConstructorStandings")
    public List<ConstructorStanding> constructorStandings = null;
}
