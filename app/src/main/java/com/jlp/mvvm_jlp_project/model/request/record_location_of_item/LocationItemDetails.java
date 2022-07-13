package com.jlp.mvvm_jlp_project.model.request.record_location_of_item;/*
 * Created by Sandeep(Techno Learning) on 07,July,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "LocationItemDetails", strict = false)
public class LocationItemDetails {

    @Inject public LocationItemDetails() {}

    @Element(name = "locationId",required = false)
    public String locationId;

    @Element(name = "name15",required = false)
    public String name15;

    @Element(name = "componentId",required = false)
    public String componentId;

    @Element(name = "deliveryId",required = false)
    public String deliveryId;

    @Element(name = "productCode",required = false)
    public String productCode;

    @Element(name = "userId",required = false)
    public String userId;

    @Element(name = "userName",required = false)
    public String userName;

    @Element(name = "currentLotNumber",required = false)
    public String currentLotNumber;

    @Element(name = "totalLotNumber",required = false)
    public String totalLotNumber;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName15() {
        return name15;
    }

    public void setName15(String name15) {
        this.name15 = name15;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
