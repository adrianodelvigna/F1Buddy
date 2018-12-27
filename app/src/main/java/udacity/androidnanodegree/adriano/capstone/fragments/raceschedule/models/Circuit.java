
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import android.arch.persistence.room.Embedded;

import com.squareup.moshi.Json;

public class Circuit {

    @Json(name = "circuitId")
    public String circuitId;
    @Json(name = "url")
    public String url;
    @Json(name = "circuitName")
    public String circuitName;

    @Json(name = "Location")
    @Embedded
    public Location location;
}
