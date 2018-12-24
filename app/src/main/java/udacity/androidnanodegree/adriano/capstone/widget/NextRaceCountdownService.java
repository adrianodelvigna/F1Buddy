package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import udacity.androidnanodegree.adriano.capstone.R;

public class NextRaceCountdownService extends Service {
    public static final String COUNTDOWN_TICK = "udacity.androidnanodegree.adriano.capstone.widget.NextRaceCountdownService.COUNTDOWN_TICK";
    public static final int UPDATE_RATE = 60000; // one minute: 60 * 1000 milliseconds

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

        // Get what's next race time
        // Get device's current time
        // Calculate how much time until next race
        // Update countdown display accordingly

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        stopSelf(startId);
    }
}
