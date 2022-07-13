package com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyFindDeliveryDetailsForComponentBarcode {

    @Inject
    RequestBodyFindDeliveryDetailsForComponentBarcode(){}

    @Element(name = "cds:FindDeliveryDetailsForComponentBarcodeRequest",required = false)
    private RequestDataFindDeliveryDetailsForComponentBarcode requestDataFindDeliveryDetailsForComponentBarcode;

    public RequestDataFindDeliveryDetailsForComponentBarcode getRequestDataFindDeliveryDetailsForComponentBarcode() {
        return requestDataFindDeliveryDetailsForComponentBarcode;
    }

    public void setRequestDataFindDeliveryDetailsForComponentBarcode(RequestDataFindDeliveryDetailsForComponentBarcode requestDataFindDeliveryDetailsForComponentBarcode) {
        this.requestDataFindDeliveryDetailsForComponentBarcode = requestDataFindDeliveryDetailsForComponentBarcode;
    }
}
