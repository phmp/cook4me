package com.cook4me.controller.filtering.strategies;

import com.cook4me.controller.filtering.NewInstanceCreator;
import com.cook4me.model.FilterConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class OfferFilterStrategyCreator {

    Logger logger = Logger.getLogger(getClass().toString());

    private List<OfferFilterStrategy> strategies;

    private NewInstanceCreator newInstanceCreator;

    @Autowired
    public OfferFilterStrategyCreator(List<OfferFilterStrategy> strategies, NewInstanceCreator newInstanceCreator) {
        this.strategies = strategies;
        this.newInstanceCreator = newInstanceCreator;
    }

    public OfferFilterStrategy produceOfferFilterStrategy(final FilterConfiguration filterConfiguration){
        final OfferFilterStrategy patternStrategy = findMatchingStrategyFromImplementations(filterConfiguration.getFilterStrategyName());
        final OfferFilterStrategy offerFilterStrategyReadyForUse = createReadyForUseStrategy(patternStrategy, filterConfiguration.getFilterArguments());
        return offerFilterStrategyReadyForUse;
    }

    private OfferFilterStrategy createReadyForUseStrategy(OfferFilterStrategy strategyTemplate, List<String> arguments) {
        final OfferFilterStrategy returnedOfferFilterStrategy = newInstanceCreator.getNewInstance(strategyTemplate);
        returnedOfferFilterStrategy.setConfigurationStrings(arguments);
        return returnedOfferFilterStrategy;
    }

    private OfferFilterStrategy findMatchingStrategyFromImplementations(String strategyName) {
        return strategies.stream()
                    .filter(s -> s.getType().equals(strategyName))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("OfferFilterStrategy " + strategyName + " implementation not found"));
    }

}
