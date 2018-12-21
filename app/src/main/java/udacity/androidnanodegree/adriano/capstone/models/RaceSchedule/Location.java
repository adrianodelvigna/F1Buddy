
package udacity.androidnanodegree.adriano.capstone.models.RaceSchedule;

import com.squareup.moshi.Json;

public class Location {

    @Json(name = "lat")
    private String lat;
    @Json(name = "long")
    private String _long;
    @Json(name = "locality")
    private String locality;
    @Json(name = "country")
    private String country;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
