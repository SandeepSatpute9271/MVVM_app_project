package com.jlp.mvvm_jlp_project.view.route_management;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.adapters.RouteDeliveryDetailsAdapter;
import com.jlp.mvvm_jlp_project.databinding.FragmentRouteSummaryNewBinding;
import com.jlp.mvvm_jlp_project.interfaces.AppBarStateChangeListener;
import com.jlp.mvvm_jlp_project.interfaces.ClickListener;
import com.jlp.mvvm_jlp_project.interfaces.DialogListener;
import com.jlp.mvvm_jlp_project.model.DeliveryDetails;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.SpacesItemDecoration;
import com.jlp.mvvm_jlp_project.view.base.BaseDialogFragment;
import com.jlp.mvvm_jlp_project.view.base.BaseFragment;
import com.jlp.mvvm_jlp_project.viewmodel.RouteSummaryViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RouteSummaryFragment extends BaseFragment implements ClickListener, View.OnClickListener, DialogListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private @NonNull
    FragmentRouteSummaryNewBinding binding;

    private RouteSummaryViewModel summaryViewModel;
    private RouteDeliveryDetailsAdapter adapter;
    private ArrayList<DeliveryDetails> listDeliveryDetails = new ArrayList<>();


    public RouteSummaryFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPageParam();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        summaryViewModel = new ViewModelProvider(this).get(RouteSummaryViewModel.class);

        initObserver(view);
        initListener();
    }


    private void initObserver(View view) {

    }


    private void initListener() {

        showIconToolbar();


        // Dummy list funciton
        listDeliveryDetails = summaryViewModel.getDummyList(getActivity());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        llm.setAutoMeasureEnabled(false);

        binding.recyList.setHasFixedSize(true);
        adapter = new RouteDeliveryDetailsAdapter(listDeliveryDetails, getActivity(), this, childListener);
        binding.recyList.setLayoutManager(llm);
        binding.recyList.setAdapter(adapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_padding_tiny);
        binding.recyList.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        binding.appbarLayoutRoute.addOnOffsetChangedListener(appBarStateChangeListener);

    }


    private void showIconToolbar() {

        // Second Done Icon Enable
        binding.homeTopheader1.imgCloseSecond.setVisibility(View.VISIBLE);
        binding.homeTopheader.imgCloseSecond.setVisibility(View.VISIBLE);
        binding.homeTopheader1.imgCloseSecond.setImageResource(R.drawable.ic_done_24);
        binding.homeTopheader.imgCloseSecond.setImageResource(R.drawable.ic_done_24);
        binding.homeTopheader1.imgCloseSecond.setOnClickListener(this);
        binding.homeTopheader.imgCloseSecond.setOnClickListener(this);


        // Third Filter Icon Enable
        binding.homeTopheader1.imgCloseThird.setVisibility(View.VISIBLE);
        binding.homeTopheader.imgCloseThird.setVisibility(View.VISIBLE);
        binding.homeTopheader1.imgCloseThird.setImageResource(R.drawable.ic_filter_alt_24);
        binding.homeTopheader.imgCloseThird.setImageResource(R.drawable.ic_filter_alt_24);
        binding.homeTopheader1.imgCloseThird.setOnClickListener(this);
        binding.homeTopheader.imgCloseThird.setOnClickListener(this);
    }


    public static RouteSummaryFragment newInstance(String param1, String param2) {
        RouteSummaryFragment fragment = new RouteSummaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    private void initPageParam() {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected View initViewBinding(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRouteSummaryNewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onClickItem(int index, Object model) {


    }

    ClickListener childListener = new ClickListener() {
        @Override
        public void onClickItem(int index, Object model) {
            // Lots click listener
        }
    };

    AppBarStateChangeListener appBarStateChangeListener = new AppBarStateChangeListener() {
        @Override
        public void onStateChanged(AppBarLayout appBarLayout, State state) {
            if (state.name().equalsIgnoreCase(State.COLLAPSED.name())) {
                binding.secondHeader.setVisibility(View.VISIBLE);
            } else if (state.name().equalsIgnoreCase(State.EXPANDED.name())) {
                binding.secondHeader.setVisibility(View.GONE);
            }
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgCloseSecond:

                // Check is this partial commit.
                Helper.addFragment(getActivity(), new SummaryFragment());
                break;

            case R.id.imgCloseThird:
                FilterByLocationDialogFragment dialogFragment = new FilterByLocationDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(BaseDialogFragment.PARAM_NOT_ALERT_DIALOG, true);

                Helper.startDialogFragment(getActivity(), dialogFragment, bundle, this);
                break;
        }
    }


    @Override
    public void onFinishDialog(String inputText, Boolean flag) {

        // Apply Filter
        if (!flag) {
            listDeliveryDetails.clear();
            listDeliveryDetails.addAll(summaryViewModel.getFilterByLocation(inputText));
            adapter.notifyDataSetChanged();
        } else {
            // clear filter
            listDeliveryDetails.clear();
            listDeliveryDetails.addAll(summaryViewModel.getBackupList());
            adapter.notifyDataSetChanged();
            //Utils.showErrorMessage(getActivity(), "Filter Cleared : ");
        }
    }
}