package com.jlp.mvvm_jlp_project.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.api.ApiService;
import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestEnvelopRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.response.route_management_summary.ResponseDataRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.response.route_management_summary.ResponseEnvelopeRouteManagementSummary;
import com.jlp.mvvm_jlp_project.utils.Resource;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RouteManagementSummaryRepository {
    private static final String TAG = RouteManagementSummaryRepository.class.getSimpleName();
    private final ApiService apiService;

    public MutableLiveData<Resource<ResponseDataRouteManagementSummary>> _responseSummary = new MutableLiveData<>();


    @Inject
    public RouteManagementSummaryRepository(ApiService apiService) {
        this.apiService = apiService;
    }


    /**
     * Api call for FindRouteManagementSummary
     *
     * @param envelope RequestEnvelopRouteManagementSummary
     */
    public void findRouteManagementSummary(RequestEnvelopRouteManagementSummary envelope) {
        _responseSummary.postValue(Resource.loading(null));

        Call<ResponseEnvelopeRouteManagementSummary> responseEnvelopeCall
                = apiService.summaryDetailsApi(envelope);
        responseEnvelopeCall.enqueue(new Callback<ResponseEnvelopeRouteManagementSummary>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeRouteManagementSummary> call, Response<ResponseEnvelopeRouteManagementSummary> response) {
                handleFindSummaryDetails(response);
            }

            @Override
            public void onFailure(Call<ResponseEnvelopeRouteManagementSummary> call, Throwable t) {
                _responseSummary.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }


    /**
     * handled find Summary details for Route management response and did some validation on response
     *
     * @param response ResponseEnvelopeRouteManagementSummary to manipulate the error data
     */
    private void handleFindSummaryDetails(Response<ResponseEnvelopeRouteManagementSummary> response) {
        try {
            if (response.isSuccessful() && response.body() != null &&
                    response.body().getResponseBodyRouteManagementSummary().
                            getResponseDataRouteManagementSummary().getDitsErrors() == null) {

                _responseSummary.postValue(Resource.success(response.body().
                        getResponseBodyRouteManagementSummary().getResponseDataRouteManagementSummary()));

            } else if (response.errorBody() != null) {

                _responseSummary.postValue(Resource.error("Error while getting the response", null));

            } else if (response.body().getResponseBodyRouteManagementSummary().getResponseDataRouteManagementSummary().getDitsErrors() != null) {

                _responseSummary.postValue(Resource.error(response.body().getResponseBodyRouteManagementSummary().
                                getResponseDataRouteManagementSummary().getDitsErrors().getDitsError().getErrorType().getErrorMessage(),
                        response.body().getResponseBodyRouteManagementSummary().
                                getResponseDataRouteManagementSummary()));

            } else {

                _responseSummary.postValue(Resource.error("Something Went Wrong", null));
                Log.i(TAG, "Response is neither success nor error");

            }
        } catch (Exception ex) {
            _responseSummary.postValue(Resource.error("Something Went Wrong", null));

            Log.e(TAG, "Error while handling the response : " + ex);

        }
    }


}
