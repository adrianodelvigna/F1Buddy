package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.Locale;

import udacity.androidnanodegree.adriano.capstone.R;

public class NextRaceCountdownService extends Service {
    private static final String TAG = "NextRaceCountdownServic";

    public static final String COUNTDOWN_TICK = "udacity.androidnanodegree.adriano.capstone.widget.NextRaceCountdownService.COUNTDOWN_TICK";
    public static final long UPDATE_RATE = 60 * 1000; // one minute: 60 * 1000 milliseconds

    private Context context;
    private int startId;

    public NextRaceCountdownService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        context = getApplicationContext();
        this.startId = startId;

        if (intent.hasExtra(AppWidgetManager.EXTRA_APPWIDGET_ID)) {
            updateWidgetWithId(intent.getExtras().getInt(AppWidgetManager.EXTRA_APPWIDGET_ID));
        }

        return Service.START_REDELIVER_INTENT;
    }

    private void updateWidgetWithId(int appWidgetId) {
        RemoteViews remoteViews = new RemoteViews(
                context.getPackageName(),
                R.layout.next_race_countdown_widget);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        // Reference for synchronization: https://www.f1widget.com/

        // Get what's next race time -- Melbourne
        String date = "2019-03-17";
        String time = "05:10:00Z";
        ZonedDateTime raceZonedDateTime = Instant.parse(date + "T" + time).atZone(ZoneId.of("Z"));
        ZonedDateTime localRaceZonedDateTime = raceZonedDateTime.withZoneSameInstant(ZoneId.systemDefault());


        // Get device's current time
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        // Calculate how much time until next race
        Duration duration = Duration.between(currentZonedDateTime, localRaceZonedDateTime);

        long daysLeft = duration.toDays();
        long hoursLeft = duration.minusDays(daysLeft).toHours();
        long minutesLeft = duration.minusDays(daysLeft).minusHours(hoursLeft).toMinutes();

        String timeLeft = String.format(Locale.getDefault(), "%dD %02dH %02dM", daysLeft, hoursLeft, minutesLeft);
        remoteViews.setTextViewText(R.id.appwidget_text, timeLeft);

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        stopSelf(startId);
    }
}
