package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import udacity.androidnanodegree.adriano.capstone.ErgastApi;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.StandingsTable;

public class DriverStandingsService {
    private ErgastApi ergastApi;

    public DriverStandingsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ergast.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ergastApi = retrofit.create(ErgastApi.class);
    }

    public Observable<StandingsTable> getDriverStandingsTableForSeason(Integer season) {
        return ergastApi
                .getDriverStandingsForSeason(season.toString())
                .map(standingsList -> standingsList
                        .getMRData()
                        .getStandingsTable());
    }

}
