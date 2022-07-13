package com.jlp.mvvm_jlp_project.viewmodel;/*
 * Created by Sandeep(Techno Learning) on 18,June,2022
 */

import android.text.TextUtils;
import android.util.Pair;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.request.change_password.RequestEnvelopeChangePassword;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseDataAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.response.change_password.ResponseDataChangePassword;
import com.jlp.mvvm_jlp_project.repository.UserRepository;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.StringUtils;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AuthViewModel extends BaseViewModel {
    UserRepository repository;
    public MutableLiveData<Pair<Boolean, Integer>> validationResult = new MutableLiveData<>();
    public MutableLiveData<Resource<ResponseDataChangePassword>> responseDataChangePassword;
    public MutableLiveData<Resource<ResponseDataAuthenticateUser>> responseAuthenticateUser;

    @Inject
    public AuthViewModel(UserRepository repository){
        this.repository = repository;
        responseDataChangePassword = repository._responseDataChangePassword;
        responseAuthenticateUser = repository._responseAuthenticateUser;
    }

    public void validateLogin(String username, String password) {
        Pair result = new Pair<> (true, 0);
        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
            result = new Pair(false, R.string.please_enter_user_id_and_password);
        }else if(TextUtils.isEmpty(username)){
            result = new Pair(false, R.string.please_enter_user_id);
        }else if(TextUtils.isEmpty(password)){
            result = new Pair(false, R.string.please_enter_password);
        }else if(password.length() < AppConstants.MIN_PASSWORD_LENGTH || password.length() > AppConstants.MAX_PASSWORD_LENGTH){
            result = new Pair(false, R.string.password_should_be);
        }
        validationResult.setValue(result);
    }

    public void validateChangePassword(String username, String oldPassword,
                                       String newPassword, String confirmPassword) {
        Pair result = new Pair<> (true, 0);
        if(TextUtils.isEmpty(oldPassword)){
            result = new Pair(false, R.string.please_enter_old_password);
        }else if(TextUtils.isEmpty(newPassword) && TextUtils.isEmpty(confirmPassword)){
            result = new Pair(false, R.string.please_enter_new_password_and_confirm);
        }else if(newPassword.length() < AppConstants.MIN_PASSWORD_LENGTH || newPassword.length() > AppConstants.MAX_PASSWORD_LENGTH){
            result = new Pair(false, R.string.new_password_should_be);
        }else if(StringUtils.isValidPassword(newPassword)){
            result = new Pair(false, R.string.at_least_one_alpha_one_num_req);
        }else if(!newPassword.equals(confirmPassword)){
            result = new Pair(false, R.string.new_password_and_confirm_password_mismatch);
        }
        validationResult.setValue(result);
    }

    public void authenticateUser(RequestEnvelopeAuthenticateUser envelope){
        repository.authenticateUser(envelope);
    }

    public void changePassword(RequestEnvelopeChangePassword envelope){
        repository.changePassword(envelope);
    }
}
