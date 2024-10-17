package com.gildedrose;

public class ConjuredItem extends Item implements ItemInterface{
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name,sellIn,quality);
    }
    public void updateSellIn(){
        sellIn--;
    }
    public void updateQuality(){
        if( quality <=0){
            return;
        }
        if(sellIn <=0){
            quality -=4;
        }else{
            quality -=2;
        }
        if(quality <0){
            quality =0;
        }
    }
}
