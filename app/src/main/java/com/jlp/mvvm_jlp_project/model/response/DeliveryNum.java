package com.jlp.mvvm_jlp_project.model.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Root(name = "DeliveryIdForDelivery", strict = false)
public class DeliveryNum {


    @ElementList(name = "cds:DeliveryIdForDelivery", entry = "deliveryId", required = false, inline = true)
    public List<String> deliveryIds = new ArrayList<String>();

    /*@Element(name = "deliveryId", required = false )
    public String deliveryId = "";*/


    @Inject
    public DeliveryNum() {

    }

    public List<String> getDeliveryIds() {
        return deliveryIds;
    }

    public void setDeliveryIds(ArrayList<String> deliveryId) {
        this.deliveryIds = deliveryId;
    }

    @Override
    public String toString() {
        return "DeliveryNum{" +
                "deliveryId=" + deliveryIds +
                '}';
    }

}
