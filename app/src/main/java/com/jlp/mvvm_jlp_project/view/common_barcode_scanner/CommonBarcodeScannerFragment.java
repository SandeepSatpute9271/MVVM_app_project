package com.jlp.mvvm_jlp_project.view.common_barcode_scanner;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.FragmentCommonBarcodeScannerBinding;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestBodyFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestDataFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestBodyFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestDataFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestBodyFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestDataFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.DeliveryItemProductDetails;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseDataFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.DeliveryItemDetails;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.ResponseDataFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.LocationDetails;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseDataFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.auth.LoginFragment;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.view.carrier_handover_details.CarrierHandoverDetailsFragment;
import com.jlp.mvvm_jlp_project.viewmodel.CommonBarCodeLocationScannerViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * This Fragment is common for Item enquiry, Item Movement, Multi Movement and Carrier Handover details
 * depends on callfor Attribute making decision that for which fragment is call
 */
@AndroidEntryPoint
public class CommonBarcodeScannerFragment extends BaseFragment {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private ProgressDialog progressDialog;
    private FragmentCommonBarcodeScannerBinding binding;
    private CommonBarCodeLocationScannerViewModel viewModel;
    private String callFor;

    public static DeliveryItemProductDetails deliveryItemProductDetails;
    public static LocationDetails locationDetails;
    public static DeliveryItemDetails deliveryItemDetails;

    @Inject
    RequestEnvelopeFindDeliveryDetailsForComponentBarcode requestEnvelopeComponentBarcode;
    @Inject
    RequestBodyFindDeliveryDetailsForComponentBarcode requestBodyComponentBarcode;
    @Inject
    RequestDataFindDeliveryDetailsForComponentBarcode requestDataComponentBarcode;

    @Inject
    RequestEnvelopeFindLocationDetailsForBarcode requestEnvelopeLocationBarcode;
    @Inject
    RequestBodyFindLocationDetailsForBarcode requestBodyLocationBarcode;
    @Inject
    RequestDataFindLocationDetailsForBarcode requestDataLocationBarcode;

    @Inject
    RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode requestEnvelopeItemDetailsComponentBarcode;
    @Inject
    RequestBodyFindDeliveryItemDetailsForComponentBarcode requestBodyItemDetailsComponentBarcode;
    @Inject
    RequestDataFindDeliveryItemDetailsForComponentBarcode requestDataItemDetailsComponentBarcode;

    public static String actionBarTitle;
    public static boolean locationLayoutFlag;

    public CommonBarcodeScannerFragment(String callFor) {
        this.callFor = callFor;
    }

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommonBarcodeScannerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CommonBarCodeLocationScannerViewModel.class);
        updateActionbarTitle();
        initObserver();
        initListener();
    }

    /**
     * This function helps to update the title of actionbar as it is common for multiple features
     */
    private void updateActionbarTitle() {
        locationLayoutFlag = false;
            switch (callFor){
                case AppConstants.FRAGMENT_ITEM_ENQUIRY:{
                    actionBarTitle = getResources().getString(R.string.item_enquiry_title);
                    break;
                }
                case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE:{
                    actionBarTitle = getResources().getString(R.string.item_movement_title);
                    break;
                }
                case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE:{
                    actionBarTitle = getResources().getString(R.string.item_movement_title);
                    setLocationBarcodeFragmentTextTitles();
                    break;
                }
                case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE:{
                    actionBarTitle = getResources().getString(R.string.multi_movement_title);
                    setComponentBarcodeFragmentTextTitles();
                    locationLayoutFlag = true;
                    break;
                }
                case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE:{
                    actionBarTitle = getResources().getString(R.string.multi_movement_title);
                    setLocationBarcodeFragmentTextTitles();
                    locationLayoutFlag = true;
                    break;
                }
                case AppConstants.FRAGMENT_HAND_OVER_DELIVERY_DETAILS:{
                    actionBarTitle = getResources().getString(R.string.handover_delivery_title);
                    setDeliveryBarcodeFragmentTextTitles();
                    break;
                }
                case AppConstants.FRAGMENT_CARRIER_COLLECTION_DETAILS:{
                    actionBarTitle = getResources().getString(R.string.carrier_collection_details);
                    break;
                }
            }
            if(locationLayoutFlag){
                binding.scanNextItemBarcode.scanItemBarcode.setVisibility(View.VISIBLE);
            }else{
                binding.scanNextItemBarcode.scanItemBarcode.setVisibility(View.INVISIBLE);
            }
            binding.actionbar.txtToolbarTitle.setText(actionBarTitle);
    }

    /**
     * This methos initializes the click listener of next button once the barcode scans
     */
    private void initListener() {
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.hideKeyboard(getActivity(), view);
                viewModel.validateBarcode(
                        binding.itemEnquiryInputField.inputBarcode.getText().toString().trim());
            }
        });
    }

    /**
     * This function helps to deal with header which is bottom to actionbar
     * For Multi Movement feature we have to show the layout and location name
     * @param locationDetails shown location name from this object
     */
    private void updateLocationLayout(LocationDetails locationDetails) {
        binding.scanNextItemBarcode.scanItemBarcode.setVisibility(View.VISIBLE);
        binding.scanNextItemBarcode.imgNextScan.setVisibility(View.INVISIBLE);
        binding.scanNextItemBarcode.tvScanNextBarcode.setVisibility(View.GONE);
        binding.scanNextItemBarcode.tvSelectedLocation.setVisibility(View.VISIBLE);
        binding.scanNextItemBarcode.tvSelectedLocation.setText(getResources().getString(R.string.selected_location)+": "+locationDetails.name15);
    }

    /**
     * Identify the coll type and made the respective api call
     * for location or components
     * @param barcode input param for api call
     */
    private void findDetailsOfScannedBarcode(String barcode) {
        switch (callFor){
            case AppConstants.FRAGMENT_ITEM_ENQUIRY:
            case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE: {
                findDeliveryDetailsForComponentBarcode(barcode);
                break;
            }
            case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE:{
                findDeliveryItemDetailsForComponentBarcode(barcode);
                break;
            }
            case AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE:
            case AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_LOCATION_BARCODE:{
                findLocationDetailsForBarcode(barcode);
                break;
            }
            case AppConstants.FRAGMENT_HAND_OVER_DELIVERY_DETAILS:{
                replaceFragment(new CarrierHandoverDetailsFragment());
                break;
            }
        }
    }

    /**
     * Updated the barcode title text and hint as per the location barcode
     */
    private void setLocationBarcodeFragmentTextTitles() {
        binding.itemEnquiryInputField.inputBarcode.setHint(getResources().getString(R.string.enter_location_barcode_number));
        binding.itemEnquiryInputField.textTitle.setText(getResources().getString(R.string.enter_location_barcode_number_or_scan));
    }

    /**
     * Updated the barcode title text and hint as per the component barcode
     */
    private void setComponentBarcodeFragmentTextTitles() {
        binding.itemEnquiryInputField.inputBarcode.setHint(getResources().getString(R.string.enter_barcode_number));
        binding.itemEnquiryInputField.textTitle.setText(getResources().getString(R.string.enter_item_barcode_number));
    }

    /**
     * Updated the barcode title text and hint as per the delivery barcode
     */
    private void setDeliveryBarcodeFragmentTextTitles() {
        binding.itemEnquiryInputField.inputBarcode.setHint(getResources().getString(R.string.enter_delivery_barcode_number_or_scan));
        binding.itemEnquiryInputField.textTitle.setText(getResources().getString(R.string.enter_delivery_barcode_number));
    }

    /**
     * Prepared Data set for api done actual call from view to view model
     * Api call for component barcode
     * @param barcode
     */
    private void findDeliveryDetailsForComponentBarcode(String barcode) {
        prepareRequestDataForFindDeliveryDetailsForComponentBarcode(barcode);
        viewModel.findDeliveryDetailsForComponentBarcode(requestEnvelopeComponentBarcode);
    }

    /**
     * Prepared Data set for api call component barcode
     * @param barcode
     */
    private void prepareRequestDataForFindDeliveryDetailsForComponentBarcode(String barcode) {
        requestDataComponentBarcode.setBarcode(barcode);
        requestBodyComponentBarcode.setRequestDataFindDeliveryDetailsForComponentBarcode(requestDataComponentBarcode);
        requestEnvelopeComponentBarcode.setRequestBodyFindDeliveryDetailsForComponentBarcode(requestBodyComponentBarcode);
    }

    /**
     * Prepared Data set for api done actual call from view to view model
     * Api call for component barcode
     * @param barcode
     */
    private void findDeliveryItemDetailsForComponentBarcode(String barcode) {
        prepareRequestDataForFindDeliveryItemDetailsForComponentBarcode(barcode);
        viewModel.findDeliveryItemDetailsForComponentBarcode(requestEnvelopeItemDetailsComponentBarcode);
    }

    /**
     * Prepared Data set for api call component barcode
     * @param barcode
     */
    private void prepareRequestDataForFindDeliveryItemDetailsForComponentBarcode(String barcode) {
        requestDataItemDetailsComponentBarcode.setBarcode(barcode);
        requestBodyItemDetailsComponentBarcode.setRequestDataFindDeliveryItemDetailsForComponentBarcode(requestDataItemDetailsComponentBarcode);
        requestEnvelopeItemDetailsComponentBarcode.setRequestBodyFindDeliveryItemDetailsForComponentBarcode(requestBodyItemDetailsComponentBarcode);
    }

    /**
     * Prepared Data set for api done actual call from view to view model
     * Api call for location barcode
     * @param barcode
     */
    private void findLocationDetailsForBarcode(String barcode) {
        prepareRequestDataForFindLocationDetailsForBarcode(barcode);
        viewModel.findLocationDetailsForBarcode(requestEnvelopeLocationBarcode);
    }

    /**
     * Prepared Data set for api call location barcode
     * @param barcode
     */
    private void prepareRequestDataForFindLocationDetailsForBarcode(String barcode) {
        requestDataLocationBarcode.setBarcode(barcode);
        requestBodyLocationBarcode.setRequestDataFindLocationDetailsForBarcode(requestDataLocationBarcode);
        requestEnvelopeLocationBarcode.setRequestBodyFindLocationDetailsForBarcode(requestBodyLocationBarcode);
    }

    /**
     * setup all the observer of app for api call and validations
     */
    private void initObserver() {

        viewModel.validationResult.observe(getViewLifecycleOwner(), new Observer<Pair<Boolean, Integer>>() {
            @Override
            public void onChanged(Pair<Boolean, Integer> validationResult) {
                if(validationResult.first){
                    findDetailsOfScannedBarcode(binding.itemEnquiryInputField.inputBarcode.getText().toString().trim());
                }else{
                    Utils.showErrorMessage(getActivity(), getResources().getString(validationResult.second));
                }
            }
        });

        viewModel.responseFindDeliveryDetailsForComponentBarcode.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataFindDeliveryDetailsForComponentBarcode>>() {
            @Override
            public void onChanged(Resource<ResponseDataFindDeliveryDetailsForComponentBarcode> response) {
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
                            deliveryItemProductDetails = response.data.getDeliveryItemProductDetails();
                            replaceFragment(new CommonBarcodeScannerDetailsFragment(callFor));
                            break;
                        }
                    }
                }
            }
        });

        viewModel.responseFindLocationDetailsForBarcode.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataFindLocationDetailsForBarcode>>() {
            @Override
            public void onChanged(Resource<ResponseDataFindLocationDetailsForBarcode> response) {
                if(response.status != null){
                    switch (response.status){
                        case LOADING: {
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
                            locationDetails = response.data.getLocationDetails();
                            if(callFor.equals(AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE)){
                                updateLocationLayout(locationDetails);
                                setComponentBarcodeFragmentTextTitles();
                                callFor = AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_COMPONENT_BARCODE;
                            }else{
                                replaceFragment(new CommonBarcodeScannerDetailsFragment(callFor));
                            }
                            break;
                        }
                    }
                }
            }
        });

        viewModel.responseFindDeliveryItemDetailsForComponentBarcode.observe(getViewLifecycleOwner(), new Observer<Resource<ResponseDataFindDeliveryItemDetailsForComponentBarcode>>() {
            @Override
            public void onChanged(Resource<ResponseDataFindDeliveryItemDetailsForComponentBarcode> response) {
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
                            deliveryItemDetails = response.data.getDeliveryItemDetails();
                            replaceFragment(new CommonBarcodeScannerDetailsFragment(callFor));
                            break;
                        }
                    }
                }
            }
        });

    }

    /**
     * Clear view on success api call
     */
    private void clearViews() {
        binding.itemEnquiryInputField.inputBarcode.setText("");
    }


    /*private void setBundleDataAndReplaceFragment(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstants.COMPONENT_BARCODE_DETAILS_DATA, deliveryItemProductDetails);
        bundle.putParcelable(AppConstants.LOCATION_BARCODE_DETAILS_DATA, locationDetails);
        fragment.setArguments(bundle);
        replaceFragment(fragment);
    }*/

    // TODO: NavController we have to use for this
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_main, fragment); //main_fragment_container
        transaction.addToBackStack(TAG);
        transaction.commit();
    }
}