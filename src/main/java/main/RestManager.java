package main;

import model.Offer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

/**
 * Created by Paweł on 2016-12-03.
 */
@RestController
public class RestManager {

    Logger logger = Logger.getLogger("myLogger");
    private final AtomicLong counter = new AtomicLong();
    private List<Offer> offers = new ArrayList<>();

    @RequestMapping("/offers")
    public Offer offers(@RequestBody Offer offer) {
        offer.setId(counter.incrementAndGet());
        offers.add(offer);

        logger.log(INFO, "Offer successfully added");

        return offer;
    }
}
