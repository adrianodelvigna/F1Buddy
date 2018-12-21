
package udacity.androidnanodegree.adriano.capstone.models.RaceSchedule;

import com.squareup.moshi.Json;

public class Circuit {

    @Json(name = "circuitId")
    private String circuitId;
    @Json(name = "url")
    private String url;
    @Json(name = "circuitName")
    private String circuitName;
    @Json(name = "Location")
    private Location location;

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
