package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public class Sort {

    SortClass sortClass;
    SortType sortType;

    public Sort(SortClass sortClass, SortType sortType) {
        this.sortClass = sortClass;
        this.sortType = sortType;
    }

    public SortClass getSortClass() {
        return sortClass;
    }

    public void setSortClass(SortClass sortClass) {
        this.sortClass = sortClass;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
