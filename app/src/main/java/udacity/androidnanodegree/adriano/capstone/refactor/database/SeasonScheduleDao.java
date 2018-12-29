package udacity.androidnanodegree.adriano.capstone.refactor.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

@Dao
public interface SeasonScheduleDao {
    @Query("SELECT * FROM race WHERE season = :season")
    LiveData<List<Race>> getAllRacesFromSeason(int season);

    @Insert
    void insertAll(List<Race> races);

    @Delete
    void delete(Race race);
}
