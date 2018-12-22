package udacity.androidnanodegree.adriano.capstone;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.RaceSchedule;

public class MainActivity extends AppCompatActivity implements
        RaceFragment.OnListFragmentInteractionListener,
        DriverFragment.OnListFragmentInteractionListener,
        ConstructorFragment.OnListFragmentInteractionListener {

    private final static int NUM_PAGES = 3;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.pager) ViewPager viewPager;

    private MainActivityPageAdapter mainActivityPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mainActivityPageAdapter = new MainActivityPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainActivityPageAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    private static class MainActivityPageAdapter extends FragmentPagerAdapter {
        public MainActivityPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0: return RaceFragment.newInstance(1);
                case 1: return DriverFragment.newInstance(1);
                case 2: return ConstructorFragment.newInstance(1);
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Races";
                case 1: return "Drivers";
                case 2: return "Constructors";
            }
            return super.getPageTitle(position);
        }
    }
}
