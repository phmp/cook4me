package com.cook4me.model;

import java.util.List;

/**
 * Created by eadalac on 2017-02-03.
 */
public class FilterConfiguration {

    private final String filterStrategyName;
    private final List<String> filterArguments;

    public FilterConfiguration(String filterStrategyName, List<String> filterArguments) {
        this.filterStrategyName = filterStrategyName;
        this.filterArguments = filterArguments;
    }

    public String getFilterStrategyName() {
        return filterStrategyName;
    }

    public List<String> getFilterArguments() {
        return filterArguments;
    }
}
