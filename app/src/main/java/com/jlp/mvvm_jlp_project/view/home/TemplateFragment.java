package com.jlp.mvvm_jlp_project.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.jlp.mvvm_jlp_project.databinding.FragmentTemplateBinding;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.viewmodel.TemplateViewModel;

import dagger.hilt.android.AndroidEntryPoint;

/*TODO: This will be template fragment for future reference only, you can remove this at end of developtment,
   Component: Fragment, ViewModel, Layout Resource*/
@AndroidEntryPoint
public class TemplateFragment extends BaseFragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private @NonNull
    FragmentTemplateBinding binding;
    //TempFragmentMotionBinding binding;
    private TemplateViewModel templateViewModel;

    public TemplateFragment() {

    }

    public static TemplateFragment newInstance(String param1, String param2) {
        TemplateFragment fragment = new TemplateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPageParam();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        templateViewModel = new ViewModelProvider(this).get(TemplateViewModel.class);

        initObserver(view);
        initListener();
    }


    private void initPageParam() {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void initObserver(View view) {

    }


    private void initListener() {

        //binding.homeTopheader.imgClose.setOnClickListener(this);
    }


    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTemplateBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}

