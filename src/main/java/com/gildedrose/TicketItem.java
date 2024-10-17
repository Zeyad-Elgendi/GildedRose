package com.gildedrose;

public class TicketItem extends Item {
    public TicketItem(String name, int sellIn, int quality) {
        super(name,sellIn,quality);
    }
    public void updateSellIn(){
        sellIn--;
    }
    public void updateQuality(){
        int timeLeft = sellIn;
        if(timeLeft <=0){
            quality =0;
            return;
        }
        if(timeLeft >10){
            quality ++;
            return;
        }
        if( timeLeft >5){
            quality +=2;
            return;
        }
        quality +=3;
    }
}
