package udacity.androidnanodegree.adriano.capstone.common.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.database.DriverStandingsDao;
import udacity.androidnanodegree.adriano.capstone.common.webapi.ApiResponse;
import udacity.androidnanodegree.adriano.capstone.common.webapi.ApiService;
import udacity.androidnanodegree.adriano.capstone.common.webapi.NetworkAsyncTask;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStandings;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.StandingsList;

@Singleton
public class DriverStandingsRepository {
    private final ApiService apiService;
    private final DriverStandingsDao driverStandingsDao;

    @Inject
    public DriverStandingsRepository(ApiService apiService, DriverStandingsDao driverStandingsDao) {
        this.apiService = apiService;
        this.driverStandingsDao = driverStandingsDao;
    }

    public LiveData<Resource<List<DriverStanding>>> loadDriverStandingsForSeason(int season) {
        return new NetworkBoundResource<List<DriverStanding>, DriverStandings>() {

            @Override
            protected void saveCallResult(@NonNull DriverStandings item) {
                List<StandingsList> standingsLists = item.mRData.standingsTable.standingsLists;

                // We need to "transform" the response here before adding to the database
                if (!standingsLists.isEmpty()) {
                    StandingsList standingsList = standingsLists.get(0);
                    List<DriverStanding> driverStandingList = standingsList.driverStandings;
                    for (DriverStanding driverStanding:driverStandingList) {
                        // We get the season (part of primary keys)
                        driverStanding.season = standingsList.season;

                        if (!driverStanding.constructors.isEmpty()) {
                            // And we get the constructor, which originally is part of a List<>
                            driverStanding.constructor = driverStanding.constructors.get(0);
                        }
                    }

                    driverStandingsDao.insertAll(driverStandingList);
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<DriverStanding> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<DriverStanding>> loadFromDb() {
                return driverStandingsDao.getDriverStandingsForSeason(season);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<DriverStandings>> createCall() {
                NetworkAsyncTask<DriverStandings> networkAsyncTask = new NetworkAsyncTask<>();
                networkAsyncTask.execute(apiService.getDriverStandingsForSeason(season));
                return networkAsyncTask.getApiResponseLiveData();
            }
        }.asLiveData();
    }
}
