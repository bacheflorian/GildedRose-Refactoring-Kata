package com.gildedrose;

public class Sulfuras extends InventoryItem {
    public static final String ITEMNAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void processExpired() {}

    @Override
    protected void updateDaysToExpiry() {}

    @Override
    protected void updateQuality() {}

}
