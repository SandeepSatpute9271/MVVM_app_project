package com.jlp.mvvm_jlp_project.model;


public class ItemEnquiryModel {
   private String deliveryNumber;
   private String deliveryNumbers;


    public ItemEnquiryModel(String deliveryNumber,
                            String deliveryNumbers
    )
    {
        this.deliveryNumber = deliveryNumber;
        this.deliveryNumbers = deliveryNumbers;

    }
    public String getDeliveryNumber() {
        return deliveryNumber;
    }
    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }
    public String getDeliveryNumbers() {
        return deliveryNumbers;
    }
    public void setDeliveryNumbers(String deliveryNumbers) {
        this.deliveryNumbers = deliveryNumbers;
    }
}