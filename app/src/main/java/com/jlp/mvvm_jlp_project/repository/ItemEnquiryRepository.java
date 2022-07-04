package com.jlp.mvvm_jlp_project.repository;/*
 * Created by Sandeep(Techno Learning) on 21,June,2022
 */

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.api.ApiService;
import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.request.change_password.RequestEnvelopeChangePassword;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseDataAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.response.change_password.ResponseDataChangePassword;
import com.jlp.mvvm_jlp_project.model.response.change_password.ResponseEnvelopeChangePassword;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseDataFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseDataFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.view.auth.LoginFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemEnquiryRepository {
    private static final String TAG = LoginFragment.class.getSimpleName();
    private final ApiService apiService;
    public MutableLiveData<Resource<ResponseDataFindDeliveryDetailsForComponentBarcode>> _responseFindDeliveryDetailsForComponentBarcode = new MutableLiveData<>();

    @Inject public ItemEnquiryRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Api call for findDeliveryDetailsForComponentBarcode
     * @param envelope RequestEnvelopeFindLocationDetailsForBarcode
     */
    public void findDeliveryDetailsForComponentBarcode(RequestEnvelopeFindDeliveryDetailsForComponentBarcode envelope){
        _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.loading(null));
        Call<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> responseEnvelopeCall
                = apiService.findDeliveryDetailsForComponentBarcode(envelope);
        responseEnvelopeCall.enqueue(new Callback<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> call, Response<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> response) {
                handleFindLocationDetailsForBarcodeResponse(response);
            }
            @Override
            public void onFailure(Call<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> call, Throwable t) {
                _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }

    /**
     * handled find location details for barcode response and did some validation on response
     * @param response ResponseEnvelopeFindLocationDetailsForBarcode to manipulate the error data
     */
    private void handleFindLocationDetailsForBarcodeResponse(Response<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> response){
        try {
            if(response.isSuccessful() && response.body()!=null &&
                    response.body().getResponseBodyFindDeliveryDetailsForComponentBarcode().
                            getResponseDataFindDeliveryDetailsForComponentBarcode().getDitsErrors()==null) {
                _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.success(response.body().
                        getResponseBodyFindDeliveryDetailsForComponentBarcode().getResponseDataFindDeliveryDetailsForComponentBarcode()));
            }else if(response.errorBody()!=null){
                _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.error("Error while getting the response", null));
            }else if(response.body().getResponseBodyFindDeliveryDetailsForComponentBarcode().getResponseDataFindDeliveryDetailsForComponentBarcode().getDitsErrors()!=null){
                _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.error( response.body().getResponseBodyFindDeliveryDetailsForComponentBarcode().
                                getResponseDataFindDeliveryDetailsForComponentBarcode().getDitsErrors().getDitsError().getErrorType().getErrorMessage(),
                        response.body().getResponseBodyFindDeliveryDetailsForComponentBarcode().
                                getResponseDataFindDeliveryDetailsForComponentBarcode()));
            } else{
                _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.error("Something Went Wrong", null));
                Log.i(TAG ,"Response is neither success nor error");
            }
        }catch (Exception ex){
            _responseFindDeliveryDetailsForComponentBarcode.postValue(Resource.error("Something Went Wrong", null));
            Log.e(TAG ,"Error while handling the response : "+ex);
        }
    }
}