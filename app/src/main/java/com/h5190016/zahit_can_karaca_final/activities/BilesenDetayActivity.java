package com.h5190016.zahit_can_karaca_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190016.zahit_can_karaca_final.R;
import com.h5190016.zahit_can_karaca_final.model.BilesenModel;
import com.h5190016.zahit_can_karaca_final.util.Constants;
import com.h5190016.zahit_can_karaca_final.util.GlideUtil;
import com.h5190016.zahit_can_karaca_final.util.ObjectUtil;

public class BilesenDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik, txtFiyatAraligi, txtUretici, txtHakkinda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilesen_detay);
        init();
    }
    private void init(){

        String tasinanBilesenString=getIntent().getStringExtra(Constants.TIKANAN_BILESEN_TASINANIN_BASLIGI);
        BilesenModel bilesenModel= ObjectUtil.jsonStringToBilesen(tasinanBilesenString);
        imgKapak=findViewById(R.id.imgKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtHakkinda=findViewById(R.id.txtHakkinda);
        txtUretici=findViewById(R.id.txtUretici);
        txtFiyatAraligi=findViewById(R.id.txtFiyatAraligi);
        String html = bilesenModel.getHakkinda();
        txtBaslik.setText((bilesenModel.getAdi()));
        txtUretici.setText((bilesenModel.getUreticileri()));
        txtFiyatAraligi.setText((bilesenModel.getFiyatAraligi()));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtHakkinda.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        } else{
            txtHakkinda.setText(Html.fromHtml(html));
        }
        GlideUtil.resmiIndiripGoster(getApplicationContext(),bilesenModel.getBuyukResimURL(),imgKapak);
    }
}