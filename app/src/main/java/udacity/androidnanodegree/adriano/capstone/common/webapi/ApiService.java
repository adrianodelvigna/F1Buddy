package udacity.androidnanodegree.adriano.capstone.common.webapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStandings;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStandings;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceSchedule;

public interface ApiService {
    //http://ergast.com/api/f1/2018.json
    @GET("f1/{season}.json")
    Call<RaceSchedule> getRaceScheduleForSeason(@Path("season") int season);

    //http://ergast.com/api/f1/2008/driverStandings.json
    @GET("f1/{season}/driverStandings.json")
    Call<DriverStandings> getDriverStandingsForSeason(@Path("season") int season);

    //http://ergast.com/api/f1/2008/constructorStandings.json
    @GET("f1/{season}/constructorStandings.json")
    Call<ConstructorStandings> getConstructorStandingsForSeason(@Path("season") int season);
}
