package com.gildedrose;

public class AgedBrie extends InventoryItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void processExpired() {
        incrementQuality();
    }

    @Override
    protected void updateQuality() {
         incrementQuality();
    }
}
