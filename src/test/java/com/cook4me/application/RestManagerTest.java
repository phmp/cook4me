package com.cook4me.application;

import com.cook4me.controller.OfferManager;
import com.cook4me.controller.OfferService;
import com.cook4me.model.Offer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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
    private OfferService mockOfferService;

    @InjectMocks
    private RestManager restManager;

    private Offer offer;

    @Before
    public void setUp(){
      mockOfferService = mock(OfferService.class);
      offer = new Offer("pierogi", "Krakow", "11.04.2014", "ruskie", "888888888");
      restManager = new RestManager();

      MockitoAnnotations.initMocks(this);
      when(mockOfferService.store(offer)).thenReturn(offer);

    }

    @Test
    public void restManagerShouldUseOfferManagerToStore(){
        Offer storedOffer = restManager.storeOffer(offer);
        verify(mockOfferService, times(1)).store(offer);
        when(mockOfferService.getOffers()).thenReturn(new ArrayList<Offer>(){{add(offer);}});
        List actualOfferList = restManager.getOffers();
        int actualOfferListSize = restManager.getOffers().size();


        assertEquals("Input offer should be returned.", offer, storedOffer);
        assertEquals("Name of returned offer should be <<pierogi>>.", "pierogi", storedOffer.getName());
        assertEquals("The size of list of offers should be 1.",1, actualOfferListSize);
        assertEquals("First element of list of offers should be input offer.",offer, actualOfferList.get(0));

    }


}
