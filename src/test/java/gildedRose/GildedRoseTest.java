package gildedRose;

import org.junit.Test;

import static gildedRose.GildedRose.AGED_BRIE;
import static gildedRose.GildedRose.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT;
import static gildedRose.GildedRose.SULFURAS_HAND_OF_RAGNAROS;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    public static final String OTHER = "Other";

    @Test
  public void testUpdateQualityForOther() {
    Item[] items = new Item[]{
        new Item(OTHER,1,10),
        new Item(OTHER,0,10),
        new Item(OTHER,0,-1),
    };
    GildedRose gildedRose = new GildedRose(items);

    gildedRose.updateQuality();

    assertEquals(9, items[0].quality);
    assertEquals(0, items[0].sellIn);
    assertEquals(8, items[1].quality);
    assertEquals(-1, items[1].sellIn);
    assertEquals(-1, items[2].quality);
    assertEquals(-1, items[2].sellIn);
  }

  @Test
  public void testUpdateQualityForAgedBrie() {
    Item[] items = new Item[]{
        new Item(AGED_BRIE,1,10),
        new Item(AGED_BRIE,0,10),
        new Item(AGED_BRIE,0,50),
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
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,10,10),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,5,10),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,0,10),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,11,10),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,1,50),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,0,50),
        new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT,5,49),
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
        new Item(SULFURAS_HAND_OF_RAGNAROS,10,10),
        new Item(SULFURAS_HAND_OF_RAGNAROS,5,10),
        new Item(SULFURAS_HAND_OF_RAGNAROS,0,10),
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