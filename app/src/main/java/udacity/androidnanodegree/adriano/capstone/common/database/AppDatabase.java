package udacity.androidnanodegree.adriano.capstone.common.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

@Database(entities = {Race.class, DriverStanding.class, ConstructorStanding.class}, version = 4)
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

    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS constructorstanding " +
                    "(`season` INTEGER NOT NULL, " +
                    "`position` INTEGER NOT NULL, " +
                    "`positionText` TEXT, " +
                    "`points` INTEGER, " +
                    "`wins` INTEGER, " +
                    "`constructor_constructorId` TEXT, " +
                    "`constructor_url` TEXT, " +
                    "`constructor_name` TEXT, " +
                    "`constructor_nationality` TEXT, " +
                    "PRIMARY KEY(`season`, `position`))");
        }
    };

    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE race ADD COLUMN isReminderSet INTEGER DEFAULT 0");
        }
    };
}
