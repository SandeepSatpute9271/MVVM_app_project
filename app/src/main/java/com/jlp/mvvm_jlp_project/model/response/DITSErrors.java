package com.jlp.mvvm_jlp_project.model.response;/*
 * Created by Sandeep(Techno Learning) on 28,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "DITSErrors", strict = false)
public class DITSErrors {

    @Element(name = "DITSError",required = false)
    private DITSError ditsError;

    @Root(name = "DITSError", strict = false)
    public DITSError getDitsError() {
        return ditsError;
    }

    public void setDitsError(DITSError ditsError) {
        this.ditsError = ditsError;
    }

}
