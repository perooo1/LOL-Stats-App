package com.plenart.lolstats.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.API.ServiceAPI;
import com.plenart.lolstats.ChampionClickListener;
import com.plenart.lolstats.Fragments.ChampionsFragment;
import com.plenart.lolstats.LOLPOJO.Champions.Champion;
import com.plenart.lolstats.MainActivity;
import com.plenart.lolstats.R;
import com.plenart.lolstats.ViewHolders.ChampionCellViewHolder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerChampionsAdapter extends RecyclerView.Adapter<ChampionCellViewHolder> {

    private List<Champion> championList = new ArrayList<>();
    private ChampionClickListener championClickListener;

    public RecyclerChampionsAdapter(List<Champion> championList, ChampionClickListener championClickListener){
        this.championList = championList;
        this.championClickListener = championClickListener;
    }

    @NonNull
    @Override
    public ChampionCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.champion_cell, parent, false);

        return new ChampionCellViewHolder(cellView, championClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionCellViewHolder holder, int position) {
        Champion champion = championList.get(position);
        holder.setChampionIcon(champion.getSquare_img());
        holder.setChampionName(champion.getName());
    }

    @Override
    public int getItemCount() {
        return championList.size();
    }

    public void addChampions(List<Champion> champions){
        this.championList.addAll(champions);
        notifyDataSetChanged();
    }

    public void  clear(){
        this.championList.clear();
    }

}
