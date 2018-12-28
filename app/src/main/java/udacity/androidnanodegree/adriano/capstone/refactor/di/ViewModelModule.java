package udacity.androidnanodegree.adriano.capstone.refactor.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.viewmodels.ConstructorStandingsViewModel;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.viewmodels.DriverStandingsViewModel;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.viewmodels.RaceScheduleViewModel;
import udacity.androidnanodegree.adriano.capstone.refactor.viewmodel.AppViewModelFactory;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RaceScheduleViewModel.class)
    abstract ViewModel bindRaceScheduleViewModel(RaceScheduleViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DriverStandingsViewModel.class)
    abstract ViewModel bindDriverStandingsViewModel(DriverStandingsViewModel userViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ConstructorStandingsViewModel.class)
    abstract ViewModel bindConstructorStandingsViewModel(ConstructorStandingsViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
