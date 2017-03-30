package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public class Condition {

    private SearchWord searchWord;
    private String value;

    public Condition(SearchWord searchWord, String value) {
        this.searchWord = searchWord;
        this.value = value;
    }

    public SearchWord getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(SearchWord searchWord) {
        this.searchWord = searchWord;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
