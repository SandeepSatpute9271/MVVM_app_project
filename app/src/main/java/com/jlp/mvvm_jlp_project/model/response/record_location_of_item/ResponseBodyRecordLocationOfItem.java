package com.jlp.mvvm_jlp_project.model.response.record_location_of_item;

import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseDataFindLocationDetailsForBarcode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyRecordLocationOfItem {

    @Element(name = "RecordLocationOfItemResponse",required = false)
    private ResponseDataRecordLocationOfItem responseDataRecordLocationOfItem;

    public ResponseDataRecordLocationOfItem getResponseDataRecordLocationOfItem() {
        return responseDataRecordLocationOfItem;
    }

    public void setResponseDataRecordLocationOfItem(ResponseDataRecordLocationOfItem responseDataRecordLocationOfItem) {
        this.responseDataRecordLocationOfItem = responseDataRecordLocationOfItem;
    }
}
