package udacity.androidnanodegree.adriano.capstone.common.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

@Database(entities = {Race.class, DriverStanding.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    abstract public SeasonScheduleDao seasonScheduleDao();
    abstract public DriverStandingsDao driverStandingsDao();
    abstract public ConstructorStandingsDao constructorStandingsDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS DriverStanding " +
                    "(`season` INTEGER NOT NULL, " +
                    "`position` INTEGER NOT NULL, " +
                    "`positionText` TEXT, " +
                    "`points` INTEGER NOT NULL, " +
                    "`wins` INTEGER NOT NULL, " +
                    "`driver_driverId` TEXT, " +
                    "`driver_permanentNumber` TEXT, " +
                    "`driver_code` TEXT, " +
                    "`driver_url` TEXT, " +
                    "`driver_givenName` TEXT, " +
                    "`driver_familyName` TEXT, " +
                    "`driver_dateOfBirth` TEXT, " +
                    "`driver_nationality` TEXT, " +
                    "`constructor_constructorId` TEXT, " +
                    "`constructor_url` TEXT, " +
                    "`constructor_name` TEXT, " +
                    "`constructor_nationality` TEXT, " +
                    "PRIMARY KEY(`season`, `position`))");
        }
    };
}
