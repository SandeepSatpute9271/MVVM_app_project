package com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyFindDeliveryItemDetailsForComponentBarcode {

    @Inject
    RequestBodyFindDeliveryItemDetailsForComponentBarcode(){}

    @Element(name = "cds:FindDeliveryItemDetailsForComponentBarcodeRequest",required = false)
    private RequestDataFindDeliveryItemDetailsForComponentBarcode requestDataFindDeliveryItemDetailsForComponentBarcode;

    public RequestDataFindDeliveryItemDetailsForComponentBarcode getRequestDataFindDeliveryItemDetailsForComponentBarcode() {
        return requestDataFindDeliveryItemDetailsForComponentBarcode;
    }

    public void setRequestDataFindDeliveryItemDetailsForComponentBarcode(RequestDataFindDeliveryItemDetailsForComponentBarcode requestDataFindDeliveryItemDetailsForComponentBarcode) {
        this.requestDataFindDeliveryItemDetailsForComponentBarcode = requestDataFindDeliveryItemDetailsForComponentBarcode;
    }
}
