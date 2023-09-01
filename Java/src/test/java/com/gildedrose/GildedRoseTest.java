package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void nameRemainsTheSameAfterCallingUpdateQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemToStringDisplaysCorrectlyForRegularItem(){
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertEquals(items[0].toString(),"foo, -1, 0");
    }

    // Requirement: At the end of each day our system lowers both values for every item
    @Test
    void qualityAndSellInDecreaseForRegularItems() {
        Item[] items = new Item[] { new Item("Regular Item", 15, 15) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 14 && items[0].sellIn == 14);
    }

    // Requirement: Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void qualityDecreasesByTwoForRegularItem() {
        Item[] items = new Item[] { new Item("Regular Item", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 3);
    }

    @Test
    void qualityIncreasesByTwoForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 7);
    }

    // Requirement: The Quality of an item is never negative
    @Test
    void qualityNeverNegativeForRegularItem() {
        Item[] items = new Item[] { new Item("Regular Item", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality >= 0);
    }

    @Test
    void qualityNeverNegativeForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality >= 0);
    }

    @Test
    void qualityNeverNegativeForSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality >= 0);
    }

    @Test
    void qualityNeverNegativeForBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality >= 0);
    }

    // Requirement: "Aged Brie" actually increases in Quality the older it gets (and SellIn decreases)
    @Test
    void qualityIncreasesAsSellInDecreasesForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 6 && items[0].sellIn == 0);
    }

    //	Requirement: The Quality of an item is never more than 50
        @Test
    void qualityNeverGreaterThanFiftyForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 50);
    }

    @Test
    void qualityNeverGreaterThanFiftyForBackstagePassesSellInGreaterThanTen() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 50);
    }

    @Test
    void qualityNeverGreaterThanFiftyForBackstagePassesSellInGreaterThanFive() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 50);
    }

    @Test
    void qualityNeverGreaterThanFiftyForBackstagePassesSellInGreaterThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 50);
    }

    //	Requirement: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    @Test
    void qualityAndSellInNeverDecreaseForSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 50 && items[0].sellIn == 1);
    }

    //	Requirement: "Backstage passes" increase in Quality as its SellIn value approaches (and SellIn decreases)
    //	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    //	Quality drops to 0 after the concert
    @Test
    void qualityIncreasesAsSellInDecreasesForBackStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 11 && items[0].sellIn == 10);
    }

    @Test
    void qualityIncreasesByTwoWhenSellInIsTenOrLessForBackStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 12);
    }

    @Test
    void qualityIncreasesByThreeWhenSellInIsFiveOrLessForBackStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 13);
    }

    @Test
    void qualityDropsToZeroWhenSellInIsZeroForBackStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 0);
    }

    // Requirement: "Conjured" items degrade in Quality twice as fast as normal items (and SellIn decreases)
    @Test
    void qualityDecreasesTwiceAsFastForConjuredItems() {
        Item[] items = new Item[] { new Item("Conjured", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateInventory();
        assertTrue(items[0].quality == 8 && items[0].sellIn == 9);
    }

}
