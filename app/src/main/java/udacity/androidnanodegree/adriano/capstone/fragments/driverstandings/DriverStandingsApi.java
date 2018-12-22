package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStandings;

public interface DriverStandingsApi {
    //http://ergast.com/api/f1/2008/driverStandings.json
    @GET("f1/{season}/driverStandings.json")
    Observable<DriverStandings> getDriverStandingsForSeason(@Path("season") String season);
}
