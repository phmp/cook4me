package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import com.cook4me.model.Offer;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * Created by eadalac on 2017-02-04.
 */
public class FilterBankTest {

    @Test
    public void shouldUseEachStrategy(){
        OfferFilterStrategy firstStrategy = Mockito.mock(OfferFilterStrategy.class);
        OfferFilterStrategy secondStrategy = Mockito.mock(OfferFilterStrategy.class);
        FilterBank filterBank = new FilterBank();
        filterBank.add(firstStrategy);
        filterBank.add(secondStrategy);
        Offer offer = Mockito.mock(Offer.class);

        filterBank.meetCriteria(offer);

        Mockito.verify(firstStrategy, Mockito.times(1)).meetCriteria(offer);
        Mockito.verify(secondStrategy, Mockito.times(1)).meetCriteria(offer);
    }

    @Test
    public void shouldReturnFalseWhenAnyFilterIsNotFullfiled(){
        OfferFilterStrategy firstStrategy = Mockito.mock(OfferFilterStrategy.class);
        OfferFilterStrategy secondStrategy = Mockito.mock(OfferFilterStrategy.class);
        Mockito.when(firstStrategy.meetCriteria(Mockito.any())).thenReturn(true);
        Mockito.when(secondStrategy.meetCriteria(Mockito.any())).thenReturn(false);
        FilterBank filterBank = new FilterBank();
        filterBank.add(firstStrategy);
        filterBank.add(secondStrategy);
        Offer offer = Mockito.mock(Offer.class);

        Boolean result = filterBank.meetCriteria(offer);

        assertThat(result).isFalse();
        Mockito.verify(firstStrategy, Mockito.times(1)).meetCriteria(offer);
        Mockito.verify(secondStrategy, Mockito.times(1)).meetCriteria(offer);
    }

    @Test
    public void shouldReturnTrueWhenEachFilterIsFullfilled(){
        OfferFilterStrategy firstStrategy = Mockito.mock(OfferFilterStrategy.class);
        OfferFilterStrategy secondStrategy = Mockito.mock(OfferFilterStrategy.class);
        Mockito.when(firstStrategy.meetCriteria(Mockito.any())).thenReturn(true);
        Mockito.when(secondStrategy.meetCriteria(Mockito.any())).thenReturn(true);
        FilterBank filterBank = new FilterBank();
        filterBank.add(firstStrategy);
        filterBank.add(secondStrategy);
        Offer offer = Mockito.mock(Offer.class);

        Boolean result = filterBank.meetCriteria(offer);

        assertThat(result).isTrue();
        Mockito.verify(firstStrategy, Mockito.times(1)).meetCriteria(offer);
        Mockito.verify(secondStrategy, Mockito.times(1)).meetCriteria(offer);
    }

    @Test
    public void shouldReturnTrueWhenNoRegisteredStrategies(){
        FilterBank filterBank = new FilterBank();
        Offer offer = Mockito.mock(Offer.class);

        Boolean result = filterBank.meetCriteria(offer);

        assertThat(result).isTrue();
    }


}