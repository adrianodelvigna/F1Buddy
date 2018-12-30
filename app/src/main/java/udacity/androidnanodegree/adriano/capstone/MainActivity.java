package udacity.androidnanodegree.adriano.capstone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.reminder.AlarmScheduler;

public class MainActivity extends AppCompatActivity implements
        HasSupportFragmentInjector,
        RaceFragment.OnListFragmentInteractionListener,
        DriverFragment.OnListFragmentInteractionListener,
        ConstructorFragment.OnListFragmentInteractionListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.pager) ViewPager viewPager;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    MainPageController mainPageController;
    @Inject
    FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        viewPager.setAdapter(mainPageController.getMainPageAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {}

            @Override
            public void onPageSelected(int i) {
                String pageTitle = viewPager.getAdapter().getPageTitle(i).toString();
                logItemSelectionEvent("page_selection", pageTitle, "navigation");
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });
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
                displayAboutActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(Race item) {
        logItemSelectionEvent(item.round.toString(), item.raceName, "race");
        launchBrowserIntentForUrl(item.url);
//        AlarmScheduler.scheduleAlarmForRace(this, item);
    }

    @Override
    public void onListFragmentInteraction(DriverStanding item) {
        logItemSelectionEvent(item.driver.driverId, item.driver.code, "driver");
        launchBrowserIntentForUrl(item.driver.url);
    }

    @Override
    public void onListFragmentInteraction(ConstructorStanding item) {
        logItemSelectionEvent(item.constructor.constructorId, item.constructor.name, "constructor");
        launchBrowserIntentForUrl(item.constructor.url);
    }

    private void displayAboutActivity() {
        logItemSelectionEvent("action_about", "About", "navigation");
    }

    private void logItemSelectionEvent(String id, String name, String type) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void launchBrowserIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
