package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import com.cook4me.controller.filtering.strategies.OfferFilterStrategyCreator;
import com.cook4me.controller.filtering.strategies.concrete.PlaceOfferFilterStrategy;
import com.cook4me.model.FilterConfiguration;
import com.cook4me.model.Offer;
import org.mockito.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * Created by eadalac on 2017-02-03.
 */
public class FilterBankFactoryTest {

    @Test
    public void shouldCreateFilterBankForAllGivenConfigurations(){

        OfferFilterStrategyCreator offerFilterStrategyCreator = Mockito.mock(OfferFilterStrategyCreator.class);
        OfferFilterStrategy s1 = Mockito.mock(OfferFilterStrategy.class);
        OfferFilterStrategy s2 = Mockito.mock(OfferFilterStrategy.class);
        Mockito.when(offerFilterStrategyCreator.produceOfferFilterStrategy(Mockito.any())).thenReturn(s1, s2);
        FilterBankFactory filterBankFactory = new FilterBankFactory(offerFilterStrategyCreator);
        Set<FilterConfiguration> filterConfigurations = new HashSet<>();
        filterConfigurations.add(Mockito.mock(FilterConfiguration.class));
        filterConfigurations.add(Mockito.mock(FilterConfiguration.class));
        ArgumentCaptor<FilterConfiguration> argument = ArgumentCaptor.forClass(FilterConfiguration.class);

        FilterBank filterBank = filterBankFactory.produceFilterBank(filterConfigurations);

        Mockito.verify(offerFilterStrategyCreator, Mockito.times(filterConfigurations.size())).produceOfferFilterStrategy(argument.capture());
        assertThat(filterBank.getFilters()).hasSameSizeAs(filterConfigurations);
        assertThat(argument.getAllValues()).hasSameElementsAs(filterConfigurations);
    }

    @Test
    public void shouldCreateFilterBankForWIthEmptyConfigurations(){

        OfferFilterStrategyCreator offerFilterStrategyCreator = Mockito.mock(OfferFilterStrategyCreator.class);
        FilterBankFactory filterBankFactory = new FilterBankFactory(offerFilterStrategyCreator);
        MockitoAnnotations.initMocks(this);
        Set<FilterConfiguration> filterConfigurations = new HashSet<>();
        ArgumentCaptor<FilterConfiguration> argument = ArgumentCaptor.forClass(FilterConfiguration.class);

        FilterBank filterBank = filterBankFactory.produceFilterBank(filterConfigurations);

        Mockito.verify(offerFilterStrategyCreator, Mockito.times(filterConfigurations.size())).produceOfferFilterStrategy(argument.capture());
        assertThat(filterBank.getFilters()).hasSameSizeAs(filterConfigurations);
        assertThat(argument.getAllValues()).hasSameElementsAs(filterConfigurations);
    }

}