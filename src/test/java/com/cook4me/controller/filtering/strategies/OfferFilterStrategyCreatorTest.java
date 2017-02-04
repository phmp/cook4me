package com.cook4me.controller.filtering.strategies;

        import com.cook4me.controller.filtering.NewInstanceCreator;
        import com.cook4me.controller.filtering.strategies.concrete.NameOfferFilterStrategy;
        import com.cook4me.controller.filtering.strategies.concrete.PlaceOfferFilterStrategy;
        import com.cook4me.model.FilterConfiguration;
        import org.mockito.Mockito;
        import org.testng.annotations.Test;

        import java.util.ArrayList;
        import java.util.List;

        import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by eadalac on 2017-02-03.
 */

public class OfferFilterStrategyCreatorTest {


    @Test
    public void shouldProduceNewInstanceOfOfferFilterStrategyWithProperImplementation() throws Exception {
        OfferFilterStrategy ofs1 = Mockito.mock(NameOfferFilterStrategy.class);
        OfferFilterStrategy ofs2 = Mockito.mock(PlaceOfferFilterStrategy.class);
        Mockito.when(ofs1.getType()).thenReturn("NameOfferFilterStrategy");
        Mockito.when(ofs2.getType()).thenReturn("PlaceOfferFilterStrategy");
        List<OfferFilterStrategy> strategies = new ArrayList<>();
        strategies.add(ofs1);
        strategies.add(ofs2);
        NewInstanceCreator newInstanceCreator = Mockito.mock(NewInstanceCreator.class);
        Mockito.when(newInstanceCreator.getNewInstance(Mockito.any())).thenReturn( Mockito.mock(PlaceOfferFilterStrategy.class));
        OfferFilterStrategyCreator offerFilterStrategyCreator = new OfferFilterStrategyCreator(strategies, newInstanceCreator);

        OfferFilterStrategy offerFilterStrategy = offerFilterStrategyCreator.produceOfferFilterStrategy(new FilterConfiguration("PlaceOfferFilterStrategy", Mockito.mock(ArrayList.class)));

        assertThat(offerFilterStrategy).isNotSameAs(ofs2);
        assertThat(offerFilterStrategy.getClass()).isEqualTo(ofs2.getClass());
    }

    @Test
    public void instanceOfOfferShouldBeConfigured() throws Exception {

        OfferFilterStrategy ofs1 = Mockito.mock(PlaceOfferFilterStrategy.class);
        Mockito.when(ofs1.getType()).thenReturn("PlaceOfferFilterStrategy");
        List<OfferFilterStrategy> strategies = new ArrayList<>();
        strategies.add(ofs1);
        NewInstanceCreator newInstanceCreator = Mockito.mock(NewInstanceCreator.class);
        OfferFilterStrategy newInstanceObjectMock = Mockito.mock(PlaceOfferFilterStrategy.class);
        Mockito.when(newInstanceCreator.getNewInstance(Mockito.any())).thenReturn(newInstanceObjectMock);
        List<String> configurationInput = new ArrayList<>();
        OfferFilterStrategyCreator offerFilterStrategyCreator = new OfferFilterStrategyCreator(strategies, newInstanceCreator);

        OfferFilterStrategy offerFilterStrategy = offerFilterStrategyCreator.produceOfferFilterStrategy(new FilterConfiguration("PlaceOfferFilterStrategy", configurationInput));

        Mockito.verify(newInstanceObjectMock, Mockito.times(1)).setConfigurationStrings(configurationInput);

    }


}