package com.jlp.mvvm_jlp_project.view.base;/*
 * Created by Sandeep(Techno Learning) on 18,June,2022
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jlp.mvvm_jlp_project.utils.Utils;

public abstract class BaseFragment extends Fragment {
    protected abstract View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initViewBinding(inflater, container, savedInstanceState);
    }

    public boolean isNetworkConnected() {
        return Utils.isInternetAvailable(getActivity());
    }

}
