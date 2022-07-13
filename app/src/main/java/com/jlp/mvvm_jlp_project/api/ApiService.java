package com.jlp.mvvm_jlp_project.api;

import com.jlp.mvvm_jlp_project.model.request.authenticate_user.RequestEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.request.change_password.RequestEnvelopeChangePassword;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_details_for_component_barcode.RequestEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_delivery_item_details_for_component_barcode.RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.request.find_location_details_for_barcode.RequestEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.request.record_location_of_item.RequestEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.request.route_management_summary.RequestEnvelopRouteManagementSummary;
import com.jlp.mvvm_jlp_project.model.response.authenticate_user.ResponseEnvelopeAuthenticateUser;
import com.jlp.mvvm_jlp_project.model.response.change_password.ResponseEnvelopeChangePassword;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_details_for_component_barcode.ResponseEnvelopeFindDeliveryDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_delivery_item_details_for_component_barcode.ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode;
import com.jlp.mvvm_jlp_project.model.response.find_location_details_for_barcode.ResponseEnvelopeFindLocationDetailsForBarcode;
import com.jlp.mvvm_jlp_project.model.response.record_location_of_item.ResponseEnvelopeRecordLocationOfItem;
import com.jlp.mvvm_jlp_project.model.response.route_management_summary.ResponseEnvelopeRouteManagementSummary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Sandeep(Techno Learning) on 16,June,2022
 */

public interface ApiService {

    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/AuthenticateUser")
    Call<ResponseEnvelopeAuthenticateUser> authenticateUser(@Body RequestEnvelopeAuthenticateUser envelope);

    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/ChangePassword")
    Call<ResponseEnvelopeChangePassword> changePasswordAndLogon(@Body RequestEnvelopeChangePassword envelope);


    // call from screen
    // Item Movements 4 output at Item Movements 6
    // Multi Movements 2 output at Multi Movements 3
    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/FindLocationDetailsForBarcode")
    Call<ResponseEnvelopeFindLocationDetailsForBarcode> findLocationDetailsForBarcode(@Body RequestEnvelopeFindLocationDetailsForBarcode envelope);

    // call from screen
    // Item Inquiry 1 and show output at Item Inquiry 3
    // Item Movements 2 output at Item Movements 3
    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/FindDeliveryDetailsForComponentBarcode")
    Call<ResponseEnvelopeFindDeliveryDetailsForComponentBarcode> findDeliveryDetailsForComponentBarcode(@Body RequestEnvelopeFindDeliveryDetailsForComponentBarcode envelope);

    // call from screen
    // Multi Movements 2 output at Multi Movements 3
    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/FindDeliveryItemDetailsForComponentBarcode")
    Call<ResponseEnvelopeFindDeliveryItemDetailsForComponentBarcode> findDeliveryItemDetailsForComponentBarcode(@Body RequestEnvelopeFindDeliveryItemDetailsForComponentBarcode envelope);


    //call from screen
    // Item Movement 4 to Item Movement 6
    // Multi Movements 3 output at Multi Movements 3
    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/RecordLocationOfItem")
    Call<ResponseEnvelopeRecordLocationOfItem> recordLocationOfItem(@Body RequestEnvelopeRecordLocationOfItem envelope);


    //call from screen
    // Summary Details
    @Headers({"Content-Type: application/soap+xml", "charset: utf-8", "Content-Length: length"})
    @POST("/FindSummaryOfDeliveriesAndDeliveryItems")
    Call<ResponseEnvelopeRouteManagementSummary> summaryDetailsApi(@Body RequestEnvelopRouteManagementSummary envelope);


}