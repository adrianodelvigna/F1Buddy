
package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import com.squareup.moshi.Json;

public class RaceSchedule {

    @Json(name = "MRData")
    private MRData mRData;

    public MRData getMRData() {
        return mRData;
    }

    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }

}