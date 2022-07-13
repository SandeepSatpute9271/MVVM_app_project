package com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode;/*
 * Created by Sandeep(Techno Learning) on 04,July,2022
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;

import javax.inject.Inject;

public class DeliveryItemProductDetails{

    @Inject public DeliveryItemProductDetails() {}

    @Element(name = "routeResourceKey",required = false)
    public String routeResourceKey;
    @Element(name = "deliveryId",required = false)
    public String deliveryId;
    @Element(name = "deliveryDate",required = false)
    public String deliveryDate;
    @Element(name = "componentId",required = false)
    public String componentId;
    @Element(name = "productCode",required = false)
    public String productCode;
    @Element(name = "orderDescriptionClean",required = false)
    public String orderDescriptionClean;
    @Element(name = "name15",required = false)
    public String name15;
    @Element(name = "currentLotNumber",required = false)
    public String currentLotNumber;
    @Element(name = "totalLotNumber",required = false)
    public String totalLotNumber;
    @Element(name = "lastUpdatedUserId",required = false)
    public String lastUpdatedUserId;
    @Element(name = "lastUpdatedTimeStamp",required = false)
    public String lastUpdatedTimeStamp;
    @Element(name = "deliveryRecipientName",required = false)
    public String deliveryRecipientName;
    @Element(name = "deliveryAddressCompanyName",required = false)
    public String deliveryAddressCompanyName;
    @Element(name = "deliveryAddressBuildingName",required = false)
    public String deliveryAddressBuildingName;
    @Element(name = "deliveryAddressPremise",required = false)
    public String deliveryAddressPremise;
    @Element(name = "deliveryAddressThoroughFare",required = false)
    public String deliveryAddressThoroughFare;
    @Element(name = "deliveryAddressLocality",required = false)
    public String deliveryAddressLocality;
    @Element(name = "deliveryAddressPostTown",required = false)
    public String deliveryAddressPostTown;
    @Element(name = "deliveryAddressPostCode",required = false)
    public String deliveryAddressPostCode;
    @Element(name = "deliveryAddressCounty",required = false)
    public String deliveryAddressCounty;

    public String getRouteResourceKey() {
        return routeResourceKey;
    }

    public void setRouteResourceKey(String routeResourceKey) {
        this.routeResourceKey = routeResourceKey;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOrderDescriptionClean() {
        return orderDescriptionClean;
    }

    public void setOrderDescriptionClean(String orderDescriptionClean) {
        this.orderDescriptionClean = orderDescriptionClean;
    }

    public String getName15() {
        return name15;
    }

    public void setName15(String name15) {
        this.name15 = name15;
    }

    public String getCurrentLotNumber() {
        return currentLotNumber;
    }

    public void setCurrentLotNumber(String currentLotNumber) {
        this.currentLotNumber = currentLotNumber;
    }

    public String getTotalLotNumber() {
        return totalLotNumber;
    }

    public void setTotalLotNumber(String totalLotNumber) {
        this.totalLotNumber = totalLotNumber;
    }

    public String getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(String lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId;
    }

    public String getLastUpdatedTimeStamp() {
        return lastUpdatedTimeStamp;
    }

    public void setLastUpdatedTimeStamp(String lastUpdatedTimeStamp) {
        this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
    }

    public String getDeliveryRecipientName() {
        return deliveryRecipientName;
    }

    public void setDeliveryRecipientName(String deliveryRecipientName) {
        this.deliveryRecipientName = deliveryRecipientName;
    }

    public String getDeliveryAddressCompanyName() {
        return deliveryAddressCompanyName;
    }

    public void setDeliveryAddressCompanyName(String deliveryAddressCompanyName) {
        this.deliveryAddressCompanyName = deliveryAddressCompanyName;
    }

    public String getDeliveryAddressBuildingName() {
        return deliveryAddressBuildingName;
    }

    public void setDeliveryAddressBuildingName(String deliveryAddressBuildingName) {
        this.deliveryAddressBuildingName = deliveryAddressBuildingName;
    }

    public String getDeliveryAddressPremise() {
        return deliveryAddressPremise;
    }

    public void setDeliveryAddressPremise(String deliveryAddressPremise) {
        this.deliveryAddressPremise = deliveryAddressPremise;
    }

    public String getDeliveryAddressThoroughFare() {
        return deliveryAddressThoroughFare;
    }

    public void setDeliveryAddressThoroughFare(String deliveryAddressThoroughFare) {
        this.deliveryAddressThoroughFare = deliveryAddressThoroughFare;
    }

    public String getDeliveryAddressLocality() {
        return deliveryAddressLocality;
    }

    public void setDeliveryAddressLocality(String deliveryAddressLocality) {
        this.deliveryAddressLocality = deliveryAddressLocality;
    }

    public String getDeliveryAddressPostTown() {
        return deliveryAddressPostTown;
    }

    public void setDeliveryAddressPostTown(String deliveryAddressPostTown) {
        this.deliveryAddressPostTown = deliveryAddressPostTown;
    }

    public String getDeliveryAddressPostCode() {
        return deliveryAddressPostCode;
    }

    public void setDeliveryAddressPostCode(String deliveryAddressPostCode) {
        this.deliveryAddressPostCode = deliveryAddressPostCode;
    }

    public String getDeliveryAddressCounty() {
        return deliveryAddressCounty;
    }

    public void setDeliveryAddressCounty(String deliveryAddressCounty) {
        this.deliveryAddressCounty = deliveryAddressCounty;
    }
}
