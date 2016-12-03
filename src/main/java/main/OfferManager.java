package main;

import model.Greeting;
import model.Offer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class OfferManager {

    private static final String template = "Hello, %s!";
    Logger logger = Logger.getLogger("myLogger");
    private final AtomicLong counter = new AtomicLong();
    private List<Offer> offers = new ArrayList<>();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
//
//    @RequestMapping("/offers")
//    public Offer offers(Offer offer){
//        offer.setId(counter.incrementAndGet());
//        offers.add(offer);
//
//        logger.log(INFO, "Offer succesfully added");
//
//        return offer;
//    }

}