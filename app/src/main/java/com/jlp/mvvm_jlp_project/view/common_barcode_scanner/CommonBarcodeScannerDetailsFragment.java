package com.jlp.mvvm_jlp_project.view.common_barcode_scanner;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.adapters.CommonBarcodeScannerAdapter;
import com.jlp.mvvm_jlp_project.databinding.FragmentCommonBarcodeScannerDetailsBinding;
import com.jlp.mvvm_jlp_project.model.ItemEnquiryModel;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.LocationItemDetails;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestBodyRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestDataRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.DeliveryItemProductDetails;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.DeliveryItemDetails;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.LocationDetails;
import com.jlp.mvvm_jlp_project.model.response.record_location_of_item.ResponseDataRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.auth.LoginFragment;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.viewmodel.CommonBarCodeLocationScannerViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CommonBarcodeScannerDetailsFragment extends BaseFragment{
    private static final String TAG = LoginFragment.class.getSimpleName();
    private ProgressDialog progressDialog;
    private DeliveryItemProductDetails deliveryItemProductDetails = CommonBarcodeScannerFragment.deliveryItemProductDetails;
    private LocationDetails locationDetails = CommonBarcodeScannerFragment.locationDetails;
    private DeliveryItemDetails deliveryItemDetails = CommonBarcodeScannerFragment.deliveryItemDetails;
    private FragmentCommonBarcodeScannerDetailsBinding binding;
    private CommonBarCodeLocationScannerViewModel viewModel;
    private String callFor;
    // Used for adapter and list to setup
    private CommonBarcodeScannerAdapter adapter;
    private List<ItemEnquiryModel> detailsDataList =  new ArrayList<>();

    @Inject
    RequestEnvelopeRecordLocationOfItem requestEnvelopeRecordLocation;
    @Inject
    RequestBodyRecordLocationOfItem requestBodyRecordLocation;
    @Inject
    RequestDataRecordLocationOfItem requestDataRecordLocation;
    @Inject
    LocationItemDetails locationItemDetails;


    public CommonBarcodeScannerDetailsFragment(String callFor) {
        this.callFor = callFor;
    }

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommonBarcodeScannerDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CommonBarCodeLocationScannerViewModel.class);
        updateActionbarTitleAndLocationLayout();
        initListener();
        initObserver();
        recordLocationOfItem(deliveryItemProductDetails, locationDetails);
        initListAndRecyclerView();
        setupAdapter();
    }

    /**
     * Prepare the data list for recycler view depending on fragment from which it calls
     */
    private void initListAndRecyclerView() {
        switch (callFor){
            case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE:
            case AppConstants.FRAGMENT_ITEM_ENQUIRY:{
                viewModel.getComponentBarcodeData(deliveryItemProductDetails);
                break;
            }
            case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE:{
                viewModel.getItemDetailsComponentBarcodeData(deliveryItemDetails);
                break;
            }
            case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE:
            case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE:{
                viewModel.getLocationBarcodeData(deliveryItemProductDetails, locationDetails);
                break;
            }
        }
    }

    /**
     * Set up the adapter and set the data for list items
     */
    private void setupAdapter(){
        if(detailsDataList!=null){
            adapter = new CommonBarcodeScannerAdapter(detailsDataList, getContext());
            binding.recyclerView.setAdapter(adapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }else{
            Utils.showErrorMessage(getActivity(), "Unable to get the data");
        }
    }

    /**
     * Initialization of next button click listener and handle as per the fragment from which it calling
     */
    private void initListener() {
        binding.scanNextItemBarcode.imgNextScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (callFor){
                    case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE:{
                        replaceFragment(new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE));
                        break;
                    }
                    case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE:{
                        replaceFragment(new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE));
                        break;
                    }
                    case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE:
                    case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE:{
                        replaceFragment(new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE));
                        break;
                    }
                    default:{
                        replaceFragment(new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_ITEM_ENQUIRY));
                        break;
                    }
                }
            }
        });
    }

    /**
     * Actual API call for record location of item  from view depending on the condition from which this fragment is calling
     * @param deliveryItemProductDetails to make the request for api call
     * @param locationDetails to make the request for api call
     */
    private void recordLocationOfItem(DeliveryItemProductDetails deliveryItemProductDetails,
                                      LocationDetails locationDetails){
        if(callFor.equals(AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE)
        || callFor.equals(AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE)
        || callFor.equals(AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE)){
            prepareRequestDataForRecordLocationOfItem(deliveryItemProductDetails, locationDetails);
            viewModel.recordLocationOfItem(requestEnvelopeRecordLocation);
        }
    }

    /**
     * Preparing the request envelope, body, data for api call for record location of item
     * @param deliveryItemProductDetails
     * @param locationDetails
     */
    private void prepareRequestDataForRecordLocationOfItem(DeliveryItemProductDetails deliveryItemProductDetails,
                                                           LocationDetails locationDetails) {
        if(deliveryItemProductDetails!=null && locationDetails!=null){
            //TODO: get user id and username from SP
            locationItemDetails.setUserId("UserId");
            locationItemDetails.setUserName("UserName");
            locationItemDetails.setLocationId(locationDetails.getLocationId());
            locationItemDetails.setName15(locationDetails.getName15());
            locationItemDetails.setProductCode(deliveryItemProductDetails.getProductCode());
            locationItemDetails.setDeliveryId(deliveryItemProductDetails.getDeliveryId());
            locationItemDetails.setComponentId(deliveryItemProductDetails.getComponentId());
        }
        requestDataRecordLocation.setLocationItemDetails(locationItemDetails);
        requestBodyRecordLocation.setRequestDataRecordLocationOfItem(requestDataRecordLocation);
        requestEnvelopeRecordLocation.setRequestBodyRecordLocationOfItem(requestBodyRecordLocation);
    }

    /**
     * Set actionbar title and update location layout items if call is for multi movement feature
     * @param locationDetails shown location name from this object
     */
    private void updateActionbarTitleAndLocationLayout() {
        binding.itemEnquiryHeader.txtToolbarTitle.setText(CommonBarcodeScannerFragment.actionBarTitle);
        if(CommonBarcodeScannerFragment.locationLayoutFlag){
            updateLocationLayout(locationDetails);
        }
    }

    /**
     * setup all the observer of app for api call and adapter list data
     */
    private void initObserver() {
        viewModel.responseDataRecordLocationOfItem.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataRecordLocationOfItem>>() {
            @Override
            public void onChanged(Resource<ResponseDataRecordLocationOfItem> response) {
                if(response.status != null){
                    switch (response.status){
                        case LOADING: {
                            progressDialog = Utils.showProgressBar(getContext());
                            break;
                        }
                        case ERROR:{
                            Utils.hideProgressDialog(progressDialog);
                            Utils.showErrorMessage(getActivity(), getResources().getString(R.string.update_has_failed)+"\n"+response.message);
                            break;
                        }
                        case SUCCESS:{
                            Utils.hideProgressDialog(progressDialog);
                            viewModel.updateAdapterData(response.data.locationItemDetails, locationDetails);
                            break;
                        }
                    }
                }
            }
        });

        viewModel.itemEnquiry.observe(getViewLifecycleOwner(), new Observer<List<ItemEnquiryModel>>() {
            @Override
            public void onChanged(List<ItemEnquiryModel> itemEnquiryModels) {
                detailsDataList.addAll(itemEnquiryModels);
                adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * This function helps to deal with header which is bottom to actionbar
     * For Multi Movement feature location layout and location name shown
     * @param locationDetails shown location name from this object
     */
    private void updateLocationLayout(LocationDetails locationDetails) {
        binding.scanNextItemBarcode.tvSelectedLocation.setVisibility(View.VISIBLE);
        binding.scanNextItemBarcode.tvSelectedLocation.setText(getResources().getString(R.string.selected_location)+": "+locationDetails.name15);
    }

    // TODO: NavController we have to use for this
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_main, fragment);
        transaction.addToBackStack(TAG);
        transaction.commit();
    }
}