package com.jlp.mvvm_jlp_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jlp.mvvm_jlp_project.databinding.RowRouteDetailsChildLotsBinding;
import com.jlp.mvvm_jlp_project.interfaces.ClickListener;
import com.jlp.mvvm_jlp_project.model.LotsInfo;

import java.util.ArrayList;

public class DeliveryDetailsLotsAdapter extends RecyclerView.Adapter<DeliveryDetailsLotsAdapter.RecyclerViewHolder> {

    private ArrayList<LotsInfo> list;
    private Context mcontext;
    private ClickListener listener;

    public DeliveryDetailsLotsAdapter(ArrayList<LotsInfo> list, Context mcontext, ClickListener listener) {
        this.list = list;
        this.mcontext = mcontext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowRouteDetailsChildLotsBinding binding =
                RowRouteDetailsChildLotsBinding.inflate(LayoutInflater.from(parent.getContext()));
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        binding.getRoot().setLayoutParams(lp);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        final int index = holder.getAdapterPosition();
        LotsInfo data = list.get(position);

        holder.view.txtLotNumber.setText(list.get(position).getLotNumber());
        holder.view.txtLotLocation.setText(list.get(position).getLotLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onClickItem(index, list.get(index));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RowRouteDetailsChildLotsBinding view;

        public RecyclerViewHolder(@NonNull RowRouteDetailsChildLotsBinding itemView) {
            super(itemView.getRoot());
            this.view = itemView;
        }
    }

}
