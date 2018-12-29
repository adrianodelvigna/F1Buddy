
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import com.squareup.moshi.Json;

public class Driver {

    @Json(name = "driverId")
    public String driverId;

    @Json(name = "permanentNumber")
    public String permanentNumber;

    @Json(name = "code")
    public String code;

    @Json(name = "url")
    public String url;

    @Json(name = "givenName")
    public String givenName;

    @Json(name = "familyName")
    public String familyName;

    @Json(name = "dateOfBirth")
    public String dateOfBirth;

    @Json(name = "nationality")
    public String nationality;
}
