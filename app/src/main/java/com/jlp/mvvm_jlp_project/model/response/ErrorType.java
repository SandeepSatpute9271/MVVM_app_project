package com.jlp.mvvm_jlp_project.model.response;/*
 * Created by Sandeep(Techno Learning) on 28,June,2022
 */

import org.simpleframework.xml.Element;

public class ErrorType {
    @Element(name = "ErrorNumber", required = false)
    public String ErrorNumber;

    @Element(name = "ErrorMessage", required = false)
    public String ErrorMessage;

    public String getErrorNumber() {
        return ErrorNumber;
    }

    public void setErrorNumber(String errorNumber) {
        ErrorNumber = errorNumber;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
