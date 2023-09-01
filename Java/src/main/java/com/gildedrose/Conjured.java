package com.gildedrose;

public class Conjured extends InventoryItem {

    public static final String ITEMNAME = "Conjured";
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decrementQuality() {
        item.quality = item.quality - 2;
    }

}
