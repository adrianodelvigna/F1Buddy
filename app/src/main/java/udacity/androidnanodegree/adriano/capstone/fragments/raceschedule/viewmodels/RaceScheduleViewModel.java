package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.repositories.SeasonScheduleRepository;

public class RaceScheduleViewModel extends ViewModel {
    SeasonScheduleRepository seasonScheduleRepository;

    @Inject
    public RaceScheduleViewModel(SeasonScheduleRepository seasonScheduleRepository) {
        this.seasonScheduleRepository = seasonScheduleRepository;
    }

    public LiveData<Resource<List<Race>>> loadScheduleForSeason(Integer season) {
        return seasonScheduleRepository.loadScheduleForSeason(season);
    }

    public void updateRace(Race race) {
        seasonScheduleRepository.updateRace(race);
    }
}
