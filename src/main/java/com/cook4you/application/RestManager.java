package com.cook4you.application;

import com.cook4you.controller.OfferManager;
import com.cook4you.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/offers")
    public Offer offers(@RequestBody Offer offer) {
        return offerManager.store(offer);
    }

}
