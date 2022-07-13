package com.jlp.mvvm_jlp_project.model.request.change_password;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */


import com.jlp.mvvm_jlp_project.model.request.authenticate_user.AuthenticationDetails;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "cds:ChangePasswordRequest", strict = false)
public class RequestDataChangePassword {
    @Inject
    RequestDataChangePassword(){}

    @Element(name = "cds:ChangePasswordDetails",required = false)
    public ChangePasswordDetails changePasswordDetails;

    public ChangePasswordDetails getChangePasswordDetails() {
        return changePasswordDetails;
    }

    public void setChangePasswordDetails(ChangePasswordDetails changePasswordDetails) {
        this.changePasswordDetails = changePasswordDetails;
    }
}
