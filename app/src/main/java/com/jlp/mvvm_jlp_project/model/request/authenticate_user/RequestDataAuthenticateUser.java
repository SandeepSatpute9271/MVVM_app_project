package com.jlp.mvvm_jlp_project.model.request.authenticate_user;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "AuthenticateUserRequest", strict = false)
public class RequestDataAuthenticateUser {
    @Inject
    RequestDataAuthenticateUser(){}

    @Element(name = "cds:AuthenticationDetails",required = false)
    public AuthenticationDetails authenticationDetails;

    public AuthenticationDetails getAuthenticationDetails() {
        return authenticationDetails;
    }

    public void setAuthenticationDetails(AuthenticationDetails authenticationDetails) {
        this.authenticationDetails = new AuthenticationDetails();
    }
}
