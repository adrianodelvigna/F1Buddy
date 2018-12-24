package udacity.androidnanodegree.adriano.capstone.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NextRaceCountdownService extends Service {
    public NextRaceCountdownService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
