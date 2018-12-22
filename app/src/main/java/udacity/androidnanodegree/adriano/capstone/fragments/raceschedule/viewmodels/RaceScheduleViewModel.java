package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceScheduleService;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceTable;

public class RaceScheduleViewModel extends ViewModel {
    private MutableLiveData<RaceTable> raceTableMutableLiveData;
    private MutableLiveData<Boolean> isLoadingMutableLiveData;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        compositeDisposable.dispose();
    }

    public LiveData<Boolean> getIsLoadingLiveData() {
        if (isLoadingMutableLiveData == null) {
            isLoadingMutableLiveData = new MutableLiveData<>();
        }
        return isLoadingMutableLiveData;
    }

    public LiveData<RaceTable> getRaceTableLiveData() {
        if (raceTableMutableLiveData == null) {
            raceTableMutableLiveData = new MutableLiveData<>();
            loadRaceTable();
        }
        return raceTableMutableLiveData;
    }

    private void loadRaceTable() {
        RaceScheduleService raceScheduleService = new RaceScheduleService();
        isLoadingMutableLiveData.setValue(true);
        compositeDisposable.add(
        raceScheduleService
                .getRaceTableForSeason(2018)
                .subscribe(raceTable -> {
                    raceTableMutableLiveData.setValue(raceTable);
                    isLoadingMutableLiveData.setValue(false);
                })
        );
    }
}
