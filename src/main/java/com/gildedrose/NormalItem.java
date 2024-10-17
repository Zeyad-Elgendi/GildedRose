package com.gildedrose;

public class NormalItem extends Item implements ItemInterface{
    public NormalItem(String name, int sellIn, int quality) {
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
            quality -=2;
        }else{
            quality -=1;
        }
        if(quality <0)
            quality =0;
    }
}
