package com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode;/*
 * Created by Sandeep(Techno Learning) on 04,July,2022
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "LocationDetails", strict = false)
public class LocationDetails {

    @Inject public LocationDetails() {}

    @Element(name = "locationId",required = false)
    public String locationId;
    @Element(name = "name15",required = false)
    public String name15;

    protected LocationDetails(Parcel in) {
        locationId = in.readString();
        name15 = in.readString();
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName15() {
        return name15;
    }

    public void setName15(String name15) {
        this.name15 = name15;
    }
}
