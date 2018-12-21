
package udacity.androidnanodegree.adriano.capstone.models.DriverStandings;

import java.util.List;
import com.squareup.moshi.Json;

public class DriverStanding {

    @Json(name = "position")
    private String position;
    @Json(name = "positionText")
    private String positionText;
    @Json(name = "points")
    private String points;
    @Json(name = "wins")
    private String wins;
    @Json(name = "Driver")
    private Driver driver;
    @Json(name = "Constructors")
    private List<Constructor> constructors = null;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }

}
