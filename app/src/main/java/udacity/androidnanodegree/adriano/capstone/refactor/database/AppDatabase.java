package udacity.androidnanodegree.adriano.capstone.refactor.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

@Database(entities = {Race.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    abstract public SeasonScheduleDao seasonScheduleDao();
    abstract public DriverStandingsDao driverStandingsDao();
    abstract public ConstructorStandingsDao constructorStandingsDao();
}
