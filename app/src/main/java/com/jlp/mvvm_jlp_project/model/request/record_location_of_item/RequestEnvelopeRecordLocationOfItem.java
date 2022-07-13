package com.jlp.mvvm_jlp_project.model.request.record_location_of_item;

import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestBodyFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(prefix = "soapenv" ,reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "cds" ,reference = Constants.NAMESPACE)
})
public class RequestEnvelopeRecordLocationOfItem {

    @Inject
    RequestEnvelopeRecordLocationOfItem(){}

    @Element(name = "soapenv:Body", required = false)
    private RequestBodyRecordLocationOfItem requestBodyRecordLocationOfItem;

    public RequestBodyRecordLocationOfItem getRequestBodyRecordLocationOfItem() {
        return requestBodyRecordLocationOfItem;
    }

    public void setRequestBodyRecordLocationOfItem(RequestBodyRecordLocationOfItem requestBodyRecordLocationOfItem) {
        this.requestBodyRecordLocationOfItem = requestBodyRecordLocationOfItem;
    }
}
