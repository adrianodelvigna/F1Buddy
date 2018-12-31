package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.RaceFragment.OnListFragmentInteractionListener;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.viewmodels.RaceScheduleViewModel;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Race} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RaceRecyclerViewAdapter extends RecyclerView.Adapter<RaceRecyclerViewAdapter.ViewHolder> {

    private final List<Race> mRaces;
    private final OnListFragmentInteractionListener mListener;
    private final RaceScheduleViewModel raceScheduleViewModel;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM d, YYYY 'at' h:mm a");

    public RaceRecyclerViewAdapter(
            List<Race> races,
            RaceScheduleViewModel raceScheduleViewModel,
            OnListFragmentInteractionListener listener) {
        this.mRaces = races;
        this.raceScheduleViewModel = raceScheduleViewModel;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_race, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Race race = mRaces.get(position);
        holder.mItem = race;
        holder.mIdView.setText(race.round.toString());
        holder.mContentView.setText(race.raceName);

        Instant instant = Instant.ofEpochSecond(race.getEpochSeconds());
        holder.mDate.setText(simpleDateFormat.format(DateTimeUtils.toDate(instant)));

        holder.clickableArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        // TODO: implement this!
        holder.reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mRaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.clickableArea) View clickableArea;
        @BindView(R.id.itemNumber) TextView mIdView;
        @BindView(R.id.itemTitle) TextView mContentView;
        @BindView(R.id.itemSubtitle) TextView mDate;
        @BindView(R.id.reminderButton) ImageView reminderButton;

        public Race mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
