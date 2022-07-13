package com.jlp.mvvm_jlp_project.repository;/*
 * Created by Sandeep(Techno Learning) on 21,June,2022
 */

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.api.ApiService;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseDataFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.ResponseDataFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseDataFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.record_location_of_item.ResponseDataRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.response.record_location_of_item.ResponseEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.utils.Resource;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CommonBarcodeScannerRepository {
    private static final String TAG = CommonBarcodeScannerRepository.class.getSimpleName();
    private final ApiService apiService;
    public MutableLiveData<Resource<ResponseDataFindDeliveryDetailsForComponentBarcode>> _responseFindDeliveryDetailsForComponentBarcode = new MutableLiveData<>();
    public MutableLiveData<Resource<ResponseDataFindLocationDetailsForBarcode>> _responseFindLocationDetailsForBarcode = new MutableLiveData<>();
    public MutableLiveData<Resource<ResponseDataRecordLocationOfItem>> _responseDataRecordLocationOfItem = new MutableLiveData<>();
    public MutableLiveData<Resource<ResponseDataFindDeliveryItemDetailsForComponentBarcode>> _responseFindDeliveryItemDetailsForComponentBarcode = new MutableLiveData<>();


    @Inject public CommonBarcodeScannerRepository(ApiService apiService) {
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
                handleFindDeliveryDetailsForComponentBarcode(response);
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
    private void handleFindDeliveryDetailsForComponentBarcode(Response<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> response){
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


    /**
     * Api call for findDeliveryItemDetailsForComponentBarcode
     * @param envelope RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode
     */
    public void findDeliveryItemDetailsForComponentBarcode(RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode envelope){
        _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.loading(null));
        Call<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> responseEnvelopeCall
                = apiService.findDeliveryItemDetailsForComponentBarcode(envelope);
        responseEnvelopeCall.enqueue(new Callback<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> call, Response<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> response) {
                handleFindDeliveryItemDetailsForComponentBarcode(response);
            }
            @Override
            public void onFailure(Call<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> call, Throwable t) {
                _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }

    /**
     * handled find Delivery Item Details For Component Barcode response and did some validation on response
     * @param response ResponseEnvelopeFindDeliveryDetailsForComponentBarcode to manipulate the error data
     */
    private void handleFindDeliveryItemDetailsForComponentBarcode(Response<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> response){
        try {
            if(response.isSuccessful() && response.body()!=null &&
                    response.body().getResponseBodyFindDeliveryItemDetailsForComponentBarcode().
                            getResponseDataFindDeliveryItemDetailsForComponentBarcode().getDitsErrors()==null) {
                _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.success(response.body().
                        getResponseBodyFindDeliveryItemDetailsForComponentBarcode().getResponseDataFindDeliveryItemDetailsForComponentBarcode()));
            }else if(response.errorBody()!=null){
                _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.error("Error while getting the response", null));
            }else if(response.body().getResponseBodyFindDeliveryItemDetailsForComponentBarcode().getResponseDataFindDeliveryItemDetailsForComponentBarcode().getDitsErrors()!=null){
                _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.error( response.body().getResponseBodyFindDeliveryItemDetailsForComponentBarcode().
                                getResponseDataFindDeliveryItemDetailsForComponentBarcode().getDitsErrors().getDitsError().getErrorType().getErrorMessage(),
                        response.body().getResponseBodyFindDeliveryItemDetailsForComponentBarcode().
                                getResponseDataFindDeliveryItemDetailsForComponentBarcode()));
            } else{
                _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.error("Something Went Wrong", null));
                Log.i(TAG ,"Response is neither success nor error");
            }
        }catch (Exception ex){
            _responseFindDeliveryItemDetailsForComponentBarcode.postValue(Resource.error("Something Went Wrong", null));
            Log.e(TAG ,"Error while handling the response : "+ex);
        }
    }

    /**
     * Api call for findLocationDetailsForBarcode
     * @param envelope RequestEnvelopeFindLocationDetailsForBarcode
     */
    public void findLocationDetailsForBarcode(RequestEnvelopeFindLocationDetailsForBarcode envelope){
        _responseFindLocationDetailsForBarcode.postValue(Resource.loading(null));
        Call<ResponseEnvelopeFindLocationDetailsForBarcode> responseEnvelopeCall
                = apiService.findLocationDetailsForBarcode(envelope);
        responseEnvelopeCall.enqueue(new Callback<ResponseEnvelopeFindLocationDetailsForBarcode>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeFindLocationDetailsForBarcode> call, Response<ResponseEnvelopeFindLocationDetailsForBarcode> response) {
                handleFindLocationDetailsForBarcodeResponse(response);
            }
            @Override
            public void onFailure(Call<ResponseEnvelopeFindLocationDetailsForBarcode> call, Throwable t) {
                _responseFindLocationDetailsForBarcode.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }

    /**
     * handled find location details for barcode response and did some validation on response
     * @param response ResponseEnvelopeFindLocationDetailsForBarcode to manipulate the error data
     */
    private void handleFindLocationDetailsForBarcodeResponse(Response<ResponseEnvelopeFindLocationDetailsForBarcode> response){
        try {
            if(response.isSuccessful() && response.body()!=null &&
                    response.body().getFindLocationDetailsForBarcode().getResponseDataFindLocationDetailsForBarcode().getDitsErrors()==null) {
                _responseFindLocationDetailsForBarcode.postValue(Resource.success(response.body().getFindLocationDetailsForBarcode().getResponseDataFindLocationDetailsForBarcode()));
            }else if(response.errorBody()!=null){
                _responseFindLocationDetailsForBarcode.postValue(Resource.error("Error while getting the response", null));
            }else if(response.body().getFindLocationDetailsForBarcode().getResponseDataFindLocationDetailsForBarcode().getDitsErrors()!=null){
                _responseFindLocationDetailsForBarcode.postValue(Resource.error( response.body().getFindLocationDetailsForBarcode().getResponseDataFindLocationDetailsForBarcode().getDitsErrors().getDitsError().getErrorType().getErrorMessage(),
                        response.body().getFindLocationDetailsForBarcode().getResponseDataFindLocationDetailsForBarcode()));
            } else{
                _responseFindLocationDetailsForBarcode.postValue(Resource.error("Something Went Wrong", null));
                Log.i(TAG ,"Response is neither success nor error");
            }
        }catch (Exception ex){
            _responseFindLocationDetailsForBarcode.postValue(Resource.error("Something Went Wrong", null));
            Log.e(TAG ,"Error while handling the response : "+ex);
        }
    }



    /**
     * Api call for recordLocationOfItem
     * @param envelope RequestEnvelopeFindLocationDetailsForBarcode
     */
    public void recordLocationOfItem(RequestEnvelopeRecordLocationOfItem envelope){
        _responseDataRecordLocationOfItem.postValue(Resource.loading(null));
        Call<ResponseEnvelopeRecordLocationOfItem> responseEnvelopeCall
                = apiService.recordLocationOfItem(envelope);
        responseEnvelopeCall.enqueue(new Callback<ResponseEnvelopeRecordLocationOfItem>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeRecordLocationOfItem> call, Response<ResponseEnvelopeRecordLocationOfItem> response) {
                handleRecordLocationOfItemResponse(response);
            }
            @Override
            public void onFailure(Call<ResponseEnvelopeRecordLocationOfItem> call, Throwable t) {
                _responseDataRecordLocationOfItem.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }

    /**
     * handled Record Location Of Item  response and did some validation on response
     * @param response ResponseEnvelopeRecordLocationOfItem to manipulate the error data
     */
    private void handleRecordLocationOfItemResponse(Response<ResponseEnvelopeRecordLocationOfItem> response){
        try {
            if(response.isSuccessful() && response.body()!=null &&
                    response.body().getResponseBodyRecordLocationOfItem().getResponseDataRecordLocationOfItem().getDitsErrors()==null) {
                _responseDataRecordLocationOfItem.postValue(Resource.success(response.body().getResponseBodyRecordLocationOfItem().getResponseDataRecordLocationOfItem()));
            }else if(response.errorBody()!=null){
                _responseDataRecordLocationOfItem.postValue(Resource.error("Error while getting the response", null));
            }else if(response.body().getResponseBodyRecordLocationOfItem().getResponseDataRecordLocationOfItem().getDitsErrors()!=null){
                _responseDataRecordLocationOfItem.postValue(Resource.error( response.body().getResponseBodyRecordLocationOfItem().getResponseDataRecordLocationOfItem().getDitsErrors().getDitsError().getErrorType().getErrorMessage(),
                        response.body().getResponseBodyRecordLocationOfItem().getResponseDataRecordLocationOfItem()));
            } else{
                _responseDataRecordLocationOfItem.postValue(Resource.error("Something Went Wrong", null));
                Log.i(TAG ,"Response is neither success nor error");
            }
        }catch (Exception ex){
            _responseDataRecordLocationOfItem.postValue(Resource.error("Something Went Wrong", null));
            Log.e(TAG ,"Error while handling the response : "+ex);
        }
    }
}
