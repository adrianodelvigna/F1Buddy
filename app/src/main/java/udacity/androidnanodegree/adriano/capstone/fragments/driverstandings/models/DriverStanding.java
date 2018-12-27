
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import java.util.List;
import com.squareup.moshi.Json;

public class DriverStanding {

    @Json(name = "position")
    public String position;
    @Json(name = "positionText")
    public String positionText;
    @Json(name = "points")
    public String points;
    @Json(name = "wins")
    public String wins;
    @Json(name = "Driver")
    public Driver driver;
    @Json(name = "Constructors")
    public List<Constructor> constructors = null;
}
