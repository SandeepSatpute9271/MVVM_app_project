package com.jlp.mvvm_jlp_project.model.response.authenticate_user;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "Body", strict = false)
public class ResponseBodyAuthenticateUser {

    @Element(name = "AuthenticateUserResponse",required = false)
    private ResponseDataAuthenticateUser responseDataAuthenticateUser;

    public ResponseDataAuthenticateUser getResponseDataAuthenticateUser() {
        return responseDataAuthenticateUser;
    }

    public void setResponseDataAuthenticateUser(ResponseDataAuthenticateUser responseDataAuthenticateUser) {
        this.responseDataAuthenticateUser = responseDataAuthenticateUser;
    }
}
