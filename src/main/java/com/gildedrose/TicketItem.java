package com.gildedrose;

public class TicketItem extends Item implements ItemInterface{
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
            checkMoreThan50();
            return;
        }
        if( timeLeft >5){
            quality +=2;
            checkMoreThan50();
            return;
        }
        quality +=3;
        checkMoreThan50();
    }
    public void checkMoreThan50(){
        if(quality >50)
            quality = 50;
    }
}
