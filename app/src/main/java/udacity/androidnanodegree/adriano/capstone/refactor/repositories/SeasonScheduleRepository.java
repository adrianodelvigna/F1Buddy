package udacity.androidnanodegree.adriano.capstone.refactor.repositories;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceSchedule;
import udacity.androidnanodegree.adriano.capstone.refactor.Resource;
import udacity.androidnanodegree.adriano.capstone.refactor.database.SeasonScheduleDao;
import udacity.androidnanodegree.adriano.capstone.refactor.webapi.ApiResponse;
import udacity.androidnanodegree.adriano.capstone.refactor.webapi.ApiService;
import udacity.androidnanodegree.adriano.capstone.refactor.webapi.NetworkAsyncTask;

@Singleton
public class SeasonScheduleRepository {
    private final ApiService apiService;
    private final SeasonScheduleDao seasonScheduleDao;

    @Inject
    public SeasonScheduleRepository(ApiService apiService, SeasonScheduleDao seasonScheduleDao) {
        this.apiService = apiService;
        this.seasonScheduleDao = seasonScheduleDao;
    }

    public LiveData<Resource<List<Race>>> loadScheduleForSeason(Integer season) {
        return new NetworkBoundResource<List<Race>, RaceSchedule>() {

            @Override
            protected void saveCallResult(@NonNull RaceSchedule item) {
                seasonScheduleDao.insertAll(item.mRData.raceTable.races);
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Race> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<Race>> loadFromDb() {
                return seasonScheduleDao.getAllRacesFromSeason(season);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<RaceSchedule>> createCall() {
                NetworkAsyncTask<RaceSchedule> networkAsyncTask = new NetworkAsyncTask<>();
                networkAsyncTask.execute(apiService.getRaceScheduleForSeason(season));
                return networkAsyncTask.getApiResponseLiveData();
            }
        }.asLiveData();
    }
}
