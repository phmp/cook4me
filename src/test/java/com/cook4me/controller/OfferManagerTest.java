package com.cook4me.controller;

import com.cook4me.model.Offer;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Gaba on 2016-12-08.
 */

public class OfferManagerTest {
    private Offer offer;
    private OfferManager offerManager;
    private Offer nullOffer;
    private Offer offerWithNullFields;

    @Before
    public void setUp(){
        offerManager = new OfferManager();
        offer = new Offer("bigos", "Krakow", "20.12.2016", "yummy stuff", "880880880");
        nullOffer = null;
        offerWithNullFields = new Offer(null, null, null, null, null);

    }

    @Test
    public void idShouldBeAddedToOffer(){
        offerManager.store(offer);
        int actualOfferListSize = offerManager.getOffers().size();
        long offersId = offer.getId();
        Offer actualOffer = offerManager.getOffer(offersId);
        List actualListOfOffers = offerManager.getOffers();

        assertEquals("The size of list of offers should be 1.", 1, actualOfferListSize);
        assertEquals("Input offer should be returned.", offer, actualOffer);
        assertEquals("Name of returned offer should be <<bigos>>.", "bigos", actualOffer.getName());
        assertEquals("First element of list of offers should be input offer.", offer, actualListOfOffers.get(0));
        assertNull("Accessing offer with id that is not in the list should return null.", offerManager.getOffer(offersId + 24));

    }
    @Test
    public void everyOfferShouldBeAddedEvenIfItIsDuplicate(){
        offerManager.store(offer);
        offerManager.store(offer);
        int actualOfferListSize = offerManager.getOffers().size();

        assertEquals("The size of list of offers should be 2.",2, actualOfferListSize);

    }

    @Test
    public void offerWithNullFieldsShouldBeAdded(){
        offerManager.store(offer);
        offerManager.store(offerWithNullFields);
        offerManager.store(offerWithNullFields);
        int actualOfferListSize = offerManager.getOffers().size();
        long offerWithNullFieldsId = offerWithNullFields.getId();

        assertEquals("The size of list of offers should be 3.",3, actualOfferListSize);
        assertEquals("Input offer(with null fields) should be returned.", offerWithNullFields, offerManager.getOffer(offerWithNullFieldsId));

    }

    @Test
    public void getOffersShouldReturnAList(){
        offerManager.store(offer);

        assertNotEquals("getOffers should return list, not a single object.", offer, offerManager.getOffers());
        assertNull("Accessing offer with id that is not in the list should return null.", offerManager.getOffer(2L));

    }

    @Ignore("Until solution for getOffer is chosen - returning null or handling it.")
    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionShouldBeThrown(){
        offerManager.getOffer(12L).getName();

    }

    @Test(expected = Exception.class)
    public void exceptionShouldBeThrown(){
        offerManager.store(nullOffer);

    }

}
