package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorStandingsService;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.StandingsTable;

public class ConstructorStandingsViewModel extends ViewModel {
    private MutableLiveData<Boolean> isLoadingMutableLiveData;
    private MutableLiveData<StandingsTable> constructorStandingsTableMutableLiveData;
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

    public LiveData<StandingsTable> getConstructorStandingsTableLiveData() {
        if (constructorStandingsTableMutableLiveData == null) {
            constructorStandingsTableMutableLiveData = new MutableLiveData<>();
            loadStandingsTable();
        }
        return constructorStandingsTableMutableLiveData;
    }

    private void loadStandingsTable() {
        ConstructorStandingsService constructorStandingsService = new ConstructorStandingsService();
        isLoadingMutableLiveData.setValue(true);
        compositeDisposable.add(
        constructorStandingsService
                .getConstructorStandingsTableForSeason(2018)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(constructorStandingsTable -> {
                    isLoadingMutableLiveData.setValue(false);
                    constructorStandingsTableMutableLiveData.setValue(constructorStandingsTable);
                })
        );
    }
}
