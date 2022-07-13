package com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode;


import android.os.Parcel;

import com.jlp.mvvm_jlp_project.model.response.DITSErrors;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "FindDeliveryItemDetailsForComponentBarcodeResponse", strict = false)
@Namespace(reference = Constants.NAMESPACE)
public class ResponseDataFindDeliveryItemDetailsForComponentBarcode {
    @Element(name = "DeliveryItemDetails", required = false)
    public DeliveryItemDetails deliveryItemDetails;

    @Element(name = "DITSErrors",required = false)
    private DITSErrors ditsErrors;

    @Inject
    ResponseDataFindDeliveryItemDetailsForComponentBarcode(){}

    public DeliveryItemDetails getDeliveryItemDetails() {
        return deliveryItemDetails;
    }

    public void setDeliveryItemDetails(DeliveryItemDetails deliveryItemDetails) {
        this.deliveryItemDetails = deliveryItemDetails;
    }

    public DITSErrors getDitsErrors() {
        return ditsErrors;
    }

    public void setDitsErrors(DITSErrors ditsErrors) {
        this.ditsErrors = ditsErrors;
    }
}
