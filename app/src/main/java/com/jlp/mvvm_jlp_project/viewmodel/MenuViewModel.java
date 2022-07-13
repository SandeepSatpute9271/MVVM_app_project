package com.jlp.mvvm_jlp_project.viewmodel;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.model.DrawerMenuItem;
import com.jlp.mvvm_jlp_project.utils.AppConstants;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.view.home.TemplateFragment;
import com.jlp.mvvm_jlp_project.view.common_barcode_scanner.CommonBarcodeScannerFragment;
import com.jlp.mvvm_jlp_project.view.route_management.RouteSummaryFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ActivityContext;


@HiltViewModel
public class MenuViewModel extends BaseViewModel {

    private MutableLiveData<String> usernameMutableLiveData;

    @Inject
    public MenuViewModel() {

    }


    // Add in navigation also - menu list item
    public static ArrayList<DrawerMenuItem> getMenuList(@ActivityContext Context context) {
        AppCompatActivity activity = (AppCompatActivity) context;

        ArrayList<DrawerMenuItem> list = new ArrayList<DrawerMenuItem>();
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_item_enquiry), R.drawable.ic_1_item_enquiry));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_item_movements), R.drawable.ic_2_item_movements));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_movements), R.drawable.ic_3_movements));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_reprint_labels), R.drawable.ic_4_reprint_labels));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_amend_lots), R.drawable.ic_5_amend_lots));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_route_management), R.drawable.ic_6_route_management));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_track_handover_delivery), R.drawable.ic_7_carier_collection_details));
        list.add(new DrawerMenuItem(Helper.getXmlString(activity, R.string.str_handover_delivery), R.drawable.ic_8_carrier_handover_details));

        return list;
    }

    public void loadMenu(int id, @ActivityContext Context context) {

        if (id == R.id.nav_item_enquiry) {
            onPressItemEnquiry(context);
        } else if (id == R.id.nav_item_movements) {
            onPressItemMovements(context);
        } else if (id == R.id.nav_movements) {
            onPressMovements(context);
        } else if (id == R.id.nav_reprint_labels) {
            onPressReprintLabels(context);

        } else if (id == R.id.nav_amend_lots) {
            onPressAmendLots(context);
        } else if (id == R.id.nav_route_management) {
            onPressRouteManagement(context);
        } else if (id == R.id.nav_track_handover_delivery) {
            onPressTrackDelivery(context);
        } else if (id == R.id.nav_handover_delivery_details) {
            onPressDeliveryDetails(context);
        }
    }


    public void loadListItem(DrawerMenuItem item, @ActivityContext Context context) {

        if (Helper.getXmlString(context, R.string.str_item_enquiry).equalsIgnoreCase(item.getTitle())) {
            onPressItemEnquiry(context);
        } else if (Helper.getXmlString(context, R.string.str_item_movements).equalsIgnoreCase(item.getTitle())) {
            onPressItemMovements(context);
        } else if (Helper.getXmlString(context, R.string.str_movements).equalsIgnoreCase(item.getTitle())) {
            onPressMovements(context);
        } else if (Helper.getXmlString(context, R.string.str_reprint_labels).equalsIgnoreCase(item.getTitle())) {
            onPressReprintLabels(context);
        } else if (Helper.getXmlString(context, R.string.str_amend_lots).equalsIgnoreCase(item.getTitle())) {
            onPressAmendLots(context);
        } else if (Helper.getXmlString(context, R.string.str_route_management).equalsIgnoreCase(item.getTitle())) {
            onPressRouteManagement(context);
        } else if (Helper.getXmlString(context, R.string.str_track_handover_delivery).equalsIgnoreCase(item.getTitle())) {
            onPressTrackDelivery(context);
        } else if (Helper.getXmlString(context, R.string.str_handover_delivery).equalsIgnoreCase(item.getTitle())) {
            onPressDeliveryDetails(context);
        } else {

        }
    }

    public void onPressItemEnquiry(@ActivityContext Context context) {
        Helper.addFragment(context, new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_ITEM_ENQUIRY));
    }

    public void onPressItemMovements(@ActivityContext Context context) {
        Helper.addFragment(context, new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_ITEM_MOVEMENT_FOR_COMPONENT_BARCODE));
    }

    public void onPressMovements(@ActivityContext Context context) {
        Helper.addFragment(context, new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_MULTI_MOVEMENT_FOR_LOCATION_BARCODE));
    }

    public void onPressReprintLabels(@ActivityContext Context context) {
        Helper.addFragment(context, new TemplateFragment());
    }

    public void onPressAmendLots(@ActivityContext Context context) {
        Helper.addFragment(context, new TemplateFragment());
    }

    public void onPressRouteManagement(@ActivityContext Context context) {
        Helper.addFragment(context, new RouteSummaryFragment());
    }

    public void onPressTrackDelivery(@ActivityContext Context context) {
        Helper.addFragment(context, new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_CARRIER_COLLECTION_DETAILS));
    }

    public void onPressDeliveryDetails(@ActivityContext Context context) {
        Helper.addFragment(context, new CommonBarcodeScannerFragment(AppConstants.FRAGMENT_HAND_OVER_DELIVERY_DETAILS));

        //Helper.addFragment(context, new TemplateFragment());
    }


}
