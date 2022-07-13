package com.jlp.mvvm_jlp_project.model.response.change_password;

import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseDataAuthenticateUser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyChangePassword {

    @Element(name = "ChangePasswordResponse",required = false)
    private ResponseDataChangePassword responseDataChangePassword;

    public ResponseDataChangePassword getResponseDataChangePassword() {
        return responseDataChangePassword;
    }

    public void setResponseDataChangePassword(ResponseDataChangePassword responseDataChangePassword) {
        this.responseDataChangePassword = responseDataChangePassword;
    }
}
