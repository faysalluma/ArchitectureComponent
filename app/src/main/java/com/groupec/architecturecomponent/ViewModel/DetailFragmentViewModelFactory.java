package com.groupec.architecturecomponent.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.groupec.architecturecomponent.models.Vehicle;


// This factory will provide us instance for the ViewModel.
public class DetailFragmentViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private Vehicle mVehicle;

    public DetailFragmentViewModelFactory(Application application, Vehicle vehicle) {
        this.mApplication = application;
        this.mVehicle = vehicle;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailFragmentViewModel.class)) {
            return (T) new DetailFragmentViewModel(mApplication, mVehicle);
        }
        throw new IllegalArgumentException("Cannot create Instance for this class");
    }
}
