package com.jlp.mvvm_jlp_project.view.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.FragmentLoginBinding;
import com.jlp.mvvm_jlp_project.model.LoginUserRequestModel;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.view.home.MenuActivity;
import com.jlp.mvvm_jlp_project.viewmodel.AuthViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment {

    private @NonNull
    FragmentLoginBinding binding;
    private AuthViewModel authViewModel;

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        initObserver(view);
        initListener();
    }

    private void initListener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authViewModel.validateLogin(
                        binding.layoutUsername.inputUsername.getText().toString().trim(),
                        binding.layoutPassword.inputPassword.getText().toString().trim());
            }
        });
    }

    private void initObserver(View view) {
        authViewModel.validationResult.observe(getViewLifecycleOwner(), new Observer<Pair<Boolean, Integer>>() {
            @Override
            public void onChanged(Pair<Boolean, Integer> validationResult) {
                if(validationResult.first){
                    authViewModel.loginUser(new LoginUserRequestModel(
                            binding.layoutUsername.inputUsername.getText().toString().trim(),
                            binding.layoutPassword.inputPassword.getText().toString().trim()));
                    clearViews();
                    Helper.redirectToActivity(getActivity(), MenuActivity.class, false);
                }else{
                    showErrors(validationResult.second);
                }
            }
        });
    }

    private void showErrors(Integer errorStrId){
        Utils.showErrorMessage(getActivity(), getResources().getString(errorStrId));
    }

    private void clearViews(){
        binding.layoutUsername.inputUsername.setText("");
        binding.layoutPassword.inputPassword.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}