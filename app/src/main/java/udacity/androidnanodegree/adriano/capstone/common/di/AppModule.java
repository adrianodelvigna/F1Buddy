package udacity.androidnanodegree.adriano.capstone.common.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import udacity.androidnanodegree.adriano.capstone.common.database.AppDatabase;
import udacity.androidnanodegree.adriano.capstone.common.database.ConstructorStandingsDao;
import udacity.androidnanodegree.adriano.capstone.common.database.DriverStandingsDao;
import udacity.androidnanodegree.adriano.capstone.common.database.SeasonScheduleDao;
import udacity.androidnanodegree.adriano.capstone.common.webapi.ApiService;

@Module(includes = ViewModelModule.class)
public class AppModule {
    @Provides
    @Singleton
    ApiService providesApiService() {
        return new Retrofit.Builder()
                .baseUrl("http://ergast.com/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    AppDatabase providesAppDatabase(Application application) {
        return Room
                .databaseBuilder(application, AppDatabase.class, "app.db")
                .addMigrations(
                        AppDatabase.MIGRATION_1_2,
                        AppDatabase.MIGRATION_2_3)
                .build();
    }

    @Provides
    @Singleton
    SeasonScheduleDao providesSeasonScheduleDao(AppDatabase appDatabase) {
        return appDatabase.seasonScheduleDao();
    }

    @Provides
    @Singleton
    DriverStandingsDao providesDriverStandingsDao(AppDatabase appDatabase) {
        return appDatabase.driverStandingsDao();
    }

    @Provides
    @Singleton
    ConstructorStandingsDao providesConstructorStandingsDao(AppDatabase appDatabase) {
        return appDatabase.constructorStandingsDao();
    }

    @Provides
    @Singleton
    FirebaseAnalytics providesFirebaseAnalytics(Application application) {
        return FirebaseAnalytics.getInstance(application);
    }
}
