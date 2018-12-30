package udacity.androidnanodegree.adriano.capstone.reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import org.threeten.bp.Instant;

import java.util.Random;

import udacity.androidnanodegree.adriano.capstone.R;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(context.getString(R.string.grand_prix_reminder_action))) {
            displayReminderNotification(context, intent);
        }
    }

    private void displayReminderNotification(Context context, Intent intent) {
        final String extraGrandPrixName = context.getString(R.string.EXTRA_GRANDPRIX_NAME);
        String grandPrixName = intent.hasExtra(extraGrandPrixName) ?
                intent.getStringExtra(extraGrandPrixName) :
                context.getString(R.string.generic_reminder_notification_title);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context,
                context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.ic_alarm_black_24dp)
                .setContentTitle(grandPrixName)
                .setContentText(context.getString(R.string.race_reminder_text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        // notificationId is a unique int for each notification that must be defined
        notificationManager.notify(
                new Random(Instant.now().toEpochMilli()).nextInt(),
                mBuilder.build());
    }
}
