package com.jlp.mvvm_jlp_project.model.response;/*
 * Created by Sandeep(Techno Learning) on 28,June,2022
 */

import com.jlp.mvvm_jlp_project.utils.Constants;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "meta-data")
@Namespace(reference = Constants.NAMESPACE)
public class Metadata {
    @Attribute(name = "layer", required = false)
    public String layer;
    @Attribute(name = "version", required = false)
    public String version;
}
