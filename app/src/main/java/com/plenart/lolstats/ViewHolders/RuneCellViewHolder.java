package com.plenart.lolstats.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.plenart.lolstats.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class RuneCellViewHolder extends RecyclerView.ViewHolder {

    private ImageView mRuneIcon;
    private TextView mRuneName;
    private TextView mRunePath;
    private TextView mRuneKeystone;
    private TextView mRuneDesc;

    public RuneCellViewHolder(@NonNull View itemView) {
        super(itemView);

        mRuneIcon = itemView.findViewById(R.id.imgViewRuneCellRuneIcon);

        mRuneName = itemView.findViewById(R.id.txtViewRuneCellRuneName);
        mRunePath = itemView.findViewById(R.id.txtViewRuneCellRunePath);
        //mRuneKeystone = itemView.findViewById(R.id.txtViewRuneCellRuneKeystone);
        mRuneDesc = itemView.findViewById(R.id.txtViewRuneCellRuneDesc);
    }

    public void setRuneIcon(String rune_url){
        Picasso.get().load(rune_url).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_launcher_background).into(mRuneIcon, new Callback() {
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

    public void setRuneName(String runeName){
        mRuneName.setText(runeName == null ? "null":runeName.trim());
    }

    public void setRunePath(String runePath){
        mRunePath.setText(runePath == null ? "null" : runePath.trim());
    }
    /*
    public void setRuneKeystone(String runeKeystone){
       mRuneKeystone.setText(runeKeystone == null ? "null": runeKeystone.trim());
    }
    */
    public void setRuneDesc(String runeDesc){
        mRuneDesc.setText(runeDesc == null ? "null" : runeDesc.trim());
    }

}