package com.h5190016.zahit_can_karaca_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190016.zahit_can_karaca_final.util.AlertDialogUtil;
import com.h5190016.zahit_can_karaca_final.util.NetworkUtil;
import com.h5190016.zahit_can_karaca_final.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer();
    }

    public void timer(){
        CountDownTimer countDownTimer =new
                CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long l) {
                    }
                    @Override
                    public void onFinish() {

                        if(NetworkUtil.internetControl(getApplicationContext())) {
                            nextPage();
                        }
                        else {
                            AlertDialogUtil.alertDialogShow(SplashActivity.this, getResources().getString(R.string.app_attention),getResources().getString(R.string.app_internetControlInfo),getResources().getString(R.string.app_settings),getResources().getString(R.string.app_exit),getResources().getString(R.string.splashActivity));
                        }
                    }
                };
        countDownTimer.start();
    }

    public void nextPage(){
        Intent nextPageActivity=new Intent(getApplicationContext(),ListeActivity.class);
        startActivity(nextPageActivity);
        finish();
    }

}