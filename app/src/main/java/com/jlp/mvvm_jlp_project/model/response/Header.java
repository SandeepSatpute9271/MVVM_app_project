package com.jlp.mvvm_jlp_project.model.response;/*
 * Created by Sandeep(Techno Learning) on 28,June,2022
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Header")
public class Header {
    @Element(name = "meta-data",required = false)
    public Metadata metadata;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
