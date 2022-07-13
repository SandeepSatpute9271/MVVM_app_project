package com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode;/*
 * Created by Sandeep(Techno Learning) on 04,July,2022
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;

import javax.inject.Inject;

public class DeliveryItemDetails {

    @Inject public DeliveryItemDetails() {}
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
    @Element(name = "goodId",required = false)
    public String goodId;
    @Element(name = "componentBarcode",required = false)
    public String componentBarcode;
    @Element(name = "componentStatus",required = false)
    public boolean componentStatus;
    @Element(name = "currentLotNumber",required = false)
    public String currentLotNumber;
    @Element(name = "totalLotNumber",required = false)
    public String totalLotNumber;

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

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getComponentBarcode() {
        return componentBarcode;
    }

    public void setComponentBarcode(String componentBarcode) {
        this.componentBarcode = componentBarcode;
    }

    public boolean isComponentStatus() {
        return componentStatus;
    }

    public void setComponentStatus(boolean componentStatus) {
        this.componentStatus = componentStatus;
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
}
