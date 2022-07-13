package com.jlp.mvvm_jlp_project.model.request.authenticate_user;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soapenv:Body", strict = false)
public class RequestBodyAuthenticateUser {

    @Inject
    RequestBodyAuthenticateUser(){}

    @Element(name = "cds:AuthenticateUserRequest",required = false)
    private RequestDataAuthenticateUser requestDataAuthenticateUser;

    public RequestDataAuthenticateUser getRequestDataAuthenticateUser() {
        return requestDataAuthenticateUser;
    }

    public void setRequestDataAuthenticateUser(RequestDataAuthenticateUser requestDataAuthenticateUser) {
        this.requestDataAuthenticateUser = requestDataAuthenticateUser;
    }
}
