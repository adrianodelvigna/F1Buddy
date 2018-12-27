
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

public class ConstructorStanding {

    @Json(name = "position")
    public String position;
    @Json(name = "positionText")
    public String positionText;
    @Json(name = "points")
    public String points;
    @Json(name = "wins")
    public String wins;
    @Json(name = "Constructor")
    public Constructor constructor;
}
