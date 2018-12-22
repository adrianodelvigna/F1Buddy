package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment.OnListFragmentInteractionListener;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.ConstructorStanding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ConstructorStanding} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConstructorRecyclerViewAdapter extends RecyclerView.Adapter<ConstructorRecyclerViewAdapter.ViewHolder> {

    private final List<ConstructorStanding> constructorStandings;
    private final OnListFragmentInteractionListener mListener;

    public ConstructorRecyclerViewAdapter(List<ConstructorStanding> constructorStandings, OnListFragmentInteractionListener listener) {
        this.constructorStandings = constructorStandings;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_constructor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = constructorStandings.get(position);
        holder.mIdView.setText(constructorStandings.get(position).getPositionText());
        holder.mContentView.setText(constructorStandings.get(position).getConstructor().getName());

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
        return constructorStandings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public ConstructorStanding mItem;

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
