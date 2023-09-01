package com.gildedrose;

public class Conjured extends InventoryItem {

    public static final String ITEMNAME = "Conjured";
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decrementQuality() {
        item.quality = Math.max(0, item.quality - 2);
    }

}
