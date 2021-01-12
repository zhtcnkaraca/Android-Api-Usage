package com.h5190016.zahit_can_karaca_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190016.zahit_can_karaca_final.R;

public class BilesenViewHolder extends RecyclerView.ViewHolder {

    ImageView imgBilesenLogo;
    TextView txtBilesenAdi, txtOrtalamaFiyat, txtUreticiler;

    public BilesenViewHolder(@NonNull View cardView, BilesenAdaptor.OnItemClickListener listener) {
        super(cardView);
        imgBilesenLogo =cardView.findViewById(R.id.imgBilesenLogo);
        txtBilesenAdi =cardView.findViewById(R.id.txtBilesenAdi);
        txtOrtalamaFiyat =cardView.findViewById(R.id.txtOrtalamaFiyat);
        txtUreticiler =cardView.findViewById(R.id.txtUreticiler);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}