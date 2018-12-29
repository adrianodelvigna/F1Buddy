package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.repositories.DriverStandingsRepository;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;

public class DriverStandingsViewModel extends ViewModel {
    DriverStandingsRepository driverStandingsRepository;

    @Inject
    public DriverStandingsViewModel(DriverStandingsRepository driverStandingsRepository) {
        this.driverStandingsRepository = driverStandingsRepository;
    }

    public LiveData<Resource<List<DriverStanding>>> loadDriverStandingsForSeason(int season) {
        return driverStandingsRepository.loadDriverStandingsForSeason(season);
    }
}
