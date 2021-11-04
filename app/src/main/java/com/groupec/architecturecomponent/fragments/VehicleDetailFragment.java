package com.groupec.architecturecomponent.fragments;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.groupec.architecturecomponent.R;
import com.groupec.architecturecomponent.ViewModel.DetailFragmentViewModel;
import com.groupec.architecturecomponent.ViewModel.DetailFragmentViewModelFactory;
import com.groupec.architecturecomponent.models.Vehicle;

public class VehicleDetailFragment extends Fragment {

    public  VehicleDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicle_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView vehicleImageView = view.findViewById(R.id.detail_vehicle_image_view);
        final TextView vehicleNameTextView = view.findViewById(R.id.detail_vehicle_name_text_view);

        Application application = requireActivity().getApplication();
        Vehicle vehicle = VehicleDetailFragmentArgs.fromBundle(requireArguments()).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new DetailFragmentViewModelFactory(application, vehicle);
        DetailFragmentViewModel viewModel = new ViewModelProvider(this, factory).get(DetailFragmentViewModel.class);

        viewModel.getSelectedVehicle().observe(getViewLifecycleOwner(), new Observer<Vehicle>() {
            @Override
            public void onChanged(Vehicle vehicle) {
                vehicleImageView.setImageResource(vehicle.getVehicleImage());
                vehicleNameTextView.setText(vehicle.getVehicleName());
            }
        });
    }
}