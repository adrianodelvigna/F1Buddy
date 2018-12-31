
package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models;

import com.squareup.moshi.Json;

public class MRData {

    @Json(name = "xmlns")
    public String xmlns;
    @Json(name = "series")
    public String series;
    @Json(name = "url")
    public String url;
    @Json(name = "limit")
    public String limit;
    @Json(name = "offset")
    public String offset;
    @Json(name = "total")
    public String total;
    @Json(name = "StandingsTable")
    public StandingsTable standingsTable;
}
