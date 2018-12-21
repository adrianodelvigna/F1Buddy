
package udacity.androidnanodegree.adriano.capstone.models.DriverStandings;

import com.squareup.moshi.Json;

public class Constructor {

    @Json(name = "constructorId")
    private String constructorId;
    @Json(name = "url")
    private String url;
    @Json(name = "name")
    private String name;
    @Json(name = "nationality")
    private String nationality;

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
