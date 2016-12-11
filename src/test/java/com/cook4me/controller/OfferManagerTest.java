package com.cook4me.controller;

import com.cook4me.model.Offer;
import org.junit.*;


/**
 * Created by Gaba on 2016-12-08.
 */

public class OfferManagerTest {
    private Offer offer;
    private OfferManager offerManager;

    @Before
    public void setUp(){
        offerManager = new OfferManager();
        offer = new Offer("bigos", "Krakow", "20.12.2016", "yummy stuff", "880880880");
        }

    @Test
    public void testStoreOffer(){
        offerManager.store(offer);

        Assert.assertEquals(1, offerManager.getOffers().size());
        Assert.assertEquals(offer, offerManager.getOffer(offer.getId()));
        Assert.assertEquals("bigos", offerManager.getOffer(offer.getId()).getName());
        Assert.assertEquals(offer, offerManager.getOffers().get(0));

    }

    @Test
    public void negativeTest(){
        Assert.assertNotEquals(offer, offerManager.getOffers());
        Assert.assertNull(offerManager.getOffer((long) 2));

    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException(){
        offerManager.getOffer((long) 12).getName();
        offerManager.getOffer((long) 34).getId();

    }



}
