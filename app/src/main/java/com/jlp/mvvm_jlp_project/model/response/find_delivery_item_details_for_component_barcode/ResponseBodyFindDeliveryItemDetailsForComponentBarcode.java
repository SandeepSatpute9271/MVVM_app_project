package com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyFindDeliveryItemDetailsForComponentBarcode {

    @Element(name = "FindDeliveryItemDetailsForComponentBarcodeResponse",required = false)
    private ResponseDataFindDeliveryItemDetailsForComponentBarcode responseDataFindDeliveryItemDetailsForComponentBarcode;

    public ResponseDataFindDeliveryItemDetailsForComponentBarcode getResponseDataFindDeliveryItemDetailsForComponentBarcode() {
        return responseDataFindDeliveryItemDetailsForComponentBarcode;
    }

    public void setResponseDataFindDeliveryItemDetailsForComponentBarcode(ResponseDataFindDeliveryItemDetailsForComponentBarcode responseDataFindDeliveryItemDetailsForComponentBarcode) {
        this.responseDataFindDeliveryItemDetailsForComponentBarcode = responseDataFindDeliveryItemDetailsForComponentBarcode;
    }
}
