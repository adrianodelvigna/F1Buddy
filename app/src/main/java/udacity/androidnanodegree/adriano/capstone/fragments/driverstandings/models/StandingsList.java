
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsList {

    @Json(name = "season")
    public String season;
    @Json(name = "round")
    public String round;
    @Json(name = "DriverStandings")
    public List<DriverStanding> driverStandings = null;
}
