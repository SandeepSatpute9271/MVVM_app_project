package com.jlp.mvvm_jlp_project.model.response.route_management_summary;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "Body", strict = false)
public class ResponseBodyRouteManagementSummary {

    @Element(name = "FindSummaryOfDeliveriesAndDeliveryItemsResponse", required = false)
    private ResponseDataRouteManagementSummary responseData;

    public ResponseDataRouteManagementSummary getResponseDataRouteManagementSummary() {
        return responseData;
    }

    public void setResponseDataRouteManagementSummary(ResponseDataRouteManagementSummary responseData) {
        this.responseData = responseData;
    }
}
