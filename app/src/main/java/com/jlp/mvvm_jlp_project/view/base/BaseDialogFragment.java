package com.jlp.mvvm_jlp_project.view.base;

import androidx.fragment.app.DialogFragment;

import com.jlp.mvvm_jlp_project.interfaces.DialogListener;

public class BaseDialogFragment extends DialogFragment {

    public static final String PARAM_NOT_ALERT_DIALOG = "notAlertDialog";
    public static final String PARAM_BUNDLE_FULLSCREEN = "fullScreen";
    public static final String PARAM_BUNDLE_DIALOG_TAG = "dialog";

    private DialogListener listener = null;


    public void setListener(DialogListener listener) {
        this.listener = listener;
    }

    public DialogListener getListener() {
        return listener;
    }

}
