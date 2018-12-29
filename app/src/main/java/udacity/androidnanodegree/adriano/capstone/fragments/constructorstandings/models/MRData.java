
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

public class MRData {

    @Json(name = "xmlns")
    public String xmlns;
    @Json(name = "series")
    public String series;
    @Json(name = "url")
    public String url;
    @Json(name = "limit")
    public Integer limit;
    @Json(name = "offset")
    public Integer offset;
    @Json(name = "total")
    public Integer total;
    @Json(name = "StandingsTable")
    public StandingsTable standingsTable;
}
