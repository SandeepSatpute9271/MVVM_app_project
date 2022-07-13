package com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode;

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
public class RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode {

    @Inject
    RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode(){}

    @Element(name = "soapenv:Body", required = false)
    private RequestBodyFindDeliveryItemDetailsForComponentBarcode requestBodyFindDeliveryItemDetailsForComponentBarcode;

    public RequestBodyFindDeliveryItemDetailsForComponentBarcode getRequestBodyFindDeliveryItemDetailsForComponentBarcode() {
        return requestBodyFindDeliveryItemDetailsForComponentBarcode;
    }

    public void setRequestBodyFindDeliveryItemDetailsForComponentBarcode(RequestBodyFindDeliveryItemDetailsForComponentBarcode requestBodyFindDeliveryItemDetailsForComponentBarcode) {
        this.requestBodyFindDeliveryItemDetailsForComponentBarcode = requestBodyFindDeliveryItemDetailsForComponentBarcode;
    }
}
