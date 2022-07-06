package com.jlp.mvvm_jlp_project.view.auth;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.FragmentLoginBinding;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.AuthenticationDetails;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestBodyAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestDataAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseDataAuthenticateUser;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.view.home.HomeActivity;
import com.jlp.mvvm_jlp_project.viewmodel.AuthViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private ProgressDialog progressDialog;

    private @NonNull
    FragmentLoginBinding binding;
    private AuthViewModel authViewModel;

    @Inject
    RequestEnvelopeAuthenticateUser envelopeAuthenticateUser;
    @Inject
    RequestBodyAuthenticateUser bodyAuthenticateUser;
    @Inject
    RequestDataAuthenticateUser requestDataAuthenticateUser;
    @Inject
    AuthenticationDetails authenticationDetails;

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        initObserver();
        initListener();
    }

    private void initListener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.hideKeyboard(getActivity(), view);
                if(isNetworkConnected()){
                    authViewModel.validateLogin(
                            binding.layoutUsername.inputUsername.getText().toString().trim(),
                            binding.layoutPassword.inputPassword.getText().toString().trim());
                }else{
                    Utils.showErrorMessage(getActivity(), getResources().getString(R.string.please_check_internet_connection));
                }
            }
        });
    }

    /**
     * Internet check and actual api call
     * @param userId
     * @param password
     */
    private void authenticateUser(String userId, String password) {
        if (Utils.isInternetAvailable(getContext())){
            prepareRequestData(userId, password);
            authViewModel.authenticateUser(envelopeAuthenticateUser);
        }else{
            Utils.showErrorMessage(getActivity(), getResources().getString(R.string.please_check_internet_connection));
        }
    }

    /**
     * Preparing request data envelope, body, data for soap login api
     * @param userId input userid
     * @param password input password
     */
    private void prepareRequestData(String userId, String password) {
        authenticationDetails.setUserId(userId);
        authenticationDetails.setPassword(password);
        requestDataAuthenticateUser.setAuthenticationDetails(authenticationDetails);
        bodyAuthenticateUser.setRequestDataAuthenticateUser(requestDataAuthenticateUser);
        envelopeAuthenticateUser.setRequestBodyAuthenticateUser(bodyAuthenticateUser);
    }

    /**
     * Added here observer for validation and api call response
     */
    private void initObserver() {
        authViewModel.validationResult.observe(getViewLifecycleOwner(), new Observer<Pair<Boolean, Integer>>() {
            @Override
            public void onChanged(Pair<Boolean, Integer> validationResult) {
                if(validationResult.first){
                    authenticateUser(binding.layoutUsername.inputUsername.getText().toString().trim(),
                            binding.layoutPassword.inputPassword.getText().toString().trim());
                }else{
                    Utils.showErrorMessage(getActivity(), getResources().getString(validationResult.second));
                }
            }
        });

        authViewModel.responseAuthenticateUser.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataAuthenticateUser>>() {
            @Override
            public void onChanged(Resource<ResponseDataAuthenticateUser> response) {
                if(response.status != null){
                    switch (response.status){
                        case LOADING:{
                            progressDialog = Utils.showProgressBar(getContext());
                            break;
                        }

                        case ERROR:{
                            Utils.hideProgressDialog(progressDialog);
                            Utils.showErrorMessage(getActivity(), response.message);
                            break;
                        }

                        case SUCCESS:{
                            clearViews();
                            Utils.hideProgressDialog(progressDialog);
                            Helper.redirectToActivity(getActivity(), HomeActivity.class, true);
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * Clear text of all views when navigating to another screen
     */
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