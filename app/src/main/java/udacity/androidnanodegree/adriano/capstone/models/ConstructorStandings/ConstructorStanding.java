
package udacity.androidnanodegree.adriano.capstone.models.ConstructorStandings;

import com.squareup.moshi.Json;

public class ConstructorStanding {

    @Json(name = "position")
    private String position;
    @Json(name = "positionText")
    private String positionText;
    @Json(name = "points")
    private String points;
    @Json(name = "wins")
    private String wins;
    @Json(name = "Constructor")
    private Constructor constructor;

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

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

}
