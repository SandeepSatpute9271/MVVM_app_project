package com.jlp.mvvm_jlp_project.view.carrier_handover_details;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.FragmentCarrierHandoverDetailsBinding;
import com.jlp.mvvm_jlp_project.model.ItemEnquiryModel;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.DeliveryItemProductDetails;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.view.auth.LoginFragment;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.viewmodel.CarrierHandoverDetailsViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CarrierHandoverDetailsFragment extends BaseFragment{
    private static final String TAG = LoginFragment.class.getSimpleName();
    private CarrierHandoverDetailsViewModel carrierHandoverDetailsViewModel;
    private FragmentCarrierHandoverDetailsBinding binding;

    public CarrierHandoverDetailsFragment() {}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carrierHandoverDetailsViewModel = new ViewModelProvider(this).get(CarrierHandoverDetailsViewModel.class);
        updateActionbarTitle();
        getParcelableData();
        initListener();
    }

    private void initListener() {
    }

    private void updateActionbarTitle() {
        binding.homeTopHeader.txtToolbarTitle.setText(getResources().getString(R.string.handover_delivery_title));
    }

    private void getParcelableData() {
        try {
            if (getArguments() != null) {
                Bundle bundle = this.getArguments();
                if (bundle != null) {
                    //componentBarcodeResponse = bundle.getParcelable(AppConstants.COMPONENT_BARCODE_DETAILS_DATA);
                    //locationBarcodeResponse = bundle.getParcelable(AppConstants.LOCATION_BARCODE_DETAILS_DATA);
                }
            }
        }catch (Exception ex){
            Log.e(TAG, "Exception: "+ex.getMessage());
        }
    }

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCarrierHandoverDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

//    public List<ItemEnquiryModel> getComponentBarcodeData(DeliveryItemProductDetails itemEnquiryDetailsData)
//    {
//        List<ItemEnquiryModel> list = new ArrayList<>();
//        list.add(new ItemEnquiryModel("Delivery Number",
//                itemEnquiryDetailsData.getDeliveryId()
//        ));
//        list.add(new ItemEnquiryModel("Route Number",
//                itemEnquiryDetailsData.getRouteResourceKey()
//        ));
//        list.add(new ItemEnquiryModel("Delivery Date",
//                itemEnquiryDetailsData.getDeliveryDate()));
//        list.add(new ItemEnquiryModel("Last Recorded Location",
//                itemEnquiryDetailsData.getDeliveryAddressPremise()));
//        list.add(new ItemEnquiryModel("Time of last move",
//                itemEnquiryDetailsData.getLastUpdatedTimeStamp()));
//        list.add(new ItemEnquiryModel("Last UserId",
//                itemEnquiryDetailsData.getLastUpdatedUserId()));
//        list.add(new ItemEnquiryModel("Product Code",
//                itemEnquiryDetailsData.getProductCode()));
//        list.add(new ItemEnquiryModel("Product description",
//                itemEnquiryDetailsData.getOrderDescriptionClean()));
//        list.add(new ItemEnquiryModel("Lot Number",
//                itemEnquiryDetailsData.getCurrentLotNumber()));
//        list.add(new ItemEnquiryModel("Address",
//                itemEnquiryDetailsData.getDeliveryAddressLocality()));
//        return list;
//    }
}