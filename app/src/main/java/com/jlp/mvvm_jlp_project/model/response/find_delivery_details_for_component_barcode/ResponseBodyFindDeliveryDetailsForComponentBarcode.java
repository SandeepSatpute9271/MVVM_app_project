package com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyFindDeliveryDetailsForComponentBarcode {

    @Element(name = "FindDeliveryDetailsForComponentBarcodeResponse",required = false)
    private ResponseDataFindDeliveryDetailsForComponentBarcode responseDataFindDeliveryDetailsForComponentBarcode;

    public ResponseDataFindDeliveryDetailsForComponentBarcode getResponseDataFindDeliveryDetailsForComponentBarcode() {
        return responseDataFindDeliveryDetailsForComponentBarcode;
    }

    public void setResponseDataFindDeliveryDetailsForComponentBarcode(ResponseDataFindDeliveryDetailsForComponentBarcode responseDataFindDeliveryDetailsForComponentBarcode) {
        this.responseDataFindDeliveryDetailsForComponentBarcode = responseDataFindDeliveryDetailsForComponentBarcode;
    }
}
