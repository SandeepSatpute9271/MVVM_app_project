package com.jlp.mvvm_jlp_project.model.response.route_management_summary;

import android.os.Parcel;
import android.os.Parcelable;

import com.jlp.mvvm_jlp_project.model.RouteSummary;
import com.jlp.mvvm_jlp_project.model.response.DITSErrors;
import com.jlp.mvvm_jlp_project.utils.Constants;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;


@Root(name = "FindSummaryOfDeliveriesAndDeliveryItemsResponse", strict = false)
@Namespace(reference = Constants.NAMESPACE)
public class ResponseDataRouteManagementSummary implements Parcelable {

    @Element(name = "SummaryDeliveryDetails", required = false)
    public RouteSummary routeSummary;

    @Element(name = "DITSErrors", required = false)
    private DITSErrors ditsErrors;

    @Inject
    ResponseDataRouteManagementSummary() {
    }

    protected ResponseDataRouteManagementSummary(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseDataRouteManagementSummary> CREATOR = new Creator<ResponseDataRouteManagementSummary>() {
        @Override
        public ResponseDataRouteManagementSummary createFromParcel(Parcel in) {
            return new ResponseDataRouteManagementSummary(in);
        }

        @Override
        public ResponseDataRouteManagementSummary[] newArray(int size) {
            return new ResponseDataRouteManagementSummary[size];
        }
    };

    public RouteSummary getRouteSummary() {
        return routeSummary;
    }

    public void setRouteSummary(RouteSummary routeSummary) {
        this.routeSummary = routeSummary;
    }

    public DITSErrors getDitsErrors() {
        return ditsErrors;
    }

    public void setDitsErrors(DITSErrors ditsErrors) {
        this.ditsErrors = ditsErrors;
    }
}
