package com.jlp.mvvm_jlp_project.model;/*
 * Created by Sandeep(Techno Learning) on 29,June,2022
 */


public class ChangePasswordRequestModel {

    private String strEmailAddress;
    private String strPassword;
    private String strNewPassword;
    private String strConfirmPassword;

    public ChangePasswordRequestModel(String strEmailAddress, String strPassword, String strNewPassword, String strConfirmPassword) {
        this.strEmailAddress = strEmailAddress;
        this.strPassword = strPassword;
        this.strNewPassword = strNewPassword;
        this.strConfirmPassword = strConfirmPassword;
    }

    public String getStrEmailAddress() {
        return strEmailAddress;
    }

    public void setStrEmailAddress(String strEmailAddress) {
        this.strEmailAddress = strEmailAddress;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrNewPassword() {
        return strNewPassword;
    }

    public void setStrNewPassword(String strNewPassword) {
        this.strNewPassword = strNewPassword;
    }

    public String getStrConfirmPassword() {
        return strConfirmPassword;
    }

    public void setStrConfirmPassword(String strConfirmPassword) {
        this.strConfirmPassword = strConfirmPassword;
    }
}
