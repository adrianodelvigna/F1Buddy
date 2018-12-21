
package udacity.androidnanodegree.adriano.capstone.models.DriverStandings;

import com.squareup.moshi.Json;

public class Driver {

    @Json(name = "driverId")
    private String driverId;
    @Json(name = "permanentNumber")
    private String permanentNumber;
    @Json(name = "code")
    private String code;
    @Json(name = "url")
    private String url;
    @Json(name = "givenName")
    private String givenName;
    @Json(name = "familyName")
    private String familyName;
    @Json(name = "dateOfBirth")
    private String dateOfBirth;
    @Json(name = "nationality")
    private String nationality;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
