
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import com.squareup.moshi.Json;

import java.util.List;

@Entity(primaryKeys = {"season", "position"})
public class DriverStanding {

    @NonNull
    public Integer season;

    @NonNull
    @Json(name = "position")
    public Integer position;

    @Json(name = "positionText")
    public String positionText;

    @NonNull
    @Json(name = "points")
    public Integer points;

    @NonNull
    @Json(name = "wins")
    public Integer wins;

    @Embedded(prefix = "driver_")
    @Json(name = "Driver")
    public Driver driver;

    @Ignore
    @Json(name = "Constructors")
    public List<Constructor> constructors = null;

    @Embedded(prefix = "constructor_")
    public Constructor constructor;
}
