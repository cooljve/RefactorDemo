package gildedRose;

import gildedRose.items.AgedBrieItem;
import gildedRose.items.BackstageItem;
import gildedRose.items.OtherItem;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    new AgedBrieItem().update(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    new BackstageItem().update(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    new OtherItem().update(item);
                    break;
            }
        }
    }
}