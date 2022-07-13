package com.jlp.mvvm_jlp_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jlp.mvvm_jlp_project.R;
import com.jlp.mvvm_jlp_project.databinding.RowDeliveryDetailsBinding;
import com.jlp.mvvm_jlp_project.interfaces.ClickListener;
import com.jlp.mvvm_jlp_project.model.DeliveryDetails;
import com.jlp.mvvm_jlp_project.utils.SpacesItemDecoration;

import java.util.ArrayList;

public class RouteDeliveryDetailsAdapter extends RecyclerView.Adapter<RouteDeliveryDetailsAdapter.RecyclerViewHolder> {

    private ArrayList<DeliveryDetails> list;
    private Context mcontext;
    private ClickListener listener;
    private ClickListener childListener;

    public RouteDeliveryDetailsAdapter(ArrayList<DeliveryDetails> list, Context mcontext, ClickListener listener, ClickListener childListener) {
        this.list = list;
        this.mcontext = mcontext;
        this.listener = listener;
        this.childListener = childListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowDeliveryDetailsBinding binding =
                RowDeliveryDetailsBinding.inflate(LayoutInflater.from(parent.getContext()));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        binding.getRoot().setLayoutParams(lp);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        DeliveryDetails data = list.get(position);

        holder.view.txtDeliveryNoValue.setText(data.getDeliveryNumber());
        holder.view.txtCustomerNameValue.setText(data.getCustomerName());
        holder.view.txtItemValue.setText(data.getItemNumber());
        holder.view.txtProductDescValue.setText(data.getProductDescription());

        final int index = holder.getAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onClickItem(index, list.get(index));
            }
        });

        DeliveryDetailsLotsAdapter secondAdapter = new DeliveryDetailsLotsAdapter(list.get(position).getLotsList(), mcontext, childListener);
        GridLayoutManager layoutManager = new GridLayoutManager(mcontext, 2);

        if (!(holder.view.recyLotsList.getItemDecorationCount() > 0)) {
            int spacingInPixels = mcontext.getResources().getDimensionPixelSize(R.dimen.margin_padding_tiny);
            holder.view.recyLotsList.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        }

        holder.view.recyLotsList.setLayoutManager(layoutManager);
        holder.view.recyLotsList.setAdapter(secondAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RowDeliveryDetailsBinding view;

        public RecyclerViewHolder(@NonNull RowDeliveryDetailsBinding itemView) {
            super(itemView.getRoot());
            this.view = itemView;
        }
    }

}