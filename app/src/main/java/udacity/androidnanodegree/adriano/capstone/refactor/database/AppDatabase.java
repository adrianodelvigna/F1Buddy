package udacity.androidnanodegree.adriano.capstone.refactor.database;

import android.arch.persistence.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    abstract public SeasonScheduleDao seasonScheduleDao();
    abstract public DriverStandingsDao driverStandingsDao();
    abstract public ConstructorStandingsDao constructorStandingsDao();
}
