package com.jlp.mvvm_jlp_project.model.request.route_management_summary;

import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import javax.inject.Inject;


@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "cds", reference = Constants.NAMESPACE)
})
public class RequestEnvelopRouteManagementSummary {

    @Inject
    RequestEnvelopRouteManagementSummary() {
    }

    @Element(name = "soapenv:Body", required = false)
    private RequestBodyRouteManagementSummary requestBody;

    public RequestBodyRouteManagementSummary getRequestBodyRouteManagementSummary() {
        return requestBody;
    }

    public void setRequestBodyRouteManagementSummary(RequestBodyRouteManagementSummary requestBody) {
        this.requestBody = requestBody;
    }
}

