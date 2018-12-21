
package udacity.androidnanodegree.adriano.capstone.models.ConstructorStandings;

import com.squareup.moshi.Json;

public class ConstructorStandings {

    @Json(name = "MRData")
    private MRData mRData;

    public MRData getMRData() {
        return mRData;
    }

    public void setMRData(MRData mRData) {
        this.mRData = mRData;
    }

}
