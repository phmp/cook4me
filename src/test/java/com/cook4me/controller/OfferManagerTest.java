package com.cook4me.controller;

import com.cook4me.model.Offer;
import org.junit.*;


/**
 * Created by Gaba on 2016-12-08.
 */

public class OfferManagerTest {
    private Offer offer;
    private OfferManager offerManager;
    private Offer nullOffer;
    private Offer almostNullOffer;

    @Before
    public void setUp(){
        offerManager = new OfferManager();
        offer = new Offer("bigos", "Krakow", "20.12.2016", "yummy stuff", "880880880");
        nullOffer = null;
        almostNullOffer = new Offer(null, null, null, null, null);

    }

    @Test
    public void testStoreOffer(){
        offerManager.store(offer);

        Assert.assertEquals(1, offerManager.getOffers().size());
        Assert.assertEquals(offer, offerManager.getOffer(offer.getId()));
        Assert.assertEquals("bigos", offerManager.getOffer(offer.getId()).getName());
        Assert.assertEquals(offer, offerManager.getOffers().get(0));
        Assert.assertNull(offerManager.getOffer(offer.getId() + 24));

    }
    @Test
    public void testStoreOffer2(){
        offerManager.store(offer);
        offerManager.store(offer);

        Assert.assertEquals(2, offerManager.getOffers().size());

    }

    @Test
    public void testStoreOffer3(){
        offerManager.store(offer);
        offerManager.store(almostNullOffer);
        offerManager.store(almostNullOffer);

        Assert.assertEquals(3, offerManager.getOffers().size());
        Assert.assertEquals(almostNullOffer, offerManager.getOffer(almostNullOffer.getId()));

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

    @Test(expected = NullPointerException.class)
    public void testNullPointerException2(){
        offerManager.store(nullOffer);

    }

}
