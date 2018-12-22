
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

public class MRData {

    @Json(name = "xmlns")
    private String xmlns;
    @Json(name = "series")
    private String series;
    @Json(name = "url")
    private String url;
    @Json(name = "limit")
    private String limit;
    @Json(name = "offset")
    private String offset;
    @Json(name = "total")
    private String total;
    @Json(name = "StandingsTable")
    private StandingsTable standingsTable;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public StandingsTable getStandingsTable() {
        return standingsTable;
    }

    public void setStandingsTable(StandingsTable standingsTable) {
        this.standingsTable = standingsTable;
    }

}
