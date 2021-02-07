package com.plenart.lolstats.LOLPOJO.Champions;

public class Champion {

    private String id;
    private String key;
    private String name;
    private String title;
    private String splash_url;
    private String square_img;
    private String partype;
    private String blurb;
    private ChampionInfo info;
    private ChampionStats stats;

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getSplash_url() {
        return splash_url;
    }

    public String getSquare_img() {
        return square_img;
    }

    public String getPartype() {
        return partype;
    }

    public String getBlurb() {
        return blurb;
    }

    public ChampionInfo getInfo() {
        return info;
    }

    public ChampionStats getStats() {
        return stats;
    }
}
