package com.jlp.mvvm_jlp_project.model.response.change_password;


import com.jlp.mvvm_jlp_project.model.response.DITSErrors;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "ChangePasswordResponse", strict = false)
@Namespace(reference = Constants.NAMESPACE)
public class ResponseDataChangePassword {
    @Element(name = "wasChangePasswordSuccessful", required = false)
    public String wasChangePasswordSuccessful;

    @Element(name = "DITSErrors",required = false)
    private DITSErrors ditsErrors;


    @Inject ResponseDataChangePassword(){}

    public String getWasChangePasswordSuccessful() {
        return wasChangePasswordSuccessful;
    }

    public void setWasChangePasswordSuccessful(String wasChangePasswordSuccessful) {
        this.wasChangePasswordSuccessful = wasChangePasswordSuccessful;
    }

    public DITSErrors getDitsErrors() {
        return ditsErrors;
    }

    public void setDitsErrors(DITSErrors ditsErrors) {
        this.ditsErrors = ditsErrors;
    }

}
