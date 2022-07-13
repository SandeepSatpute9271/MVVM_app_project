package com.jlp.mvvm_jlp_project.viewmodel;
import android.text.TextUtils;
import android.util.Pair;

import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.model.ItemEnquiryModel;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.LocationItemDetails;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.DeliveryItemProductDetails;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseDataFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.DeliveryItemDetails;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.ResponseDataFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.LocationDetails;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseDataFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.record_location_of_item.ResponseDataRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.repository.CommonBarcodeScannerRepository;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.utils.Resource;
import com.jlp.mvvm_jlp_project.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class CommonBarCodeLocationScannerViewModel extends BaseViewModel {
    CommonBarcodeScannerRepository repository;

    public MutableLiveData<Pair<Boolean, Integer>> validationResult = new MutableLiveData<>();


    public MutableLiveData<List<ItemEnquiryModel>> itemEnquiry = new MutableLiveData<>();

    public MutableLiveData<Resource<ResponseDataFindDeliveryDetailsForComponentBarcode>> responseFindDeliveryDetailsForComponentBarcode
            = new MutableLiveData<>();

    public MutableLiveData<Resource<ResponseDataFindLocationDetailsForBarcode>> responseFindLocationDetailsForBarcode
            = new MutableLiveData<>();

    public MutableLiveData<Resource<ResponseDataRecordLocationOfItem>> responseDataRecordLocationOfItem
            = new MutableLiveData<>();

    public MutableLiveData<Resource<ResponseDataFindDeliveryItemDetailsForComponentBarcode>> responseFindDeliveryItemDetailsForComponentBarcode
            = new MutableLiveData<>();

    @Inject
    public CommonBarCodeLocationScannerViewModel(CommonBarcodeScannerRepository repository) {
        this.repository = repository;
        this.responseFindDeliveryDetailsForComponentBarcode = repository._responseFindDeliveryDetailsForComponentBarcode;
        this.responseFindLocationDetailsForBarcode = repository._responseFindLocationDetailsForBarcode;
        this.responseDataRecordLocationOfItem = repository._responseDataRecordLocationOfItem;
        this.responseFindDeliveryItemDetailsForComponentBarcode = repository._responseFindDeliveryItemDetailsForComponentBarcode;
    }

    public void findDeliveryDetailsForComponentBarcode(RequestEnvelopeFindDeliveryDetailsForComponentBarcode envelope){
        repository.findDeliveryDetailsForComponentBarcode(envelope);
    }

    public void findLocationDetailsForBarcode(RequestEnvelopeFindLocationDetailsForBarcode envelope){
        repository.findLocationDetailsForBarcode(envelope);
    }

    public void findDeliveryItemDetailsForComponentBarcode(RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode envelope){
        repository.findDeliveryItemDetailsForComponentBarcode(envelope);
    }

    public void recordLocationOfItem(RequestEnvelopeRecordLocationOfItem envelope){
        repository.recordLocationOfItem(envelope);
    }

    public void validateBarcode(String barcode) {
        Pair result = new Pair<> (true, 0);
        if(TextUtils.isEmpty(barcode)){
            result = new Pair(false, R.string.enter_barcode);
        }else if(barcode.length()<6){
            result = new Pair(false, R.string.please_enter_password);
        }
        validationResult.setValue(result);
    }

    public void getComponentBarcodeData(DeliveryItemProductDetails deliveryItemProductDetails){
        List<ItemEnquiryModel> itemEnquiryModels = new ArrayList<>();
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.delivery_number,
                deliveryItemProductDetails.getDeliveryId()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.route_number,
                deliveryItemProductDetails.getRouteResourceKey()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.delivery_date,
                deliveryItemProductDetails.getDeliveryDate()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.last_recorded_location,
                deliveryItemProductDetails.getDeliveryAddressPremise()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.time_of_last_move,
                deliveryItemProductDetails.getLastUpdatedTimeStamp()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.last_user_id,
                deliveryItemProductDetails.getLastUpdatedUserId()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.product_code,
                deliveryItemProductDetails.getProductCode()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.product_description,
                deliveryItemProductDetails.getOrderDescriptionClean()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.lot_number,
                deliveryItemProductDetails.getCurrentLotNumber()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.address,
                deliveryItemProductDetails.getDeliveryAddressLocality()));
        itemEnquiry.setValue(itemEnquiryModels);
    }

    public void getItemDetailsComponentBarcodeData(DeliveryItemDetails deliveryItemDetails){
        List<ItemEnquiryModel> itemEnquiryModels = new ArrayList<>();
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.delivery_number,
                deliveryItemDetails.getDeliveryId()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.route_number,
                deliveryItemDetails.getRouteResourceKey()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.item,
                deliveryItemDetails.getGoodId()));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.product_description,
                deliveryItemDetails.getOrderDescriptionClean()));
        itemEnquiry.setValue(itemEnquiryModels);
    }

    public void getLocationBarcodeData(DeliveryItemProductDetails deliveryItemProductDetails,
                                       LocationDetails locationDetails){
        List<ItemEnquiryModel> itemEnquiryModels = new ArrayList<>();
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.delivery_number,
                deliveryItemProductDetails.getDeliveryId()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.route_number,
                deliveryItemProductDetails.getRouteResourceKey()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.item,
                "08 Aug 2022"));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.product_description,
                deliveryItemProductDetails.getOrderDescriptionClean()));
        itemEnquiry.setValue(itemEnquiryModels);
    }

    public void updateAdapterData(LocationItemDetails locationItemDetails, LocationDetails locationDetails) {
        List<ItemEnquiryModel> itemEnquiryModels = new ArrayList<>();
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.lot_number,
                locationItemDetails.getCurrentLotNumber()+" of "+locationItemDetails.getTotalLotNumber()
        ));
        itemEnquiryModels.add(new ItemEnquiryModel(R.string.stored_in_location,
                locationDetails.getName15()
        ));
        itemEnquiry.setValue(itemEnquiryModels);
    }
}