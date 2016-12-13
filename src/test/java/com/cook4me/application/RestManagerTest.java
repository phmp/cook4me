package com.cook4me.application;

import com.cook4me.controller.OfferManager;
import com.cook4me.model.Offer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.junit.Assert.*;

/**
 * Created by Gaba on 2016-12-10.
 */
public class RestManagerTest {
    @Mock
    private OfferManager offerManager;

    @InjectMocks
    private RestManager restManager;

    private Offer offer;

    @Before
    public void setUp(){
      offerManager = mock(OfferManager.class);
      offer = new Offer("pierogi", "Krakow", "11.04.2014", "ruskie", "888888888");
      restManager = new RestManager();

      MockitoAnnotations.initMocks(this);
      when(offerManager.store(offer)).thenReturn(offer);

    }

    @Test
    public void testStoreOffer1(){
        Offer storedOffer = restManager.storeOffer(offer);
        verify(offerManager, times(1)).store(offer);
        when(offerManager.getOffers()).thenReturn(new ArrayList<Offer>(){{add(offer);}});

        assertEquals(offer, storedOffer);
        assertEquals("pierogi", storedOffer.getName());
        assertEquals(1, restManager.getOffers().size());
        assertEquals(offer, restManager.getOffers().get(0));

    }

    @Test
    public void testStoreOffer2(){
        System.out.println("no more test cases because it is all delegation");

    }


}
