package com.plenart.lolstats.API;

import com.plenart.lolstats.LOLPOJO.Champions.Champion;
import com.plenart.lolstats.LOLPOJO.Items.Item;
import com.plenart.lolstats.LOLPOJO.Runes.Rune;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("601a6ba5dde2a87f921d9420/7")
    Call<List<Champion>> getChampions();

    @GET("601af142f4ebad5763751dd5/1")
    Call<List<Item>> getItems();

    @GET("601bc73ec033606410a74112")
    Call<List<Rune>> getRunes();

}
