package com.jlp.mvvm_jlp_project.model.request.route_management_summary;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;


@Root(name = "soapenv:Body", strict = false)
public class RequestBodyRouteManagementSummary {

    @Inject
    RequestBodyRouteManagementSummary() {
    }

    @Element(name = "cds:FindSummaryOfDeliveriesAndDeliveryItemsRequest", required = false)
    private RequestDataRouteManagementSummary requestData;

    public RequestDataRouteManagementSummary getRequestDataRouteManagementSummary() {
        return requestData;
    }

    public void setRequestDataRouteManagementSummary(RequestDataRouteManagementSummary requestData) {
        this.requestData = requestData;
    }
}
