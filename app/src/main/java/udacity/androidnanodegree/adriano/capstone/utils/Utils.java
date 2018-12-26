package udacity.androidnanodegree.adriano.capstone.utils;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.utils.TimeLeft;

public class Utils {
    public static TimeLeft getTimeLeftForRace(Race race) {
        // Reference for synchronization: https://www.f1widget.com/

        TimeLeft timeLeft = new TimeLeft();

        // Get what's next race time -- Melbourne
        String raceDate = "2019-03-17";// race.getDate();
        String raceTime = "05:10:00Z";// race.getTime();
        ZonedDateTime raceZonedDateTime = Instant.parse(raceDate + "T" + raceTime).atZone(ZoneId.of("Z"));
        ZonedDateTime localRaceZonedDateTime = raceZonedDateTime.withZoneSameInstant(ZoneId.systemDefault());

        // Get device's current time
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        // Calculate how much time until next race
        Duration duration = Duration.between(currentZonedDateTime, localRaceZonedDateTime);

        timeLeft.days = duration.toDays();
        timeLeft.hours = duration.minusDays(timeLeft.days).toHours();
        timeLeft.minutes = duration.minusDays(timeLeft.days).minusHours(timeLeft.hours).toMinutes();

        return timeLeft;
    }
}
