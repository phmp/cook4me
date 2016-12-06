package controller;

import model.Offer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Created by epawpro on 2016-12-06.
 */
@Component
public class OfferManager {

    Logger logger = Logger.getLogger(getClass().toString());
    private final AtomicLong counter = new AtomicLong();
    private List<Offer> offers = new ArrayList<>();

    public Offer store(Offer offer){
        offer.setId(counter.incrementAndGet());
        offers.add(offer);
        logger.log(INFO, "Offer: " + offer.toString() + " successfully added.");
        return offer;
    }
}
