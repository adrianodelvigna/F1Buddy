package udacity.androidnanodegree.adriano.capstone;

import android.app.Activity;
import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import udacity.androidnanodegree.adriano.capstone.refactor.di.AppInjector;

public final class F1BuddyApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
        AndroidThreeTen.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
