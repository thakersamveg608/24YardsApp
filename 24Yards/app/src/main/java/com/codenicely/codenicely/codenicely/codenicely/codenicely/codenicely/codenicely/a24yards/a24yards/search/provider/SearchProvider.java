package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.SearchCallback;

import java.util.List;

/**
 * Created by vrihas on 25/8/17.
 */

public interface SearchProvider {
    void searchData(String property_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type, SearchCallback searchCallback);
}
