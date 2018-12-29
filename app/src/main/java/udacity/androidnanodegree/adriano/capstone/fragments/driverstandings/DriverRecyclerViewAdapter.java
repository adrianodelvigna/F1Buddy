package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                .inflate(R.layout.fragment_driver, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = driverStandings.get(position);
        holder.mIdView.setText(driverStandings.get(position).positionText);
        holder.mContentView.setText(driverStandings.get(position).driver.driverId);

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
        public final TextView mIdView;
        public final TextView mContentView;
        public DriverStanding mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
