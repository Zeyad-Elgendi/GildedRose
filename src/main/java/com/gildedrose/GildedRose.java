package com.gildedrose;

import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for( Item i : items){
            updateSellInDate(i);
            updateItemQuality(i);
        }
    }

    private void updateSellInDate(Item item){
        if(!Objects.equals(item.name, "Sulfuras, Hand of Ragnaros")){
            item.sellIn --;
        }
    }
    private void updateItemQuality(Item item){
        switch (item.name){
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                updateBetterWithTimeItems(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateTicketItems(item);
                break;
            default:
                updateNormalItems(item);
        }
        if(item.quality >50){
            item.quality =50;
        }
        if(item.quality <0){
            item.quality =0;
        }


    }

    private void updateBetterWithTimeItems(Item item){
        if(item.sellIn <=0){
            item.quality +=2;
        }else{
            item.quality ++;
        }
    }
    private void updateTicketItems(Item item){
        int timeLeft = item.sellIn;
        if(timeLeft <=0){
            item.quality =0;
            return;
        }
        if(timeLeft >10){
            item.quality ++;
            return;
        }
        if( timeLeft >5){
            item.quality +=2;
            return;
        }
        item.quality +=3;

    }
    private void updateNormalItems(Item item){
        if(item.sellIn <=0){
            item.quality -=2;
        }else{
            item.quality -=1;
        }
    }
}
