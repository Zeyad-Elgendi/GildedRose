package com.gildedrose;

public class AgingItem extends Item implements ItemInterface{
    public AgingItem(String name, int sellIn, int quality) {
        super(name,sellIn,quality);
    }
    public void updateSellIn(){
        sellIn--;
    }
    public void updateQuality(){
        if (quality >=50){
            return;
        }
        if(sellIn <=0){
            quality +=2;
        }else{
            quality ++;
        }
        if(quality >50)
            quality =50;

    }

}
