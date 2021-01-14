package com.h5190016.zahit_can_karaca_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.h5190016.zahit_can_karaca_final.R;
import com.h5190016.zahit_can_karaca_final.adaptor.BilesenAdaptor;
import com.h5190016.zahit_can_karaca_final.model.BilesenModel;
import com.h5190016.zahit_can_karaca_final.network.Service;
import com.h5190016.zahit_can_karaca_final.util.AlertDialogUtil;
import com.h5190016.zahit_can_karaca_final.util.Constants;
import com.h5190016.zahit_can_karaca_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }

    private void init() {
        bilesenleriGetir();
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.app_wait));
        progressDialog.show();
    }


    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogShow(ListeActivity.this, getResources().getString(R.string.app_exitButton),getResources().getString(R.string.app_exitButtonMessage),getResources().getString(R.string.app_yes),getResources().getString(R.string.app_exit),getResources().getString(R.string.listeActivity));
    }


    void  bilesenleriGetir() {
        new Service().getServiceApi().bilesenleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BilesenModel>>() {

                    List<BilesenModel> bilesenler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<BilesenModel> bilesenList) {
                        bilesenler=bilesenList;
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete()
                    {
                        if(bilesenler.size()>0) {
                            initRecycleView(bilesenler);
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    private  void  initRecycleView(final List<BilesenModel> bilesenList) {
        recyclerView =findViewById(R.id.rcvBilesenler);
        BilesenAdaptor bilesenAdaptor =new BilesenAdaptor(bilesenList, getApplicationContext(), new BilesenAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                BilesenModel tiklananBilesen =bilesenList.get(position);
                openNextActivity(tiklananBilesen);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(bilesenAdaptor);
    }

    private void openNextActivity(BilesenModel tiklananBilesen){
        Intent secondActivityIntent=new Intent(getApplicationContext(),BilesenDetayActivity.class);
        String tiklananBilesenString= ObjectUtil.bilesenToJsonString(tiklananBilesen);
        secondActivityIntent.putExtra(Constants.TIKANAN_BILESEN_TASINANIN_BASLIGI,tiklananBilesenString);
        startActivity(secondActivityIntent);
    }

}
