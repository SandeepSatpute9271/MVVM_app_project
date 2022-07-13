package com.jlp.mvvm_jlp_project.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestEnvelopRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.response.route_management_summary.ResponseDataRouteManagementSummary;
import com.jlp.mvvm_jlp_project.repository.RouteManagementSummaryRepository;
import com.jlp.mvvm_jlp_project.utils.Resource;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SummaryViewModel extends BaseViewModel {

    RouteManagementSummaryRepository repository;

    public MutableLiveData<Resource<ResponseDataRouteManagementSummary>> responseSummaryDetails
            = new MutableLiveData<>();


    @Inject
    public SummaryViewModel(RouteManagementSummaryRepository repository) {
        this.repository = repository;
        this.responseSummaryDetails = repository._responseSummary;
    }


    public void findSummaryDetails(RequestEnvelopRouteManagementSummary envelope) {
        repository.findRouteManagementSummary(envelope);
    }


}
