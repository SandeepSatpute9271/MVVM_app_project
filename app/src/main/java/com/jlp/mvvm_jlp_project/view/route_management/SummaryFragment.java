package com.jlp.mvvm_jlp_project.view.route_management;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jlp.mvvm_jlp_project.databinding.FragmentSummaryBinding;
import com.jlp.mvvm_jlp_project.model.RouteSummary;
import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestBodyRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestDataRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestEnvelopRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.response.route_management_summary.ResponseDataRouteManagementSummary;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.viewmodel.SummaryViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SummaryFragment extends BaseFragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private @NonNull
    FragmentSummaryBinding binding;
    private SummaryViewModel summaryViewModel;
    private ProgressDialog progressDialog;
    private RouteSummary summary;


    @Inject
    RequestEnvelopRouteManagementSummary requestEnvelop;

    @Inject
    RequestBodyRouteManagementSummary requestBody;

    @Inject
    RequestDataRouteManagementSummary requestData;

    public SummaryFragment() {

    }

    public static SummaryFragment newInstance(String param1, String param2) {
        SummaryFragment fragment = new SummaryFragment();
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
        summaryViewModel = new ViewModelProvider(this).get(SummaryViewModel.class);

        initObserver(view);
        initListener();

        findSummaryDetails("R38AM20080913T2");
    }


    private void initPageParam() {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private void findSummaryDetails(String routeId) {
        prepareEnvelopSummaryDetails(routeId);
        summaryViewModel.findSummaryDetails(requestEnvelop);
    }


    /**
     * Prepared Data set for api call RouteSummary
     *
     * @param routeId
     */
    private void prepareEnvelopSummaryDetails(String routeId) {
        requestData.setRouteId(routeId);
        requestBody.setRequestDataRouteManagementSummary(requestData);
        requestEnvelop.setRequestBodyRouteManagementSummary(requestBody);
    }


    private void initObserver(View view) {

        summaryViewModel.responseSummaryDetails.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataRouteManagementSummary>>() {
            @Override
            public void onChanged(Resource<ResponseDataRouteManagementSummary> response) {
                if (response.status != null) {
                    switch (response.status) {
                        case LOADING: {
                            progressDialog = Utils.showProgressBar(getContext());
                            break;
                        }
                        case ERROR: {
                            Utils.hideProgressDialog(progressDialog);
                            //Log.e("errorSummary",""+response.message);
                            Utils.showErrorMessage(getActivity(), response.message);
                            break;
                        }
                        case SUCCESS: {

                            Utils.hideProgressDialog(progressDialog);
                            summary = response.data.getRouteSummary();
                            updateSummaryOnView();
                            break;
                        }
                    }
                }
            }
        });


    }

    public void updateSummaryOnView() {
        // Header
        binding.layoutSummaryInclHeader.txtRouteNumberValue.setText("" + summary.getRouteNumber());
        binding.layoutSummaryInclHeader.txtDeliveryDateValue.setText("" + summary.getDeliveryDate());

        // Summary
        binding.layoutSummaryIncl.txTotalDeliveriesValue.setText("" + summary.getTotalNumberOfDeliveriesCount());//summary.getTotalDeliveries()
        binding.layoutSummaryIncl.txTotalLotsValue.setText("" + summary.getTotalLots());
        binding.layoutSummaryIncl.txTotalLotsLoadedValue.setText("" + summary.getDeliveryLotsLoaded());
    }


    private void initListener() {
        //binding.homeTopheader.imgClose.setOnClickListener(this);

    }


    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSummaryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }
}
