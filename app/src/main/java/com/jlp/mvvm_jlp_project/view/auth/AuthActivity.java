package com.jlp.mvvm_jlp_project.view.auth;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.ActivityAuthBinding;
import com.jlp.mvvm_jlp_project.databinding.ActivityHomeBinding;
import com.jlp.mvvm_jlp_project.view.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AuthActivity extends BaseActivity {

    private ActivityAuthBinding binding;

    @Override
    protected void initViewBinding() {
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null)getSupportActionBar().hide();
    }
}