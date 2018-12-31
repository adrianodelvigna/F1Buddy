package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.TimeLeft;

public class NextRaceCountdownService extends Service {
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
        TimeLeft timeLeft = getNextRace().getTimeLeftToRace();

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        RemoteViews remoteViews = new RemoteViews(
                context.getPackageName(),
                R.layout.next_race_countdown_widget);

        remoteViews.setTextViewText(R.id.daysLeft, timeLeft.days.toString());
        remoteViews.setTextViewText(R.id.hoursLeft, timeLeft.hours.toString());
        remoteViews.setTextViewText(R.id.minutesLeft, timeLeft.minutes.toString());

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        stopSelf(startId);
    }

    //TODO: implement this!!!
    private Race getNextRace() {
        //TODO: fix the below
        // Hardcoded 2019 Australian Grand Prix
        Race race = new Race();
        race.date = "2019-03-17";
        race.time = "05:10:00Z";
        return race;
    }
}
