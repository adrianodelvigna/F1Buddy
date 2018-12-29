
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import com.squareup.moshi.Json;

import java.util.List;

public class StandingsList {

    @Json(name = "season")
    public Integer season;
    @Json(name = "round")
    public Integer round;
    @Json(name = "DriverStandings")
    public List<DriverStanding> driverStandings = null;
}
