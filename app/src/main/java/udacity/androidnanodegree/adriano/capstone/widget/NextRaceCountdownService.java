package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.util.Locale;

import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.utils.TimeLeft;
import udacity.androidnanodegree.adriano.capstone.utils.Utils;

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

        TimeLeft timeLeft = Utils.getTimeLeftForRace(new Race());
        remoteViews.setTextViewText(R.id.appwidget_text, timeLeft.toString());
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        stopSelf(startId);
    }
}
