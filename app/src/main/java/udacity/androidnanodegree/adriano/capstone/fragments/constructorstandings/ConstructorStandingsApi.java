package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStandings;

public interface ConstructorStandingsApi {
    //http://ergast.com/api/f1/2008/constructorStandings.json
    @GET("f1/{season}/constructorStandings.json")
    Observable<ConstructorStandings> getConstructorStandingsForSeason(@Path("season") String season);
}
