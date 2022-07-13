package com.jlp.mvvm_jlp_project.utils;/*
 * Created by Sandeep(Techno Learning) on 20,June,2022
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.interfaces.DialogListener;
import com.jlp.mvvm_jlp_project.view.base.BaseDialogFragment;

import dagger.hilt.android.qualifiers.ActivityContext;

public class Helper {

    /**
     * Hide the keypad once click on button
     *
     * @param context
     * @param view
     */
    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * @param activity
     * @param redirectTo
     * @param isFinishCurrentAct
     */
    public static void redirectToActivity(Activity activity, Class<?> redirectTo, boolean isFinishCurrentAct) {
        Intent intent = new Intent(activity, redirectTo);
        activity.startActivity(intent);
        if (isFinishCurrentAct) {
            activity.finish();
        }
    }

    /**
     * To add fragment in main back stack of Fragments
     *
     * @param context
     * @param fragment
     */
    public static void addFragment(@ActivityContext Context context, Fragment fragment) {
        //clearBackStack(context);
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_main, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * To clear whole back stack on home page,
     * or come back to home from anywhere
     *
     * @param context
     */
    public static void clearBackStack(@ActivityContext Context context) {
        FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


    /**
     * To get xml file string anywhere providing context
     *
     * @param context
     * @param strResId
     */
    public static String getXmlString(@ActivityContext Context context, int strResId) {
        return ((AppCompatActivity) context).getString(strResId);
    }


    /**
     * To start dialog fragment
     *
     * @param context
     * @param dialogFragment
     * @param bundle
     * @param listener
     */
    public static void startDialogFragment(@ActivityContext Context context, BaseDialogFragment dialogFragment, Bundle bundle, DialogListener listener) {
        AppCompatActivity activity = ((AppCompatActivity) context);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();

        dialogFragment.setListener(listener);
        dialogFragment.setArguments(bundle);

        Fragment prev = activity.getSupportFragmentManager().findFragmentByTag(BaseDialogFragment.PARAM_BUNDLE_DIALOG_TAG);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        dialogFragment.show(ft, BaseDialogFragment.PARAM_BUNDLE_DIALOG_TAG);
    }

}
