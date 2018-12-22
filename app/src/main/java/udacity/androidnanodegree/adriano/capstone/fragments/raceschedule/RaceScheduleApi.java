package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceSchedule;

public interface RaceScheduleApi {
    //http://ergast.com/api/f1/2018.json
    @GET("f1/{season}.json")
    Observable<RaceSchedule> getRaceScheduleForSeason(@Path("season") String season);
}
