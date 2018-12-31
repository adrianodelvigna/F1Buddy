package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models;

import android.support.annotation.NonNull;

import org.threeten.bp.Duration;

import java.util.Locale;

public class TimeLeft {
    public final Long days;
    public final Long hours;
    public final Long minutes;

    public TimeLeft(Duration duration) {
        days = duration.toDays();
        hours = duration.minusDays(days).toHours();
        minutes = duration.minusDays(days).minusHours(hours).toMinutes();
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%dD %02dH %02dM",
                days,
                hours,
                minutes);
    }
}
