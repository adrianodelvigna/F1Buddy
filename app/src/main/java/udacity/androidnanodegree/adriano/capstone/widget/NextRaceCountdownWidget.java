package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.RemoteViews;

import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

/**
 * Implementation of App Widget functionality.
 */
public class NextRaceCountdownWidget extends AppWidgetProvider {
    private enum AlarmStatus { ENABLED, DISABLED }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews remoteViews = new RemoteViews(
                context.getPackageName(),
                R.layout.next_race_countdown_widget);
        remoteViews.setTextViewText(
                R.id.appwidget_text,
                getNextRace().getTimeLeftToRace().toString());
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
            setAlarm(context, appWidgetId, AlarmStatus.ENABLED);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // when the last widget is disabled stop services
        context.stopService(new Intent(context, NextRaceCountdownService.class));
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) setAlarm(context, appWidgetId, AlarmStatus.DISABLED);
    }

    private PendingIntent createPendingCountdownServiceIntent(Context context, int appWidgetId) {
        Intent serviceIntent = new Intent(context, NextRaceCountdownService.class);
        serviceIntent.setAction(NextRaceCountdownService.COUNTDOWN_TICK);
        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

        Uri intentData = Uri.withAppendedPath(
                Uri.parse("f1_buddy://widget/countdown/tick"),
                String.valueOf(appWidgetId));
        serviceIntent.setData(intentData);

        //TODO: perhaps replace this with a broadcast intent later. E.g.: reminder's alarm
        return PendingIntent.getService(
                context,
                0,
                serviceIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void setAlarm(Context context, int appWidgetId, AlarmStatus alarmStatus) {
        PendingIntent pendingIntent = createPendingCountdownServiceIntent(context, appWidgetId);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        switch (alarmStatus) {
            case ENABLED:
                /* Sets an alarm which start a service which in turn updates the widgets */
                alarmManager.setRepeating(
                        AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime(),
                        NextRaceCountdownService.UPDATE_RATE,
                        pendingIntent);
                break;
            case DISABLED:
                alarmManager.cancel(pendingIntent);
                break;
        }
    }

    //TODO: implement this!!!
    private Race getNextRace() {
        Race race = new Race();
        race.date = "2019-03-17";
        race.time = "05:10:00Z";
        return race;
    }
}
