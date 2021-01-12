package com.h5190016.zahit_can_karaca_final.network;

import com.h5190016.zahit_can_karaca_final.model.BilesenModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("pcBilesenleri.json")
    Observable<List<BilesenModel>> bilesenleriGetir();
}
