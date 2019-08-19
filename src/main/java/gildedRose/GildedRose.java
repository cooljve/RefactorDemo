package gildedRose;

import gildedRose.items.AgedBrieItem;

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
                    if (item.quality < 50) {
                        item.quality++;
                        updateBackstageQuality(item);
                    }
                    item.sellIn--;
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    subtractOneQuality(item);
                    item.sellIn--;
                    if (item.sellIn < 0) {
                        subtractOneQuality(item);
                    }
                    break;
            }
        }
    }

    private void updateBackstageQuality(Item item) {
        if (item.sellIn < 11) {
            addOneQuality(item);
        }
        if (item.sellIn < 6) {
            addOneQuality(item);
        }
    }

    private void addOneQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void subtractOneQuality(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality--;
            }
        }
    }
}