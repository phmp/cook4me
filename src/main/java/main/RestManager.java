package main;

import controller.OfferManager;
import model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by Paweł on 2016-12-03.
 */
@RestController
public class RestManager {

    Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private OfferManager offerManager;


    @RequestMapping("/offers")
    public Offer offers(@RequestBody Offer offer) {
        return offerManager.store(offer);
    }

}
