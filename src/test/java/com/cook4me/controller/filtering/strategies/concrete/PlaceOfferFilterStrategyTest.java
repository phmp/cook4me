package com.cook4me.controller.filtering.strategies.concrete;

import com.cook4me.model.Offer;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * Created by eadalac on 2017-02-04.
 */
public class PlaceOfferFilterStrategyTest {

    @Test
    public void shouldFilterWenSubstringNotExists(){
        PlaceOfferFilterStrategy palceOfferFilterStrategySUT = new PlaceOfferFilterStrategy();
        palceOfferFilterStrategySUT.setConfigurationStrings(Arrays.asList("Krakow", "komandosow", "10"));
        Offer offer = Mockito.mock(Offer.class);
        Mockito.when(offer.getPlace()).thenReturn("Warszawa Wiejska 2");

        Boolean filteringResult = palceOfferFilterStrategySUT.meetCriteria(offer);

        assertThat(filteringResult).isFalse();
    }

    @Test
    public void shouldNotFilterWenSubstringExists(){
        PlaceOfferFilterStrategy palceOfferFilterStrategySUT = new PlaceOfferFilterStrategy();
        palceOfferFilterStrategySUT.setConfigurationStrings(Arrays.asList("Krakow", "komandosow", "10"));
        Offer offer = Mockito.mock(Offer.class);
        Mockito.when(offer.getPlace()).thenReturn("Krakow Komandosow 8");

        Boolean filteringResult = palceOfferFilterStrategySUT.meetCriteria(offer);

        assertThat(filteringResult).isTrue();
    }
}