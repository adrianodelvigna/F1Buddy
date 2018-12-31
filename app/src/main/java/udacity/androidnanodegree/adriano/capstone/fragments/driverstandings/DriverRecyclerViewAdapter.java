package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.DriverFragment.OnListFragmentInteractionListener;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DriverStanding} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class DriverRecyclerViewAdapter extends RecyclerView.Adapter<DriverRecyclerViewAdapter.ViewHolder> {

    private final List<DriverStanding> driverStandings;
    private final OnListFragmentInteractionListener mListener;

    public DriverRecyclerViewAdapter(List<DriverStanding> driverStandings, OnListFragmentInteractionListener listener) {
        this.driverStandings = driverStandings;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_standing, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final DriverStanding driverStanding = driverStandings.get(position);
        holder.mItem = driverStanding;
        holder.itemNumber.setText(driverStanding.positionText);
        final String driverFullName = holder.mView
                .getContext()
                .getString(R.string.driver_full_name,
                        driverStanding.driver.givenName,
                        driverStanding.driver.familyName);
        holder.itemTitle.setText(driverFullName);
        holder.itemSubtitle.setText(driverStanding.constructor.name);
        holder.driverPoints.setText(driverStanding.points.toString());
        holder.avatar.setImageResource(R.drawable.ic_person_white_24dp);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return driverStandings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.itemNumber) TextView itemNumber;
        @BindView(R.id.itemTitle) TextView itemTitle;
        @BindView(R.id.itemSubtitle) TextView itemSubtitle;
        @BindView(R.id.points) TextView driverPoints;
        @BindView(R.id.avatar) ImageView avatar;
        public DriverStanding mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + itemTitle.getText() + "'";
        }
    }
}
