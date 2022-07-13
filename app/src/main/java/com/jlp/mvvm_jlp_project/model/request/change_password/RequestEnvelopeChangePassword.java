package com.jlp.mvvm_jlp_project.model.request.change_password;

import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestBodyAuthenticateUser;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(prefix = "soapenv" ,reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "cds" ,reference = Constants.NAMESPACE)
})
public class RequestEnvelopeChangePassword {

    @Inject
    RequestEnvelopeChangePassword(){}

    @Element(name = "soapenv:Body", required = false)
    private RequestBodyChangePassword requestBodyChangePassword;


    public RequestBodyChangePassword getRequestBodyChangePassword() {
        return requestBodyChangePassword;
    }

    public void setRequestBodyChangePassword(RequestBodyChangePassword requestBodyChangePassword) {
        this.requestBodyChangePassword = requestBodyChangePassword;
    }
}
