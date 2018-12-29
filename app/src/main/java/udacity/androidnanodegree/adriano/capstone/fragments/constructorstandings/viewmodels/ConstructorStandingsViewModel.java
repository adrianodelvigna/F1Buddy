package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.repositories.ConstructorStandingsRepository;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;

public class ConstructorStandingsViewModel extends ViewModel {
    ConstructorStandingsRepository constructorStandingsRepository;

    @Inject
    public ConstructorStandingsViewModel(ConstructorStandingsRepository constructorStandingsRepository) {
        this.constructorStandingsRepository = constructorStandingsRepository;
    }

    public LiveData<Resource<List<ConstructorStanding>>> loadConstructorStandingsForSeason(int season) {
        return constructorStandingsRepository.loadDriverStandingsForSeason(season);
    }
}
