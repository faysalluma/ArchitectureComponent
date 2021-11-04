package com.groupec.architecturecomponent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.groupec.architecturecomponent.R;
import com.groupec.architecturecomponent.ViewModel.VehicleFragmentViewModel;
import com.groupec.architecturecomponent.adapters.VehicleAdapter;
import com.groupec.architecturecomponent.models.Vehicle;

import java.util.List;

public class VehiclesFragment extends Fragment {

    // Add RecyclerView and find it's id.
    private RecyclerView mRecyclerView;
    private VehicleAdapter mVehicleAdapter;

    public  VehiclesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.vehicle_recycler_view);

        // Get reference to our ViewModel class using ViewModelProviders and observe vehicleData.
        VehicleFragmentViewModel viewModel = new ViewModelProvider(this).get(VehicleFragmentViewModel.class);
        viewModel.getVehicleData().observe(getViewLifecycleOwner(), new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(List<Vehicle> vehicleList) {
                mVehicleAdapter = new VehicleAdapter(vehicleList, new VehicleListener());
                mRecyclerView.setAdapter(mVehicleAdapter);
            }
        });
    }

    private class VehicleListener implements VehicleAdapter.VehicleAdapterListener {
        @Override
        public void onVehicleSelected(Vehicle vehicle, View view) {
            // pending implementation
            // findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            // binding.navArg.text = "Here is the String : ${args.navArg}"
            Navigation.findNavController(view).navigate(VehiclesFragmentDirections
                    .actionVehiclesFragmentToVehicleDetailFragment(vehicle));
        }
    }
}