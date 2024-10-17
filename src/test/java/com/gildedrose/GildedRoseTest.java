package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    //Normal items test
    @Test
    void normalItemsDegradesWithTime() {
        Item[] items = new Item[] { new NormalItem("normal item", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }
    @Test
    void expiredItemsDegradeTwiceAsFast() {
        Item[] items = new Item[] { new NormalItem("normal item", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }
    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new NormalItem("normal item", 4, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void normalItemSellInDecreasesByOne() {
        Item[] items = new Item[] { new NormalItem("normal item", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
    }
    @Test
    void expiredItemsDegradeButNeverGoesLowerThan0() {
        Item[] items = new Item[] { new NormalItem("normal", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void itemToStringReturnsDescription() {
        Item item = new NormalItem("Normal Item", 5, 10) ;

        assertEquals("Normal Item, 5, 10", item.toString());
    }
    //aged brie test
    @Test
    void agedBrieQualityIncreaseWithTime(){
        // make new item "brie"
        Item[] items = new Item[] { new AgingItem("Aged Brie", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // make sure quality increases with time
        assertEquals(2,app.items[0].quality);
    }
    @Test
    void agedBrieQualityNeverMoreThan50(){
        // make new item "brie"
        Item[] items = new Item[] { new AgingItem("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // make sure quality increases with time
        assertEquals(50,app.items[0].quality);
    }
    @Test
    void agedBrieSellInDecreasesByOne() {
        Item[] items = new Item[] { new AgingItem("Aged Brie", 4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
    }
    @Test
    void backstagePassesQuality() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void agedBrieQualityImprovesAfterExpirationBy2() {
        Item[] items = new Item[] { new AgingItem("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void agedBrieQualityImprovesAfterExpirationButDoesNotExceed50() {
        Item[] items = new Item[] { new AgingItem("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    //legendary Items Tests
    @Test
    void legendaryItemsNeverDecreasesInQuality() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }
    @Test
    void legendaryItemsNeverHasToBeSold() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
    }
    @Test
    void expiredLegendaryItemsDoNotDegrade() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }
    @Test
    void legendaryItemsQualityDoesNotIncrease() {
        Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }
    @Test
    void backstagePassesIncreaseByOneMoreThan10daysBeforeConcert() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 12, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void backstagePassesIncreaseByTwoLessThan10daysBeforeConcert() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
    @Test
    void backstagePassesIncreaseByTwoLessThan10daysBeforeConcert2() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 9, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
    @Test
    void backstagePassesIncreaseByThreeLessThan5daysBeforeConcert() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void backstagePassesIncreaseByThreeLessThan5daysBeforeConcert2() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 3, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void backstagePassesDropToZeroWhenTheirTimePasses() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void backstagePassesQualityNeverExceeds50() {
        Item[] items = new Item[] { new TicketItem("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void agedBrieQualityImprovesAfterExpirationButDoesNotExceedFifty2() {
        Item[] items = new Item[] { new AgingItem("Aged Brie", -1, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void expiredQualityIsNeverNegative() {
        Item[] items = new Item[] { new NormalItem("normal item", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }




}
