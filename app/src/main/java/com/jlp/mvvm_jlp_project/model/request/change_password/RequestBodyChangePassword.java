package com.jlp.mvvm_jlp_project.model.request.change_password;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestDataAuthenticateUser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyChangePassword {

    @Inject
    RequestBodyChangePassword(){}

    @Element(name = "cds:ChangePasswordRequest",required = false)
    private RequestDataChangePassword requestDataChangePassword;

    public RequestDataChangePassword getRequestDataChangePassword() {
        return requestDataChangePassword;
    }

    public void setRequestDataChangePassword(RequestDataChangePassword requestDataChangePassword) {
        this.requestDataChangePassword = requestDataChangePassword;
    }
}
