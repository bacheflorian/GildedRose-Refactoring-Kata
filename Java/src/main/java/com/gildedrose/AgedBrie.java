package com.gildedrose;

public class AgedBrie extends InventoryItem {
    public static final String ITEMNAME = "Aged Brie";

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
