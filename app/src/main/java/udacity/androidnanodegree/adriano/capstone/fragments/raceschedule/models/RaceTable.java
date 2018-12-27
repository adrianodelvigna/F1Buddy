
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import java.util.List;
import com.squareup.moshi.Json;

public class RaceTable {

    @Json(name = "season")
    public String season;
    @Json(name = "Races")
    public List<Race> races = null;
}
