package udacity.androidnanodegree.adriano.capstone;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import udacity.androidnanodegree.adriano.capstone.models.RaceSchedule.RaceTable;

public class ErgastService {
    private ErgastApi ergastApi;

    public ErgastService() {
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

    public
    Observable<udacity.androidnanodegree.adriano.capstone.models.ConstructorStandings.StandingsTable>
    getConstructorStandingsTableForSeason(Integer season) {
        return ergastApi
                .getConstructorStandingsForSeason(season.toString())
                .map(standingsList -> standingsList
                        .getMRData()
                        .getStandingsTable());
    }

    public
    Observable<udacity.androidnanodegree.adriano.capstone.models.DriverStandings.StandingsTable>
    getDriverStandingsTableForSeason(Integer season) {
        return ergastApi
                .getDriverStandingsForSeason(season.toString())
                .map(standingsList -> standingsList
                        .getMRData()
                        .getStandingsTable());
    }

}
