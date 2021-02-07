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

public class ItemCellViewHolder extends RecyclerView.ViewHolder {

    private ImageView mItemIcon;
    private TextView mName;
    private TextView mDesc;
    private TextView mPlaintext;
    private TextView mBaseGold;
    private TextView mTotalGold;
    private TextView mSellGold;

    public ItemCellViewHolder(@NonNull View itemView) {
        super(itemView);

        mItemIcon = itemView.findViewById(R.id.imgViewItemCellItemIcon);

        mName = itemView.findViewById(R.id.txtViewItemCellItemName);
        mDesc = itemView.findViewById(R.id.txtViewItemCellItemDesc);
        mPlaintext = itemView.findViewById(R.id.txtViewItemCellItemPlaintext);
        mBaseGold = itemView.findViewById(R.id.txtViewItemCellItemBaseGold);
        mTotalGold = itemView.findViewById(R.id.txtViewItemCellItemTotalGold);
        mSellGold = itemView.findViewById(R.id.txtViewItemCellItemSellGold);

    }

    public void setItemIcon(String image_url){
        Picasso.get().load(image_url).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_launcher_background).into(mItemIcon, new Callback() {
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

    public void setItemName(String itemName){
        mName.setText(itemName == null ? "null" : itemName.trim());
    }

    public void setItemDesc(String itemDesc){
        mDesc.setText(itemDesc == null ? "null" : itemDesc.trim());
    }

    public void setItemPlaintext(String plaintext){
        mPlaintext.setText(plaintext == null ? "null" : plaintext.trim());
    }

    public void setItemBaseGold(String baseGold){
        mBaseGold.setText(baseGold == null ? "null" : baseGold.trim());
    }

    public void setItemTotalGold(String totalGold){
        mTotalGold.setText(totalGold == null ? "null" : totalGold.trim());
    }

    public void setItemSellGold(String sellGold){
        mSellGold.setText(sellGold == null ? "null" : sellGold.trim());
    }

}
