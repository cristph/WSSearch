package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public enum SortType {

    DESC("DESC"),
    ASC("ASC");

    private String typeName;
    SortType(String typeName){
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
