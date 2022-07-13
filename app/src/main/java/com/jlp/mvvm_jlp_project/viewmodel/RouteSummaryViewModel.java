package com.jlp.mvvm_jlp_project.viewmodel;

import android.content.Context;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.model.DeliveryDetails;
import com.jlp.mvvm_jlp_project.model.LotsInfo;
import com.jlp.mvvm_jlp_project.utils.Helper;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ActivityContext;

@HiltViewModel
public class RouteSummaryViewModel extends BaseViewModel {

    private ArrayList<DeliveryDetails> backupList = new ArrayList<>();


    @Inject
    public RouteSummaryViewModel() {

    }

    public ArrayList<DeliveryDetails> getBackupList() {
        return backupList;
    }

    public ArrayList<DeliveryDetails> getDummyList(@ActivityContext Context context) {
        ArrayList<DeliveryDetails> list = new ArrayList<>();

        ArrayList<LotsInfo> lots = new ArrayList<>();
        for (int j = 0; j < 10; j++) {

            lots.add(new LotsInfo(Helper.getXmlString(context, R.string.dummy_lotSr) + (j + 1),
                    Helper.getXmlString(context, R.string.dummy_location_b5)));
        }

        for (int i = 0; i < 15; i++) {
            list.add(new DeliveryDetails(Helper.getXmlString(context, R.string.dummy_delivery_number),
                    Helper.getXmlString(context, R.string.dummy_customer_name), Helper.getXmlString(context, R.string.dummy_item_num),
                    Helper.getXmlString(context, R.string.dummy_product_desc),
                    lots));
        }

        backupList = new ArrayList<>();
        backupList.addAll(list);

        return list;

    }


    public ArrayList<DeliveryDetails> getFilterByLocation(String location) {
        ArrayList<DeliveryDetails> list = new ArrayList<>();

        for (int i = 0; i < backupList.size(); i++) {

            ArrayList<LotsInfo> lotsList = getFilteredLots(backupList.get(i).getLotsList(), location);

            // add in filtered Main list
            DeliveryDetails filteredModel = DeliveryDetails.getCopy(backupList.get(i));
            filteredModel.setLotsList(lotsList);
            list.add(filteredModel);
        }

        return list;
    }

    private ArrayList<LotsInfo> getFilteredLots(ArrayList<LotsInfo> lots, String location) {
        ArrayList<LotsInfo> tempList = new ArrayList<>();

        for (int i = 0; i < lots.size(); i++) {
            String tempLocation = lots.get(i).getLotNumber();
            if (!(tempLocation.equalsIgnoreCase(location))) {
                tempList.add(LotsInfo.getCopy(lots.get(i)));
            }
        }

        return tempList;
    }


}
