package udacity.androidnanodegree.adriano.capstone.reminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import org.threeten.bp.Instant;

import java.util.Calendar;

import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;

public class AlarmScheduler {
    static public void scheduleAlarmForRace(Context context, Race race) {
        PendingIntent alarmIntent = createAlarmIntentForRace(context, race);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) {
            //TODO: perhaps throw an exception here?
            return;
        }

        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(Instant.ofEpochSecond(race.getEpochSeconds()).toEpochMilli());
//        calendar.add(
//                Calendar.MINUTE,
//                context.getResources().getInteger(R.integer.alarm_leadtime));
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    alarmIntent);
        } else {
            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    alarmIntent);
        }

        Toast.makeText(
                context,
                context.getString(R.string.reminder_set_toast, race.raceName),
                Toast.LENGTH_SHORT)
                .show();
    }

    static public void cancelAlarmForRace(Context context, Race race) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager == null) {
            //TODO: perhaps throw an exception here?
            return;
        }

        alarmManager.cancel(createAlarmIntentForRace(context, race));
        Toast.makeText(
                context,
                context.getString(R.string.reminder_cancel_toast, race.raceName),
                Toast.LENGTH_SHORT)
                .show();
    }

    static private PendingIntent createAlarmIntentForRace(Context context, Race race) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.setAction(context.getString(R.string.grand_prix_reminder_action));

        Uri intentData = new Uri.Builder()
                .scheme("f1_buddy")
                .authority("reminder")
                .appendPath("alarm")
                .appendQueryParameter("season", race.season.toString())
                .appendQueryParameter("round", race.round.toString())
                .build();
        intent.setData(intentData);

        intent.putExtra(context.getString(R.string.EXTRA_GRANDPRIX_NAME), race.raceName);
        return PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
