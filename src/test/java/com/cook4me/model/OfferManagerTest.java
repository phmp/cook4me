package com.cook4me.model;

import com.cook4me.controller.OfferManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Gaba on 2016-12-08.
 */
public class OfferManagerTest {
    private Offer offer;

    @Before
    public void setUp(){
       offer = new Offer("bigos", "Krakow", "20.12.2016", "yummy stuff", "880880880");

    }

    @Test
    public void testStoreOffer(){
        OfferManager offerManager = new OfferManager();
        offerManager.store(offer);

        Assert.assertEquals(1, offerManager.getOffers().size());
        Assert.assertEquals(offer, offerManager.getOffer(offer.getId()));
        Assert.assertEquals("bigos", offerManager.getOffer(offer.getId()).getName());


    }
}
