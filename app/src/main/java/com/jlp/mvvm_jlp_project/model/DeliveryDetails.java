package com.jlp.mvvm_jlp_project.model;

import java.util.ArrayList;

public class DeliveryDetails {

    private String deliveryNumber = new String();
    private String customerName = new String();

    private String itemNumber = new String();
    private String productDescription = new String();

    private ArrayList<LotsInfo> lotsList = new ArrayList<>();

    public DeliveryDetails() {
    }

    public DeliveryDetails(String deliNumber, String custName, String itemNum, String productDesc, ArrayList<LotsInfo> list) {
        this.deliveryNumber = deliNumber;
        this.customerName = custName;
        this.itemNumber = itemNum;
        this.productDescription = productDesc;
        this.lotsList = list;
    }

    public static DeliveryDetails getCopy(DeliveryDetails details) {
        return new DeliveryDetails(details.deliveryNumber, details.customerName, details.getItemNumber(),
                details.getProductDescription(), details.getLotsList());
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ArrayList<LotsInfo> getLotsList() {
        return lotsList;
    }

    public void setLotsList(ArrayList<LotsInfo> lotsList) {
        this.lotsList = lotsList;
    }


}
