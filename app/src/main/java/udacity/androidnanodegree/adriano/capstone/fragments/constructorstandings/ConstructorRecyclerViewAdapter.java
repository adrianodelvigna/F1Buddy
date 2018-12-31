package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.ConstructorFragment.OnListFragmentInteractionListener;
import udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models.Constructor;
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
                .inflate(R.layout.fragment_standing, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Context context = holder.mView.getContext();

        ConstructorStanding constructorStanding = constructorStandings.get(position);
        holder.mItem = constructorStanding;
        holder.itemNumber.setText(constructorStanding.positionText);
        holder.itemTitle.setText(constructorStanding.constructor.name);
        holder.itemSubtitle.setText(constructorStanding.constructor.nationality);
        holder.constructorPoints.setText(constructorStanding.points.toString());
        holder.avatar.setImageResource(R.drawable.ic_directions_car_white_24dp);
        holder.avatar.setContentDescription(
                context.getString(R.string.constructor_avatar_content_description, constructorStanding.constructor.name));

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
        @BindView(R.id.itemNumber) TextView itemNumber;
        @BindView(R.id.itemTitle) TextView itemTitle;
        @BindView(R.id.itemSubtitle) TextView itemSubtitle;
        @BindView(R.id.points) TextView constructorPoints;
        @BindView(R.id.avatar) ImageView avatar;
        public ConstructorStanding mItem;

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
