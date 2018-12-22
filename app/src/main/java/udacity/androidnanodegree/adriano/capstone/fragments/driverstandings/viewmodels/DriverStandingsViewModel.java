package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverStandingsService;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.StandingsTable;

public class DriverStandingsViewModel extends ViewModel {
    private MutableLiveData<Boolean> isLoadingMutableLiveData;
    private MutableLiveData<StandingsTable> driverStandingsTableMutableLiveData;
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

    public LiveData<StandingsTable> getDriverStandingsTableLiveData() {
        if (driverStandingsTableMutableLiveData == null) {
            driverStandingsTableMutableLiveData = new MutableLiveData<>();
            loadStandingsTable();
        }
        return driverStandingsTableMutableLiveData;
    }

    private void loadStandingsTable() {
        DriverStandingsService driverStandingsService = new DriverStandingsService();
        isLoadingMutableLiveData.setValue(true);
        compositeDisposable.add(
        driverStandingsService
                .getDriverStandingsTableForSeason(2018)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(driverStandingsTable -> {
                    isLoadingMutableLiveData.setValue(false);
                    driverStandingsTableMutableLiveData.setValue(driverStandingsTable);
                })
        );
    }
}
