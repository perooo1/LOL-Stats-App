package com.plenart.lolstats.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.plenart.lolstats.API.ServiceAPI;
import com.plenart.lolstats.Adapters.RecyclerChampionsAdapter;
import com.plenart.lolstats.ChampionClickListener;
import com.plenart.lolstats.ChampionDetailsActivity;
import com.plenart.lolstats.LOLPOJO.Champions.Champion;
import com.plenart.lolstats.MainActivity;
import com.plenart.lolstats.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChampionsFragment extends Fragment implements ChampionClickListener {

    private RecyclerView recyclerChampions;
    private RecyclerChampionsAdapter adapter;

    private Call<List<Champion>> apiCall;
    private List<Champion> championList = new ArrayList<>();

    public static ChampionsFragment newInstance() {
        ChampionsFragment fragment = new ChampionsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_champions, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerChampions = view.findViewById(R.id.recyclerChampions);
        recyclerChampions.setLayoutManager(new LinearLayoutManager(view.getContext()));
        setupApiCall();
        adapter = new RecyclerChampionsAdapter(championList,this);
        recyclerChampions.setAdapter(adapter);
    }

    private void setupApiCall() {
        apiCall = ServiceAPI.getApiInterface().getChampions();

        apiCall.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                if(response.isSuccessful() && response.body() != null){
                    if(response.body().size() == 0){
                        showToast("no result on champions api enqueue");
                    }
                    else{
                        adapter.addChampions(response.body());
                        for (Champion champion : response.body()){
                            System.out.println(champion.getName());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {
                Log.d("ON_FAILURE", "Kod poziva api champions");
                showToast("Unable to make champions api call" + t.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onChampionClick(int position) {
        Log.d("TAG", "onChampionClick: clicked " + position);
        Bundle bundle = new Bundle();
        addItemsToBundle(bundle, position);

        Intent intent = new Intent(this.getContext(), ChampionDetailsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void addItemsToBundle(Bundle bundle, int position) {
        bundle.putString("champion_name", championList.get(position).getName());
        bundle.putString("champion_splash",championList.get(position).getSplash_url());
        bundle.putString("champion_title",championList.get(position).getTitle());
        bundle.putString("champion_partype",championList.get(position).getPartype());
        bundle.putString("champion_blurb",championList.get(position).getBlurb());

        bundle.putString("champion_attack",championList.get(position).getInfo().getAttack());
        bundle.putString("champion_def",championList.get(position).getInfo().getDefense());
        bundle.putString("champion_magic",championList.get(position).getInfo().getMagic());
        bundle.putString("champion_diff",championList.get(position).getInfo().getDifficulty());

        bundle.putString("champion_hp",championList.get(position).getStats().getHp());
        bundle.putString("champion_hpperlevel",championList.get(position).getStats().getHpperlevel());
        bundle.putString("champion_mp",championList.get(position).getStats().getMp());
        bundle.putString("champion_mpperlevel",championList.get(position).getStats().getMpperlevel());
        bundle.putString("champion_movespeed",championList.get(position).getStats().getMovespeed());
        bundle.putString("champion_armor",championList.get(position).getStats().getArmor());
        bundle.putString("champion_armorperlevel",championList.get(position).getStats().getArmorperlevel());
        bundle.putString("champion_spellblock",championList.get(position).getStats().getSpellblock());
        bundle.putString("champion_spellblockperlevel",championList.get(position).getStats().getSpellblockperlevel());
        bundle.putString("champion_attackrange",championList.get(position).getStats().getAttackrange());
        bundle.putString("champion_hpregen",championList.get(position).getStats().getHpregen());
        bundle.putString("champion_hpregenperlevel",championList.get(position).getStats().getHpregenperlevel());
        bundle.putString("champion_mpregen",championList.get(position).getStats().getMpregen());
        bundle.putString("champion_mpregenperlevel",championList.get(position).getStats().getMpregenperlevel());
        bundle.putString("champion_crit",championList.get(position).getStats().getCrit());
        bundle.putString("champion_critperlevel",championList.get(position).getStats().getCritperlevel());
        bundle.putString("champion_attackdamage",championList.get(position).getStats().getAttackdamage());
        bundle.putString("champion_attackdamageperlevel",championList.get(position).getStats().getAttackdamageperlevel());
        bundle.putString("champion_attackspeedperlevel",championList.get(position).getStats().getAttackspeedperlevel());
        bundle.putString("champion_attackspeed",championList.get(position).getStats().getAttackspeed());
    }
}