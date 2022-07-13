package com.jlp.mvvm_jlp_project.model;

import com.jlp.mvvm_jlp_project.model.response.DeliveryNum;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "SummaryDeliveryDetails", strict = false)
public class RouteSummary {

    @Element(name = "routeId", required = false)
    private String routeNumber = new String();

    @Element(name = "deliveryDate", required = false)
    private String deliveryDate = new String();

    //@Element(name = "totalLotNumber", required = false) TODO: count - from list of Deliveries
    private String totalDeliveries = new String();

    @Element(name = "totalNumberOfDeliveryLots", required = false)
    private String totalLots = new String();

    @Element(name = "totalNumberOfDeliveryLotsLoaded", required = false)
    private String deliveryLotsLoaded = new String();

    @Element(name = "DeliveryIdForDelivery", required = false)
    public DeliveryNum deliveryCollection = new DeliveryNum();

    @Inject
    public RouteSummary() {

    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(String totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public String getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(String totalLots) {
        this.totalLots = totalLots;
    }

    public String getDeliveryLotsLoaded() {
        return deliveryLotsLoaded;
    }

    public void setDeliveryLotsLoaded(String deliveryLotsLoaded) {
        this.deliveryLotsLoaded = deliveryLotsLoaded;
    }

    public Integer getTotalNumberOfDeliveriesCount() {
        return deliveryCollection.getDeliveryIds().size();
    }
}
