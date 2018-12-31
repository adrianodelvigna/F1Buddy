
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.squareup.moshi.Json;

@Entity(primaryKeys = {"season", "position"}, tableName = "constructorstanding")
public class ConstructorStanding {

    @NonNull
    public Integer season;

    @NonNull
    @Json(name = "position")
    public Integer position;

    @Json(name = "positionText")
    public String positionText;

    @Json(name = "points")
    public Integer points;

    @Json(name = "wins")
    public Integer wins;

    @Embedded(prefix = "constructor_")
    @Json(name = "Constructor")
    public Constructor constructor;
}
