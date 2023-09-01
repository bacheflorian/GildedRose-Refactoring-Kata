package com.gildedrose;

public class InventoryItem {

    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createItem(Item item) {
        if (item.name.equals(AgedBrie.ITEMNAME)) {
            return new AgedBrie(item);
        }
        else if (item.name.equals(BackstagePasses.ITEMNAME)) {
            return new BackstagePasses(item);
        }
        else if (item.name.equals(Sulfuras.ITEMNAME)) {
            return new Sulfuras(item);
        }
        else if (item.name.equals(Conjured.ITEMNAME)) {
            return new Conjured(item);
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
        decrementQuality();
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void updateDaysToExpiry() {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateQuality() {
        decrementQuality();
    }

}
