package com.cook4me.controller;

import com.cook4me.model.FilterConfiguration;
import com.cook4me.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class OfferService {

    OfferManager offerManager;
    FilteringService filteringService;

    @Autowired
    public OfferService(OfferManager offerManager, FilteringService filteringService) {
        this.offerManager = offerManager;
        this.filteringService = filteringService;
    }

    public Offer store(Offer offer){
        return offerManager.store(offer);
    }


    public Offer getOffer(Long id) {
        return offerManager.getOffer(id);
    }

    public List<Offer> getOffers() {
        return this.getFilteredOffers(Collections.emptySet());
    }

    public List<Offer> getFilteredOffers(Set<FilterConfiguration> filterConfigurations) {
        List<Offer> offerList = filteringService.filterOffers(filterConfigurations, offerManager.getOffers());
        return offerList;
    }
}
