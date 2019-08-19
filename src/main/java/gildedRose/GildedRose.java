package gildedRose;

import gildedRose.items.*;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemStrategy strategy;
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    strategy = new AgedBrieItem();
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    strategy = new BackstageItem();
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    strategy = new SulfurasItem();
                    break;
                default:
                    strategy = new OtherItem();
            }
            strategy.update(item);
        }
    }
}