package com.jlp.mvvm_jlp_project.model.request.record_location_of_item;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestDataFindLocationDetailsForBarcode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyRecordLocationOfItem {

    @Inject
    RequestBodyRecordLocationOfItem(){}

    @Element(name = "cds:RecordLocationOfItemRequest",required = false)
    private RequestDataRecordLocationOfItem requestDataRecordLocationOfItem;

    public RequestDataRecordLocationOfItem getRequestDataRecordLocationOfItem() {
        return requestDataRecordLocationOfItem;
    }

    public void setRequestDataRecordLocationOfItem(RequestDataRecordLocationOfItem requestDataRecordLocationOfItem) {
        this.requestDataRecordLocationOfItem = requestDataRecordLocationOfItem;
    }
}
