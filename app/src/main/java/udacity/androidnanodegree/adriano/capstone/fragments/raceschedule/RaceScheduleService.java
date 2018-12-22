package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import udacity.androidnanodegree.adriano.capstone.ErgastApi;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceTable;

public class RaceScheduleService {
    private ErgastApi ergastApi;

    public RaceScheduleService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ergast.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ergastApi = retrofit.create(ErgastApi.class);
    }

    public Observable<RaceTable> getRaceTableForSeason(Integer season) {
        return ergastApi.getRaceScheduleForSeason(season.toString())
                .map(raceSchedule -> raceSchedule.getMRData().getRaceTable());
    }
}
