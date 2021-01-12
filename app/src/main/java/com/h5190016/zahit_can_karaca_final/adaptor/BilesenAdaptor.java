package com.h5190016.zahit_can_karaca_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190016.zahit_can_karaca_final.R;
import com.h5190016.zahit_can_karaca_final.model.BilesenModel;
import com.h5190016.zahit_can_karaca_final.util.GlideUtil;


import java.util.List;

public class BilesenAdaptor extends RecyclerView.Adapter<BilesenViewHolder> {

    List<BilesenModel> bilesenler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }
    public BilesenAdaptor(List<BilesenModel> bilesenler, Context context, OnItemClickListener listener) {
        this.bilesenler = bilesenler;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public BilesenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bilesen,parent,false);
        return new BilesenViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BilesenViewHolder viewHolder, int position) {
        viewHolder.txtBilesenAdi.setText(bilesenler.get(position).getAdi());
        viewHolder.txtOrtalamaFiyat.setText(bilesenler.get(position).getFiyatAraligi());
        viewHolder.txtUreticiler.setText(bilesenler.get(position).getUreticileri());
        GlideUtil.resmiIndiripGoster(context,bilesenler.get(position).getKucukResimURL(),viewHolder.imgBilesenLogo);
    }

    @Override
    public int getItemCount() {
        return bilesenler.size();
    }
}