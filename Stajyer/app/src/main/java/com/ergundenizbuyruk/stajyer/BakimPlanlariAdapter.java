package com.ergundenizbuyruk.stajyer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ergundenizbuyruk.stajyer.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class BakimPlanlariAdapter extends RecyclerView.Adapter<BakimPlanlariAdapter.BakimPlaniHolder> {

    private ArrayList<BakimPlani> bakimPlaniArrayList;

    public BakimPlanlariAdapter(ArrayList<BakimPlani> bakimPlaniArrayList) {
        this.bakimPlaniArrayList = bakimPlaniArrayList;
    }

    public class BakimPlaniHolder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;

        public BakimPlaniHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }

    @NonNull
    @Override
    public BakimPlaniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding
                = RecyclerRowBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new BakimPlaniHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BakimPlaniHolder holder, int position) {
        holder.recyclerRowBinding.recyclerViewHastaAdiText
                .setText(bakimPlaniArrayList.get(position).getHastaAdi());
    }

    @Override
    public int getItemCount() {
        return bakimPlaniArrayList.size();
    }



}

