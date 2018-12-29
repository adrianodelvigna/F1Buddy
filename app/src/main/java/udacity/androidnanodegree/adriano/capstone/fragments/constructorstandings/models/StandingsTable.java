
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

import java.util.List;

public class StandingsTable {

    @Json(name = "season")
    public Integer season;

    @Json(name = "StandingsLists")
    public List<StandingsList> standingsLists = null;
}
