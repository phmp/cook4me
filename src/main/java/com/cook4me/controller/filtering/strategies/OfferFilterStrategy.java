package com.cook4me.controller.filtering.strategies;

import com.cook4me.model.Offer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by eadalac on 2017-02-03.
 */
public interface OfferFilterStrategy {

    default String getType(){
            return this.getClass().getName();
    }

    void setConfigurationStrings(List<String> configurationStrings);

    boolean meetCriteria(Offer offer);
}
