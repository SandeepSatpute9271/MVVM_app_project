package com.jlp.mvvm_jlp_project.model.response.authenticate_user;/*
 * Created by Sandeep(Techno Learning) on 28,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DITSError", strict = false)
public class DITSError {
    @Element(name = "ErrorType", required = false)
    public ErrorType errorType;

    @Element(name = "ErrorDetails", required = false)
    public String errorDetails;
}