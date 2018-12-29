package udacity.androidnanodegree.adriano.capstone.common.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract RaceFragment contributeRaceFragment();

    @ContributesAndroidInjector
    abstract DriverFragment contributeDriverFragment();

    @ContributesAndroidInjector
    abstract ConstructorFragment contributeConstructorFragment();
}
