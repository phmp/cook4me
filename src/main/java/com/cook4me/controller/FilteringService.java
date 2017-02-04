package com.cook4me.controller;

import com.cook4me.controller.filtering.FilterBank;
import com.cook4me.controller.filtering.FilterBankFactory;
import com.cook4me.model.FilterConfiguration;
import com.cook4me.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class FilteringService {

    FilterBankFactory filterBankFactory;

    @Autowired
    public FilteringService(FilterBankFactory filterBankFactory) {
        this.filterBankFactory = filterBankFactory;
    }

    public List<Offer> filterOffers(Set<FilterConfiguration> filterConfigurations, List<Offer> offers){
        FilterBank filterBank = filterBankFactory.produceFilterBank(filterConfigurations);

        List<Offer> filteredOffers  = offers.stream()
                .filter(offer -> filterBank.meetCriteria(offer))
                .collect(Collectors.toList());

        return filteredOffers;
    }
}
