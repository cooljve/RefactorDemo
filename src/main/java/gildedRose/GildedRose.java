package gildedRose;

import gildedRose.items.*;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemStrategy strategy;
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    strategy = new AgedBrieItem();
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    strategy = new BackstageItem();
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    strategy = new SulfurasItem();
                    break;
                default:
                    strategy = new OtherItem();
            }
            strategy.update(item);
        }
    }
}