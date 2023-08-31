package com.gildedrose;

public class InventoryItem {

    public static final String BRIE = "Aged Brie";
    private Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createItem(Item item) {
        if (item.name.equals(BRIE)) {
            return new AgedBrie(item);
        }
        return new InventoryItem(item);
    }

    public void updateItem() {
        updateQuality();
        updateDaysToExpiry();
        if (isExpired()) {
            processExpired();
        }
    }

    protected void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void incrementQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void processExpired() {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    return;
        }
        else {
            decrementQuality();
        }
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void updateDaysToExpiry() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    protected void updateQuality() {
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality();
            if (item.sellIn < 11) {
                incrementQuality();
            }
            if (item.sellIn < 6) {
                incrementQuality();
            }
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    return;
        }
        else {
            decrementQuality();
        }
    }

}
