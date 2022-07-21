package com.jlp.mvvm_jlp_project.view.home;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.navigation.NavigationView;
import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.adapters.MenuAdapter;
import com.jlp.mvvm_jlp_project.databinding.ActivityHomeMainBinding;
import com.jlp.mvvm_jlp_project.interfaces.ClickListener;
import com.jlp.mvvm_jlp_project.model.DrawerMenuItem;
import com.jlp.mvvm_jlp_project.pref.AppPreferencesHelper;
import com.jlp.mvvm_jlp_project.utils.Helper;
import com.jlp.mvvm_jlp_project.utils.SpacesItemDecoration;
import com.jlp.mvvm_jlp_project.utils.Utils;
import com.jlp.mvvm_jlp_project.view.auth.AuthActivity;
import com.jlp.mvvm_jlp_project.view.auth.ChangePasswordFragment;
import com.jlp.mvvm_jlp_project.view.base.BaseActivity;
import com.jlp.mvvm_jlp_project.viewmodel.MenuViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity implements  NavigationView.OnNavigationItemSelectedListener, ClickListener {

    protected final String TAG = getClass().getSimpleName();
    private @NonNull
    ActivityHomeMainBinding binding;
    private MenuViewModel menuViewModel;
    private ProgressDialog mDialog;
    private MenuAdapter adapter;
    private ArrayList<DrawerMenuItem> menuList = new ArrayList<>();

    @Inject
    AppPreferencesHelper appPreferencesHelper;

    @Override
    protected void initViewBinding() {
        binding = ActivityHomeMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        try{
            ((TextView)binding.navView.getHeaderView(0).findViewById(R.id.txtHeaderUsername)).setText(appPreferencesHelper.getUsername());
        }catch (Exception ex){
            Log.e(TAG, "Exception: "+ex);
        }
        initEvents();
    }


    private void initEvents() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        binding.homeLayout.homeTopHeader.imgClose.setVisibility(View.GONE);
        menuList = MenuViewModel.getMenuList(this);
        adapter = new MenuAdapter(menuList, this, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        binding.homeLayout.homeContainer.recyHomeMenu.setLayoutManager(layoutManager);
        binding.homeLayout.homeContainer.recyHomeMenu.setAdapter(adapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        binding.homeLayout.homeContainer.recyHomeMenu.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
    }

    public void onClickClose(View view) {
        // Clear all fragments -default
        Helper.clearBackStack(this);
    }


    public void onCloseSecond(View view) {
        Utils.showErrorMessage(this, getString(R.string.str_debug_error));
    }


    public void onOptionMenu(View view) {
        // Sidebar open
        binding.drawerLayout.openDrawer(Gravity.LEFT);
    }


    @Override
    public void onClickItem(int index, Object model) {
        DrawerMenuItem item = (DrawerMenuItem) model;
        menuViewModel.loadListItem(item, this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        menuViewModel.loadMenu(id, this);
        DrawerLayout drawer = (DrawerLayout) binding.drawerLayout;
        drawer.closeDrawer(Gravity.LEFT);
        return true;
    }


}
