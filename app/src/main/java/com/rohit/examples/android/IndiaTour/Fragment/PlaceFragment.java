package com.rohit.examples.android.IndiaTour.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohit.examples.android.IndiaTour.Adapter.PlaceAdapter;
import com.rohit.examples.android.IndiaTour.Data.PlaceData;
import com.rohit.examples.android.IndiaTour.R;

public class PlaceFragment extends Fragment {

    //No argument constructor to prevent accidentally instantiating Class object
    public PlaceFragment() {
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * Inflating the fragment container view
     *
     * @param inflater           to inflate any views in the fragment
     * @param container          viewGroup to which the new layout is to be attached
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     * @return returns the View for the fragment's UI, or null
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment, container, false);
    }

    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned
     *
     * @param view               the View returned by onCreateView(LayoutInflater, ViewGroup, Bundle)
     * @param savedInstanceState reference to savedInstanceState using which saved fragment state can be restored
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemViewCacheSize(10);

        if (getContext() != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(new PlaceAdapter(PlaceData.fetchPlaceData(getContext()), getContext()));
        }
    }
}