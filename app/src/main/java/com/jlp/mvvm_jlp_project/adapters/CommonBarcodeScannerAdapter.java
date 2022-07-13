package com.jlp.mvvm_jlp_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.jlp.mvvm_jlp_project.databinding.CommonBarcodeScannerSingleItemBinding;
import com.jlp.mvvm_jlp_project.model.ItemEnquiryModel;
import com.jlp.mvvm_jlp_project.view.common_barcode_scanner.CommonBarcodeScannerViewHolder;

import java.util.List;

public class CommonBarcodeScannerAdapter extends RecyclerView.Adapter<CommonBarcodeScannerViewHolder> {
    private List<ItemEnquiryModel> list;
    private CommonBarcodeScannerSingleItemBinding binding;
    private Context context;
    public CommonBarcodeScannerAdapter(List<ItemEnquiryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CommonBarcodeScannerViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = CommonBarcodeScannerSingleItemBinding.inflate(inflater, parent, false);
        return new CommonBarcodeScannerViewHolder(binding.getRoot());
    }

    @Override
    public void
    onBindViewHolder(final CommonBarcodeScannerViewHolder viewHolder, final int position) {
        viewHolder.title.setText(context.getResources().getString(list.get(position).getTitle()));
        viewHolder.value.setText(list.get(position).getValue());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

