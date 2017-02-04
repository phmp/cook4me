package com.cook4me.controller.filtering;

import com.cook4me.controller.filtering.strategies.OfferFilterStrategy;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by eadalac on 2017-02-03.
 */
public class NewInstanceCreatorTest {

    @Test
    void shouldCreateNewInstanceOfTheSameObject(){
        NewInstanceCreator newInstanceCreator = new NewInstanceCreator();
        OfferFilterStrategy givenInstance = Mockito.mock(OfferFilterStrategy.class);

        OfferFilterStrategy returnedInstance = newInstanceCreator.getNewInstance(givenInstance);

        assertThat(returnedInstance).isInstanceOf(OfferFilterStrategy.class);
        assertThat(returnedInstance).isNotSameAs(givenInstance);
    }


}