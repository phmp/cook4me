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
public class NameOfferFilterStrategyTest {
    @Test
    public void shouldFilterWenSubstringNotExists(){
        NameOfferFilterStrategy nameOfferFilterStrategy = new NameOfferFilterStrategy();
        nameOfferFilterStrategy.setConfigurationStrings(Arrays.asList("Zupa", "schab", "ziemniaki"));
        Offer offer = Mockito.mock(Offer.class);
        Mockito.when(offer.getName()).thenReturn("Danie w 5 minut");

        Boolean filteringResult = nameOfferFilterStrategy.meetCriteria(offer);

        assertThat(filteringResult).isFalse();
    }

    @Test
    public void shouldNotFilterWenSubstringExists(){
        NameOfferFilterStrategy nameOfferFilterStrategySUT = new NameOfferFilterStrategy();
        nameOfferFilterStrategySUT.setConfigurationStrings(Arrays.asList("Zupa", "schab", "ziemniaki"));
        Offer offer = Mockito.mock(Offer.class);
        Mockito.when(offer.getName()).thenReturn("Ogórkowa, ziemniaki, seler");

        Boolean filteringResult = nameOfferFilterStrategySUT.meetCriteria(offer);

        assertThat(filteringResult).isTrue();
    }
}