package com.groupec.architecturecomponent.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.groupec.architecturecomponent.models.Vehicle;

public class DetailFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Vehicle> selectedVehicle = new MutableLiveData<>();

    DetailFragmentViewModel(@NonNull Application application, Vehicle vehicle) {
        super(application);
        selectedVehicle.postValue(vehicle);
    }

    public MutableLiveData<Vehicle> getSelectedVehicle() {
        return selectedVehicle;
    }
}