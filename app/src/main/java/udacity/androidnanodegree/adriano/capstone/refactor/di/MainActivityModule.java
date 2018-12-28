package udacity.androidnanodegree.adriano.capstone.refactor.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import udacity.androidnanodegree.adriano.capstone.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
