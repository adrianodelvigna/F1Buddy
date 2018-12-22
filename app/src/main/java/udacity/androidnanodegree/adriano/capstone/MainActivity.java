package udacity.androidnanodegree.adriano.capstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

public class MainActivity extends AppCompatActivity implements
        RaceFragment.OnListFragmentInteractionListener,
        DriverFragment.OnListFragmentInteractionListener,
        ConstructorFragment.OnListFragmentInteractionListener {

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

    @Override
    public void onListFragmentInteraction(ConstructorStanding item) {

    }
}
