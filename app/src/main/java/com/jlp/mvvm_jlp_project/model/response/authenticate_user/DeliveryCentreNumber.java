package com.jlp.mvvm_jlp_project.model.response.authenticate_user;/*
 * Created by Sandeep(Techno Learning) on 27,June,2022
 */

import org.simpleframework.xml.Element;

public class DeliveryCentreNumber {
    @Element(name = "deliveryCentreId", required = false)
    public String deliveryCentreId;
    @Element(name = "deliveryCentreName", required = false)
    public String deliveryCentreName;
    @Element(name = "isHandoverAllowed", required = false)
    public boolean isHandoverAllowed;

    public String getDeliveryCentreId() {
        return deliveryCentreId;
    }

    public void setDeliveryCentreId(String deliveryCentreId) {
        this.deliveryCentreId = deliveryCentreId;
    }

    public String getDeliveryCentreName() {
        return deliveryCentreName;
    }

    public void setDeliveryCentreName(String deliveryCentreName) {
        this.deliveryCentreName = deliveryCentreName;
    }

    public boolean isHandoverAllowed() {
        return isHandoverAllowed;
    }

    public void setHandoverAllowed(boolean handoverAllowed) {
        isHandoverAllowed = handoverAllowed;
    }
}
