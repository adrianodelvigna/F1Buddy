package udacity.androidnanodegree.adriano.capstone.common.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.database.ConstructorStandingsDao;
import udacity.androidnanodegree.adriano.capstone.common.webapi.ApiResponse;
import udacity.androidnanodegree.adriano.capstone.common.webapi.ApiService;
import udacity.androidnanodegree.adriano.capstone.common.webapi.NetworkAsyncTask;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStandings;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.StandingsList;

@Singleton
public class ConstructorStandingsRepository {
    private final ApiService apiService;
    private final ConstructorStandingsDao constructorStandingsDao;

    @Inject
    public ConstructorStandingsRepository(ApiService apiService, ConstructorStandingsDao constructorStandingsDao) {
        this.apiService = apiService;
        this.constructorStandingsDao = constructorStandingsDao;
    }

    public LiveData<Resource<List<ConstructorStanding>>> loadDriverStandingsForSeason(int season) {
        return new NetworkBoundResource<List<ConstructorStanding>, ConstructorStandings>() {

            @Override
            protected void saveCallResult(@NonNull ConstructorStandings item) {
                List<StandingsList> standingsLists = item.mRData.standingsTable.standingsLists;

                // We need to "transform" the response here before adding to the database
                if (!standingsLists.isEmpty()) {
                    StandingsList standingsList = standingsLists.get(0);
                    List<ConstructorStanding> constructorStandings = standingsList.constructorStandings;

                    for (ConstructorStanding constructorStanding:constructorStandings) {
                        // We get the season (part of primary keys)
                        constructorStanding.season = standingsList.season;
                    }

                    constructorStandingsDao.insertAll(constructorStandings);
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<ConstructorStanding> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<ConstructorStanding>> loadFromDb() {
                return constructorStandingsDao.getConstructorStandingsForSeason(season);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<ConstructorStandings>> createCall() {
                NetworkAsyncTask<ConstructorStandings> networkAsyncTask = new NetworkAsyncTask<>();
                networkAsyncTask.execute(apiService.getConstructorStandingsForSeason(season));
                return networkAsyncTask.getApiResponseLiveData();
            }
        }.asLiveData();
    }
}
