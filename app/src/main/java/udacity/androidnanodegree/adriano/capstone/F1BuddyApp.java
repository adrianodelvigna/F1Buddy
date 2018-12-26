package udacity.androidnanodegree.adriano.capstone;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public final class F1BuddyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }
}
