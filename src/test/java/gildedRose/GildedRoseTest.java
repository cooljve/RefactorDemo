package gildedRose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
  @Test
  public void testUpdateQualityForOther() {
    Item[] items = new Item[]{
        new Item("Other",1,10),
        new Item("Other",0,10),
    };
    GildedRose gildedRose = new GildedRose(items);

    gildedRose.updateQuality();

    assertEquals(9, items[0].quality);
    assertEquals(0, items[0].sellIn);
    assertEquals(8, items[1].quality);
    assertEquals(-1, items[1].sellIn);
  }

  @Test
  public void testUpdateQualityForAgedBrie() {
    Item[] items = new Item[]{
        new Item("Aged Brie",1,10),
        new Item("Aged Brie",0,10),
        new Item("Aged Brie",0,50),
    };
    GildedRose gildedRose = new GildedRose(items);

    gildedRose.updateQuality();

    assertEquals(11, items[0].quality);
    assertEquals(0, items[0].sellIn);
    assertEquals(12, items[1].quality);
    assertEquals(-1, items[1].sellIn);
    assertEquals(50, items[2].quality);
    assertEquals(-1, items[2].sellIn);
  }

  @Test
  public void testUpdateQualityForBackstage() {
    Item[] items = new Item[]{
        new Item("Backstage passes to a TAFKAL80ETC concert",10,10),
        new Item("Backstage passes to a TAFKAL80ETC concert",5,10),
        new Item("Backstage passes to a TAFKAL80ETC concert",0,10),
        new Item("Backstage passes to a TAFKAL80ETC concert",11,10),
        new Item("Backstage passes to a TAFKAL80ETC concert",1,50),
        new Item("Backstage passes to a TAFKAL80ETC concert",0,50),
        new Item("Backstage passes to a TAFKAL80ETC concert",5,49),
    };
    GildedRose gildedRose = new GildedRose(items);

    gildedRose.updateQuality();

    assertEquals(12, items[0].quality);
    assertEquals(9, items[0].sellIn);
    assertEquals(13, items[1].quality);
    assertEquals(4, items[1].sellIn);
    assertEquals(0, items[2].quality);
    assertEquals(-1, items[2].sellIn);
    assertEquals(11, items[3].quality);
    assertEquals(10, items[3].sellIn);
    assertEquals(50, items[4].quality);
    assertEquals(0, items[4].sellIn);
    assertEquals(0, items[5].quality);
    assertEquals(-1, items[5].sellIn);
    assertEquals(50, items[6].quality);
    assertEquals(4, items[6].sellIn);
  }

  @Test
  public void testUpdateQualityForSulfuras() {
    Item[] items = new Item[]{
        new Item("Sulfuras, Hand of Ragnaros",10,10),
        new Item("Sulfuras, Hand of Ragnaros",5,10),
        new Item("Sulfuras, Hand of Ragnaros",0,10),
    };
    GildedRose gildedRose = new GildedRose(items);

    gildedRose.updateQuality();

    assertEquals(10, items[0].quality);
    assertEquals(10, items[0].sellIn);
    assertEquals(10, items[1].quality);
    assertEquals(5, items[1].sellIn);
    assertEquals(10, items[2].quality);
    assertEquals(0, items[2].sellIn);
  }

}