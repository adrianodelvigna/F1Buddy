package udacity.androidnanodegree.adriano.capstone.fragments.driverstandings;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import udacity.androidnanodegree.adriano.capstone.R;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.DriverStanding;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.models.StandingsTable;
import udacity.androidnanodegree.adriano.capstone.fragments.driverstandings.viewmodels.DriverStandingsViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DriverFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private Unbinder unbinder;
    @BindView(R.id.loading) LinearLayout loading;
    @BindView(R.id.list) RecyclerView recyclerView;

    private DriverStandingsViewModel driverStandingsViewModel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DriverFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DriverFragment newInstance(int columnCount) {
        DriverFragment fragment = new DriverFragment();
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

        driverStandingsViewModel = ViewModelProviders.of(getActivity()).get(DriverStandingsViewModel.class);
        driverStandingsViewModel.getIsLoadingLiveData().observe(this, this::updateLoadingStatus);
        driverStandingsViewModel.getDriverStandingsTableLiveData().observe(this, this::updateRecyclerViewStatus);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driver_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Set the adapter
        Context context = view.getContext();
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        updateLoadingStatus(driverStandingsViewModel.getIsLoadingLiveData().getValue());
        updateRecyclerViewStatus(driverStandingsViewModel.getDriverStandingsTableLiveData().getValue());

        return view;
    }

    private void updateRecyclerViewStatus(StandingsTable standingsTable) {
        if (standingsTable != null) {
            recyclerView.swapAdapter(
                    new DriverRecyclerViewAdapter(standingsTable.getStandingsLists().get(0).getDriverStandings(),
                            mListener),
                    true);
        }
    }

    private void updateLoadingStatus(Boolean isLoading) {
        if (isLoading != null) {
            loading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
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
        void onListFragmentInteraction(DriverStanding item);
    }
}
