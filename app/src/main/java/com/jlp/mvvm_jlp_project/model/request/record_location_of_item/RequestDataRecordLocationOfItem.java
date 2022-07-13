package com.jlp.mvvm_jlp_project.model.request.record_location_of_item;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "RecordLocationOfItemRequest", strict = false)
public class RequestDataRecordLocationOfItem {
    @Inject
    RequestDataRecordLocationOfItem(){}

    @Element(name = "cds:LocationItemDetails",required = false)
    public LocationItemDetails locationItemDetails;

    public LocationItemDetails getLocationItemDetails() {
        return locationItemDetails;
    }

    public void setLocationItemDetails(LocationItemDetails locationItemDetails) {
        this.locationItemDetails = locationItemDetails;
    }
}
