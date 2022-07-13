package com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode;

import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseDataAuthenticateUser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyFindLocationDetailsForBarcode {

    @Element(name = "FindLocationDetailsForBarcodeResponse",required = false)
    private ResponseDataFindLocationDetailsForBarcode responseDataFindLocationDetailsForBarcode;

    public ResponseDataFindLocationDetailsForBarcode getResponseDataFindLocationDetailsForBarcode() {
        return responseDataFindLocationDetailsForBarcode;
    }

    public void setResponseDataFindLocationDetailsForBarcode(ResponseDataFindLocationDetailsForBarcode responseDataFindLocationDetailsForBarcode) {
        this.responseDataFindLocationDetailsForBarcode = responseDataFindLocationDetailsForBarcode;
    }
}
