package com.jlp.mvvm_jlp_project.viewmodel;/*
 * Created by Sandeep(Techno Learning) on 18,June,2022
 */

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class BaseViewModel extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}
