package gildedRose.items;

import gildedRose.Item;

public class AgedBrieItem implements ItemStrategy {

    private void addOneQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    @Override
    public void update(Item item) {
        addOneQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            addOneQuality(item);
        }
    }
}
