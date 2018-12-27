package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceTable;

public class RaceScheduleService {
    private RaceScheduleApi raceScheduleApi;

    public RaceScheduleService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ergast.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        raceScheduleApi = retrofit.create(RaceScheduleApi.class);
    }

    public Observable<RaceTable> getRaceTableForSeason(Integer season) {
        return raceScheduleApi.getRaceScheduleForSeason(season.toString())
                .map(raceSchedule -> raceSchedule.mRData.raceTable);
    }
}
