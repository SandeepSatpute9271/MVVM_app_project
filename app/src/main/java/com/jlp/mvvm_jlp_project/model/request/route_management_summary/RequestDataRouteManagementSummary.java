package com.jlp.mvvm_jlp_project.model.request.route_management_summary;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;


@Root(name = "FindSummaryOfDeliveriesAndDeliveryItemsRequest", strict = false)
public class RequestDataRouteManagementSummary {
    @Inject
    RequestDataRouteManagementSummary() {
    }

    @Element(name = "routeResourceKey", required = false)
    private String routeId;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}