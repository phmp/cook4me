package controller;

import model.Offer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by Paweł Proc on 2016-12-06.
 *
 * Class is responsible for handling all operation related with Offers.
 *
 */

@Component
public class OfferManager {

    Logger logger = Logger.getLogger(getClass().toString());
    private final AtomicLong counter = new AtomicLong();
    private Map<Long, Offer> offers = new HashMap<>();

    public Offer store(Offer offer){
        Long id = counter.incrementAndGet();
        offer.setId(id);
        offers.put(id,offer);
        logger.log(INFO, "Offer: " + offer.toString() + " successfully added.");
        return offer;
    }

    public Offer getOffer(long id) {
        return offers.get(id);
    }

    public List<Offer> getOffers() {
        List<Offer> offerList = new ArrayList(offers.values());
        return offerList;
    }
}
