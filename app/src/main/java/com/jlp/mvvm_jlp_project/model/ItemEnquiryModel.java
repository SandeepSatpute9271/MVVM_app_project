package com.jlp.mvvm_jlp_project.model;/*
 * Created by Sandeep(Techno Learning) on 29,June,2022
 */

public class ItemEnquiryModel {
    private int title;
    private String value;

    public ItemEnquiryModel(int title, String value) {
        this.title = title;
        this.value = value;
    }

    public int getTitle() {
        return title;
    }
    public void setTitle(int title) {
        this.title = title;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}