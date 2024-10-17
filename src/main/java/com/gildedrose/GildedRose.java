package com.gildedrose;

import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for( Item i : items){
            ((ItemInterface)i).updateSellIn();
            ((ItemInterface)i).updateQuality();
        }
    }
}
