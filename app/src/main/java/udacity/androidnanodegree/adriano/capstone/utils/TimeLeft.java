package udacity.androidnanodegree.adriano.capstone.utils;

import android.support.annotation.NonNull;

import java.util.Locale;

public class TimeLeft {
    public long days;
    public long hours;
    public long minutes;

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%dD %02dH %02dM",
                days,
                hours,
                minutes);
    }
}
