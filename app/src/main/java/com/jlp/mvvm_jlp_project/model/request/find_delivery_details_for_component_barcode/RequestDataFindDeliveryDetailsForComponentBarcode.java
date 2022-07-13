package com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "FindDeliveryDetailsForComponentBarcodeRequest", strict = false)
public class RequestDataFindDeliveryDetailsForComponentBarcode {
    @Inject
    RequestDataFindDeliveryDetailsForComponentBarcode(){}

    @Element(name = "cds:barcode",required = false)
    public String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
