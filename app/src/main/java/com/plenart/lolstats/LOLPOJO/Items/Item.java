package com.plenart.lolstats.LOLPOJO.Items;

public class Item {
    private String id;
    private String name;
    private String description;
    private String plaintext;
    private String image_url;
    private ItemGold gold;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public String getImage_url() {
        return image_url;
    }

    public ItemGold getGold() {
        return gold;
    }
}
