package com.jlp.mvvm_jlp_project.model.response.authenticate_user;/*
 * Created by Sandeep(Techno Learning) on 25,June,2022
 */

import org.simpleframework.xml.Element;

public
class User {
    @Element(name = "userId", required = false)
    public String userId;
    @Element(name = "userName", required = false)
    public String userName;
    @Element(name = "deliveryCentreNumber", required = false)
    public DeliveryCentreNumber deliveryCentreNumber;

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

    public DeliveryCentreNumber getDeliveryCentreNumber() {
        return deliveryCentreNumber;
    }

    public void setDeliveryCentreNumber(DeliveryCentreNumber deliveryCentreNumber) {
        this.deliveryCentreNumber = deliveryCentreNumber;
    }
}
