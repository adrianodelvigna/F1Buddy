
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import com.squareup.moshi.Json;

public class Location {

    @Json(name = "lat")
    public String lat;
    @Json(name = "long")
    public String _long;
    @Json(name = "locality")
    public String locality;
    @Json(name = "country")
    public String country;
}
