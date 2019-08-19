package gildedRose.items;

import gildedRose.Item;

public abstract class ItemStrategy {
    public abstract void update(Item item);
    void addOneQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
