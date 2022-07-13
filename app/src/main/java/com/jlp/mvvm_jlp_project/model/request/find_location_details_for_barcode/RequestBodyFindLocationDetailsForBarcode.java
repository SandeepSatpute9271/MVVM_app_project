package com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestDataAuthenticateUser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyFindLocationDetailsForBarcode {

    @Inject
    RequestBodyFindLocationDetailsForBarcode(){}

    @Element(name = "cds:FindLocationDetailsForBarcodeRequest",required = false)
    private RequestDataFindLocationDetailsForBarcode requestDataFindLocationDetailsForBarcode;

    public RequestDataFindLocationDetailsForBarcode getRequestDataFindLocationDetailsForBarcode() {
        return requestDataFindLocationDetailsForBarcode;
    }

    public void setRequestDataFindLocationDetailsForBarcode(RequestDataFindLocationDetailsForBarcode requestDataFindLocationDetailsForBarcode) {
        this.requestDataFindLocationDetailsForBarcode = requestDataFindLocationDetailsForBarcode;
    }
}
