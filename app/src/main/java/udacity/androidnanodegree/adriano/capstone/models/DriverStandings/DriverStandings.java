
package udacity.androidnanodegree.adriano.capstone.models.DriverStandings;

import com.squareup.moshi.Json;

public class DriverStandings {

    @Json(name = "MRData")
    private MRData mRData;

    public MRData getMRData() {
        return mRData;
    }

    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }

}
