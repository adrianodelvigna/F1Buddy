package udacity.androidnanodegree.adriano.capstone.common.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;

@Dao
public interface ConstructorStandingsDao {
    @Query("SELECT * FROM constructorstanding WHERE season = :season")
    LiveData<List<ConstructorStanding>> getConstructorStandingsForSeason(int season);

    @Insert
    void insertAll(List<ConstructorStanding> constructorStandings);

    @Delete
    void delete(ConstructorStanding constructorStanding);
}
