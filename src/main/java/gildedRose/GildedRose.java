package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateCase1(item);
            updateCase2(item);
            updateCase3(item);
        }
    }

    private void updateCase3(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                addOneQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else {
                subtractOneQuality(item);
            }
        }

    }

    private void updateCase2(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private void updateCase1(Item item) {
        switch (item.name) {
            case "Aged Brie":
                addOneQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality++;
                    updateBackstageQuality(item);
                }
                break;
            default:
                subtractOneQuality(item);
                break;
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