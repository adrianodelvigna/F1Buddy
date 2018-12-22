package udacity.androidnanodegree.adriano.capstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

public class MainActivity extends AppCompatActivity implements RaceFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Race item) {

    }
}
