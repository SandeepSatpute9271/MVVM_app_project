package com.jlp.mvvm_jlp_project.view.itemenquiry;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.home.TemplateFragment;


public class ItemEnquiryFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View rootView;
    ImageView imgClose, imgCloseSecond;
    private String mParam1;
    private String mParam2;
    EditText inputBarcode;
    AppCompatButton button;

    public ItemEnquiryFragment() {

    }

    public static TemplateFragment newInstance(String param1, String param2) {
        TemplateFragment fragment = new TemplateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_item_enquiry, container, false);
        imgClose = rootView.findViewById(R.id.imgClose);
        imgCloseSecond = rootView.findViewById(R.id.imgCloseSecond);
        button = rootView.findViewById(R.id.btnnext);
        inputBarcode = rootView.findViewById(R.id.inputBarcode);
        button.setOnClickListener(this);

        return rootView;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnnext:
                redirect();
                break;
        }
    }

    private void redirect() {
        Helper.hideKeyboard(getActivity());
        Fragment fragment=null;
        if(TextUtils.isEmpty(inputBarcode.getText().toString().trim())){
            Utils.showErrorMessage(getActivity(), getResources().getString(R.string.enter_barcode));
        }else if(inputBarcode.getText().toString().trim().length()<6){
            Utils.showErrorMessage(getActivity(), getResources().getString(R.string.invalid_barcode));
        }else{
            fragment=new com.jlp.mvvm_jlp_project.view.itemenquiry.ItemEnquiryDisplayFragment();
            replaceFragment(fragment);
        }
    }

    public void replaceFragment(Fragment someFragment){
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_main,someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void addHomeFragment(Fragment fragment) {
        clearBackStack();

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment_container, fragment);
        transaction.addToBackStack(getString(R.string.backstack_tag));
        transaction.commit();
    }

    private void clearBackStack() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }


    }


}