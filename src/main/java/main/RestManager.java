package main;

import controller.OfferManager;
import model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Paweł Proc on 2016-12-03.
 *
 * Class is responsible for provide REST interface from backed site.
 *
 */

@RestController
public class RestManager {

    Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private OfferManager offerManager;

    @RequestMapping(value = "/offers", method = RequestMethod.POST)
    public Offer storeOffer(@RequestBody Offer offer) {
        return offerManager.store(offer);
    }

    @RequestMapping(value = "/offers/{id}", method = RequestMethod.GET)
    public Offer getOfferById(@PathVariable long id) {
        Offer offer = offerManager.getOffer(id);
        return offer;
    }

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public List<Offer> getOffers() {
        List<Offer> offers = offerManager.getOffers();
        return offers;
    }

}
