package com.jlp.mvvm_jlp_project.model.request.authenticate_user;/*
 * Created by Sandeep(Techno Learning) on 27,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "AuthenticationDetails", strict = false)
public class AuthenticationDetails {

    @Inject
    AuthenticationDetails(){}

    @Element(name = "cds:userId",required = false)
    public String userId;
    @Element(name = "cds:password",required = false)
    public String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
