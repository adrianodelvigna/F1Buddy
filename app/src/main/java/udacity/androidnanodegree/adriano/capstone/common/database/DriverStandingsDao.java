package udacity.androidnanodegree.adriano.capstone.common.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;

@Dao
public interface DriverStandingsDao {
    @Query("SELECT * FROM driverstanding WHERE season = :season")
    LiveData<List<DriverStanding>> getDriverStandingsForSeason(int season);

    @Insert
    void insertAll(List<DriverStanding> driverStandings);

    @Delete
    void delete(DriverStanding driverStanding);
}
