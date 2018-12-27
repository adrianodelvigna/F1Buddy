
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class StandingsTable {

    @Json(name = "season")
    public String season;
    @Json(name = "StandingsLists")
    public List<StandingsList> standingsLists = null;
}
