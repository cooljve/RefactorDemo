package gildedRose.items;

import gildedRose.Item;

public class OtherItem extends ItemStrategy {
    @Override
    public void update(Item item) {
        subtractOneQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            subtractOneQuality(item);
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
