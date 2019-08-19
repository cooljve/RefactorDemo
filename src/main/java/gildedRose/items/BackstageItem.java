package gildedRose.items;

import gildedRose.Item;

public class BackstageItem extends ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
            updateBackstageQuality(item);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
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
}
