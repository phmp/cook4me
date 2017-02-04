package com.cook4me.controller.filtering.strategies.concrete;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import com.cook4me.model.Offer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class PlaceOfferFilterStrategy implements OfferFilterStrategy {

    private List<String> configurationStrings;

    @Override
    public void setConfigurationStrings(List<String> configurationStrings) {
        this.configurationStrings = configurationStrings;
    }

    @Override
    public boolean meetCriteria(Offer offer) {
        List<String> fullfilledStrings = configurationStrings.stream()
                .filter(s -> offer.getPlace().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toList());
        return !fullfilledStrings.isEmpty();
    }
}
