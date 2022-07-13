package com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */


import com.jlp.mvvm_jlp_project.model.request.authenticate_user.AuthenticationDetails;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "FindLocationDetailsForBarcodeRequest", strict = false)
public class RequestDataFindLocationDetailsForBarcode {
    @Inject
    RequestDataFindLocationDetailsForBarcode(){}

    @Element(name = "cds:barcode",required = false)
    public String barcode;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
