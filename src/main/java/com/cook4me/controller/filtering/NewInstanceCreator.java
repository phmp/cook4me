package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import org.springframework.stereotype.Component;

/**
 * Created by eadalac on 2017-02-03.
 */
@Component
public class NewInstanceCreator {

    public OfferFilterStrategy getNewInstance(OfferFilterStrategy offerFilterStrategy){
        try {
            return offerFilterStrategy.getClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
