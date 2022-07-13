package com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode;


import android.os.Parcel;
import android.os.Parcelable;

import com.jlp.mvvm_jlp_project.model.response.DITSErrors;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "FindDeliveryDetailsForComponentBarcodeResponse", strict = false)
@Namespace(reference = Constants.NAMESPACE)
public class ResponseDataFindDeliveryDetailsForComponentBarcode {
    @Element(name = "DeliveryItemProductDetails", required = false)
    public DeliveryItemProductDetails deliveryItemProductDetails;

    @Element(name = "DITSErrors",required = false)
    private DITSErrors ditsErrors;

    @Inject
    ResponseDataFindDeliveryDetailsForComponentBarcode(){}

    protected ResponseDataFindDeliveryDetailsForComponentBarcode(Parcel in) {
    }

    public DeliveryItemProductDetails getDeliveryItemProductDetails() {
        return deliveryItemProductDetails;
    }

    public void setDeliveryItemProductDetails(DeliveryItemProductDetails deliveryItemProductDetails) {
        this.deliveryItemProductDetails = deliveryItemProductDetails;
    }

    public DITSErrors getDitsErrors() {
        return ditsErrors;
    }

    public void setDitsErrors(DITSErrors ditsErrors) {
        this.ditsErrors = ditsErrors;
    }

}
