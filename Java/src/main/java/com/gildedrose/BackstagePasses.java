package com.gildedrose;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void processExpired() {
        item.quality = 0;
    }

    @Override
    protected void updateQuality() {
        incrementQuality();
        if (item.sellIn < 11) {
            incrementQuality();
        }
        if (item.sellIn < 6) {
            incrementQuality();
        }
    }
}
