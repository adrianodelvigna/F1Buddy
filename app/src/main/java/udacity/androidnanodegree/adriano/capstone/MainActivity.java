package udacity.androidnanodegree.adriano.capstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

public class MainActivity extends AppCompatActivity implements
        RaceFragment.OnListFragmentInteractionListener,
        DriverFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Race item) {

    }

    @Override
    public void onListFragmentInteraction(DriverStanding item) {

    }
}
