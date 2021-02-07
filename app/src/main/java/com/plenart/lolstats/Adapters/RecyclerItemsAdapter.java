package com.plenart.lolstats.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.LOLPOJO.Items.Item;
import com.plenart.lolstats.R;
import com.plenart.lolstats.ViewHolders.ChampionCellViewHolder;
import com.plenart.lolstats.ViewHolders.ItemCellViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecyclerItemsAdapter extends RecyclerView.Adapter<ItemCellViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    @NonNull
    @Override
    public ItemCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cell, parent, false);

        return new ItemCellViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCellViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.setItemIcon(item.getImage_url());
        holder.setItemName(item.getName());
        holder.setItemDesc(item.getDescription());
        holder.setItemPlaintext(item.getPlaintext());
        holder.setItemBaseGold(item.getGold().getBase());
        holder.setItemTotalGold(item.getGold().getTotal());
        holder.setItemSellGold(item.getGold().getSell_gold());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void addItems(List<Item> items){
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void clear(){
        this.itemList.clear();
    }

}
