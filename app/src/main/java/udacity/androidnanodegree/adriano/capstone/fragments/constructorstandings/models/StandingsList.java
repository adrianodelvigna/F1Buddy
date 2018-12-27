
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsList {

    @Json(name = "season")
    public String season;
    @Json(name = "round")
    public String round;
    @Json(name = "ConstructorStandings")
    public List<ConstructorStanding> constructorStandings = null;
}
