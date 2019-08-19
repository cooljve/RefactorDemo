package gildedRose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
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
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.sellIn--;
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie":
                        addOneQuality(item);
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.quality = 0;
                        break;
                    default:
                        subtractOneQuality(item);
                        break;
                }
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