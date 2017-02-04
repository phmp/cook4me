package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import com.cook4me.controller.filtering.strategies.OfferFilterStrategyCreator;
import com.cook4me.model.FilterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class FilterBankFactory {


    OfferFilterStrategyCreator offerFilterStrategyCreator;

    @Autowired
    public FilterBankFactory(OfferFilterStrategyCreator offerFilterStrategyCreator) {
        this.offerFilterStrategyCreator = offerFilterStrategyCreator;
    }

    public FilterBank produceFilterBank(Set<FilterConfiguration> filterConfigurations) {
        FilterBank filterBank = new FilterBank();
        filterConfigurations.forEach((FilterConfiguration config) -> {
            OfferFilterStrategy configuredStrategy = offerFilterStrategyCreator.produceOfferFilterStrategy(config);
            filterBank.add(configuredStrategy);
        });
        return filterBank;
    }
}
