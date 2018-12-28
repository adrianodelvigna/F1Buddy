package udacity.androidnanodegree.adriano.capstone;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import javax.inject.Inject;

import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment;

public class MainPageController {
    private final static int NUM_PAGES = 3;
    private final MainPageAdapter mainPageAdapter;

    @Inject
    public MainPageController(MainActivity mainActivity) {
        mainPageAdapter = new MainPageAdapter(mainActivity.getSupportFragmentManager());
    }

    public MainPageAdapter getMainPageAdapter() {
        return mainPageAdapter;
    }

    private static class MainPageAdapter extends FragmentPagerAdapter {
        public MainPageAdapter(FragmentManager fm) {
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
