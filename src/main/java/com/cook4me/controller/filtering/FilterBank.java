package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import com.cook4me.model.Offer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by eadalac on 2017-02-03.
 */
public class FilterBank {

    private final Set<OfferFilterStrategy> filters = new HashSet<>();

    boolean add(OfferFilterStrategy offerFilterStrategy){
        return filters.add(offerFilterStrategy);
    }

    public Set<OfferFilterStrategy> getFilters() {
        return filters;
    }

    public boolean meetCriteria(Offer offer){
        List<OfferFilterStrategy> notFullfiledFilters = filters.stream()
                .filter(f -> !f.meetCriteria(offer))
                .collect(Collectors.toList());
        return notFullfiledFilters.isEmpty();
    }

}
