package gildedRose.items;

import gildedRose.Item;

public class AgedBrieItem extends ItemStrategy {

    @Override
    public void update(Item item) {
        addOneQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            addOneQuality(item);
        }
    }
}
