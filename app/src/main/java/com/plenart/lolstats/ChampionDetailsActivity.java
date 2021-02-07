package com.plenart.lolstats;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.concurrent.BlockingDeque;

public class ChampionDetailsActivity extends AppCompatActivity {

    private ImageView champSplash;

    private TextView champName;
    private TextView champTitle;
    private TextView champBlurb;
    private TextView champPartype;

    private TextView champAttack;
    private TextView champDef;
    private TextView champMagic;
    private TextView champDiff;

    private TextView champHp;
    private TextView champHpPerlvl;
    private TextView champMp;
    private TextView champMpPerlvl;
    private TextView champMovespeed;
    private TextView champArmor;
    private TextView champArmorPerlvl;
    private TextView champSpellblock;
    private TextView champSpellblockPerlvl;
    private TextView champAttackRange;
    private TextView champHpRegen;
    private TextView champHpRegenPerlvl;
    private TextView champMpRegen;
    private TextView champMpRegenPerlvl;
    private TextView champCrit;
    private TextView champCritPerlvl;
    private TextView champAttackDmg;
    private TextView champAttackDmgPerlvl;
    private TextView champAttackSpeedPerlvl;
    private TextView champAttackSpeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_details);
        initViews();

        Bundle bundle = getIntent().getExtras();
        setContentIntoViews(bundle);

    }

    private void initViews() {
        champSplash = (ImageView) findViewById(R.id.imgViewChampionSplashArt);
        champName = (TextView) findViewById(R.id.txtViewChampionDetailsChampionName);
        champTitle = (TextView) findViewById(R.id.txtViewChampionDetailsChampionTitle);
        champBlurb = (TextView) findViewById(R.id.txtViewChampionBlurb);
        champPartype = (TextView) findViewById(R.id.txtViewPartype);

        champAttack = (TextView) findViewById(R.id.txtViewAttack);
        champDef = (TextView) findViewById(R.id.txtViewDefense);
        champMagic = (TextView) findViewById(R.id.txtViewMagic);
        champDiff = (TextView) findViewById(R.id.txtViewDifficulty);

        champHp = (TextView) findViewById(R.id.txtViewHp);
        champHpPerlvl = (TextView) findViewById(R.id.txtViewHpperlevel);
        champMp = (TextView) findViewById(R.id.txtViewMp);
        champMpPerlvl = (TextView) findViewById(R.id.txtViewMpperlevel);
        champMovespeed = (TextView) findViewById(R.id.txtViewMovespeed);
        champArmor = (TextView) findViewById(R.id.txtViewArmor);
        champArmorPerlvl = (TextView) findViewById(R.id.txtViewArmorperlevel);
        champSpellblock = (TextView) findViewById(R.id.txtViewSpellblock);
        champSpellblockPerlvl = (TextView) findViewById(R.id.txtViewSpellblockperlevel);
        champAttackRange = (TextView) findViewById(R.id.txtViewAttackRange);
        champHpRegen = (TextView) findViewById(R.id.txtViewHpregen);
        champHpRegenPerlvl = (TextView) findViewById(R.id.txtViewHpregenperlevel);
        champMpRegen = (TextView) findViewById(R.id.txtViewMpregen);
        champMpRegenPerlvl = (TextView) findViewById(R.id.txtViewMpregenperlevel);
        champCrit = (TextView) findViewById(R.id.txtViewCrit);
        champCritPerlvl = (TextView) findViewById(R.id.txtViewCritperlevel);
        champAttackDmg = (TextView) findViewById(R.id.txtViewAttackDamage);
        champAttackDmgPerlvl = (TextView) findViewById(R.id.txtViewAttackDamageperlevel);
        champAttackSpeed = (TextView) findViewById(R.id.txtViewattackspeed);
        champAttackSpeedPerlvl = (TextView) findViewById(R.id.txtViewattackspeedperlevel);
    }

    private void setContentIntoViews(Bundle bundle) {
        if(bundle != null){
            String splash_url = bundle.getString("champion_splash");

            Picasso.get().load(splash_url).placeholder(R.mipmap.ic_launcher).error(R.drawable.ic_launcher_background).into(champSplash, new Callback() {
                @Override
                public void onSuccess() {
                    Log.d("TAG", "onSuccess: picasso load champ details ");
                }

                @Override
                public void onError(Exception e) {
                    Log.d("TAG", "onError: picasso load champ details ");
                }
            });

            champName.setText(bundle.getString("champion_name").trim());
            champTitle.setText(bundle.getString("champion_title").trim());
            champBlurb.setText(bundle.getString("champion_blurb").trim());
            champPartype.setText(bundle.getString("champion_partype").trim());

            setChampionInfoIntoViews(bundle);
            setChampionInfoStatsViews(bundle);

        }
    }

    private void setChampionInfoIntoViews(Bundle bundle) {
        champAttack.setText(bundle.getString("champion_attack"));
        champDef.setText(bundle.getString("champion_def"));
        champMagic.setText(bundle.getString("champion_magic"));
        champDiff.setText(bundle.getString("champion_diff"));
    }

    private void setChampionInfoStatsViews(Bundle bundle) {
        champHp.setText(bundle.getString("champion_hp").trim());
        champHpPerlvl.setText(bundle.getString("champion_hpperlevel").trim());
        champMp.setText(bundle.getString("champion_mp").trim());
        champMpPerlvl.setText(bundle.getString("champion_mpperlevel").trim());
        champMovespeed.setText(bundle.getString("champion_movespeed").trim());
        champArmor.setText(bundle.getString("champion_armor").trim());
        champArmorPerlvl.setText(bundle.getString("champion_armorperlevel").trim());
        champSpellblock.setText(bundle.getString("champion_spellblock").trim());
        champSpellblockPerlvl.setText(bundle.getString("champion_spellblockperlevel").trim());
        champAttackRange.setText(bundle.getString("champion_attackrange").trim());
        champHpRegen.setText(bundle.getString("champion_hpregen").trim());
        champHpRegenPerlvl.setText(bundle.getString("champion_hpregenperlevel").trim());
        champMpRegen.setText(bundle.getString("champion_mpregen").trim());
        champMpRegenPerlvl.setText(bundle.getString("champion_mpregenperlevel").trim());
        champCrit.setText(bundle.getString("champion_crit").trim());
        champCritPerlvl.setText(bundle.getString("champion_critperlevel").trim());
        champAttackDmg.setText(bundle.getString("champion_attackdamage").trim());
        champAttackDmgPerlvl.setText(bundle.getString("champion_attackdamageperlevel").trim());
        champAttackSpeedPerlvl.setText(bundle.getString("champion_attackspeedperlevel").trim());
        champAttackSpeed.setText(bundle.getString("champion_attackspeed").trim());
    }


}