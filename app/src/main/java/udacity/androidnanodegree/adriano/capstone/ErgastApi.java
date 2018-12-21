package udacity.androidnanodegree.adriano.capstone;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.androidnanodegree.adriano.capstone.models.ConstructorStandings.ConstructorStandings;
import udacity.androidnanodegree.adriano.capstone.models.DriverStandings.DriverStandings;
import udacity.androidnanodegree.adriano.capstone.models.RaceSchedule.RaceSchedule;


public interface ErgastApi {
    //http://ergast.com/api/f1/2018.json
    @GET("f1/{season}.json")
    Observable<RaceSchedule> getRaceScheduleForSeason(@Path("season") String season);

    //http://ergast.com/api/f1/2008/driverStandings.json
    @GET("f1/{season}/driverStandings.json")
    Observable<DriverStandings> getDriverStandingsForSeason(@Path("season") String season);

    //http://ergast.com/api/f1/2008/constructorStandings.json
    @GET("f1/{season}/constructorStandings.json")
    Observable<ConstructorStandings> getConstructorStandingsForSeason(@Path("season") String season);

/*
    The following endpoints are not necessary since all information/models
    are defined and retrieved by the calls above

    //http://ergast.com/api/f1/drivers/alonso.json
    @GET("f1/drivers/{driverId}.json")
    Observable<Object> getInformationForDriverWithId(@Path("driverId") String driverId);

    //http://ergast.com/api/f1/constructors/mclaren.json
    @GET("f1/constructors/{constructorId}.json")
    Observable<Object> getInformationForConstructorWithId(@Path("constructorId") String constructorId);

    //http://ergast.com/api/f1/circuits/monza.json
    @GET("f1/circuits/{circuitId}.json")
    Observable<Object> getInformationForCircuitWithId(@Path("circuitId") String circuitId);
*/
}
