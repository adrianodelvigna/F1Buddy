package udacity.androidnanodegree.adriano.capstone.fragments.raceschedule;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.common.Resource;
import udacity.androidnanodegree.adriano.capstone.common.di.Injectable;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.models.Race;
import udacity.androidnanodegree.adriano.capstone.fragments.raceschedule.viewmodels.RaceScheduleViewModel;

import static udacity.androidnanodegree.adriano.capstone.common.Status.LOADING;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RaceFragment extends Fragment implements Injectable {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private Unbinder unbinder;
    @BindView(R.id.loading) LinearLayout loading;
    @BindView(R.id.list) RecyclerView recyclerView;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private RaceScheduleViewModel raceScheduleViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RaceFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RaceFragment newInstance(int columnCount) {
        RaceFragment fragment = new RaceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        raceScheduleViewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(RaceScheduleViewModel.class);
        raceScheduleViewModel
                .loadScheduleForSeason(2018)
                .observe(this, this::scheduleForSeasonObserver);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_race_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Set the adapter
        Context context = view.getContext();
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        return view;
    }

    private void scheduleForSeasonObserver(Resource<List<Race>> listResource) {
        loading.setVisibility(listResource.status == LOADING ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(listResource.status == LOADING ? View.GONE : View.VISIBLE);

        switch (listResource.status) {
            case SUCCESS:
                recyclerView.swapAdapter(new RaceRecyclerViewAdapter(listResource.data, mListener), true);
                break;
            case ERROR:
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Race item);
    }
}
