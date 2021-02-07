package com.plenart.lolstats.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.ChampionClickListener;
import com.plenart.lolstats.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ChampionCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mChampionName;
    private ImageView mChampionIcon;

    private ChampionClickListener championClickListener;

    public ChampionCellViewHolder(@NonNull View itemView, ChampionClickListener championClickListener) {
        super(itemView);
        itemView.setOnClickListener(this); // jel treba dva dolje?

        this.championClickListener = championClickListener;

        mChampionName = itemView.findViewById(R.id.txtViewChampionCellChampionName);
        mChampionIcon = itemView.findViewById(R.id.imgViewChampionCellChampionIcon);

    }

    public void setChampionIcon(String square_img){
        Picasso.get().load(square_img).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_launcher_background).into(mChampionIcon, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("TAG","OnSuccess");
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void setChampionName(String name){
        mChampionName.setText(name == null ? "null" : name.trim() );
    }

    @Override
    public void onClick(View v) {
        championClickListener.onChampionClick(getAdapterPosition());
    }
}
