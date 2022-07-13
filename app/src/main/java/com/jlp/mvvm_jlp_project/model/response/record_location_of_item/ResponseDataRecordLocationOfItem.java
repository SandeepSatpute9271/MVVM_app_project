package com.jlp.mvvm_jlp_project.model.response.record_location_of_item;


import android.os.Parcel;
import android.os.Parcelable;

import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.LocationItemDetails;
import com.jlp.mvvm_jlp_project.model.response.DITSErrors;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.LocationDetails;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

/**
 *  Created by Sandeep(Techno Learning) on 16,June,2022
 */

@Root(name = "FindLocationDetailsForBarcodeResponse", strict = false)
@Namespace(reference = Constants.NAMESPACE)
public class ResponseDataRecordLocationOfItem {
    @Element(name = "LocationItemDetails", required = false)
    public LocationItemDetails locationItemDetails;

    @Element(name = "DITSErrors",required = false)
    private DITSErrors ditsErrors;

    @Inject
    ResponseDataRecordLocationOfItem(){}

    public LocationItemDetails getLocationItemDetails() {
        return locationItemDetails;
    }

    public void setLocationItemDetails(LocationItemDetails locationItemDetails) {
        this.locationItemDetails = locationItemDetails;
    }

    public DITSErrors getDitsErrors() {
        return ditsErrors;
    }

    public void setDitsErrors(DITSErrors ditsErrors) {
        this.ditsErrors = ditsErrors;
    }
}
