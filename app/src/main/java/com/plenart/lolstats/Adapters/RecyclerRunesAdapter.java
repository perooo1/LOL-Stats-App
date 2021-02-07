package com.plenart.lolstats.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.LOLPOJO.Runes.Rune;
import com.plenart.lolstats.R;
import com.plenart.lolstats.ViewHolders.ItemCellViewHolder;
import com.plenart.lolstats.ViewHolders.RuneCellViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecyclerRunesAdapter extends RecyclerView.Adapter<RuneCellViewHolder> {

    private List<Rune> runeList = new ArrayList<>();

    @NonNull
    @Override
    public RuneCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rune_cell, parent, false);

        return new RuneCellViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull RuneCellViewHolder holder, int position) {
        Rune rune = runeList.get(position);

        holder.setRuneIcon(rune.getRune_url());
        holder.setRuneName(rune.getName());
        holder.setRunePath(rune.getPath());
        //holder.setRuneKeystone(rune.getKeystone());
        holder.setRuneDesc(rune.getDescription());
    }

    @Override
    public int getItemCount() {
        return runeList.size();
    }

    public void addRunes(List<Rune> runes){
        this.runeList.addAll(runes);
        notifyDataSetChanged();
    }

    public void clear(){
        this.runeList.clear();
    }

}
