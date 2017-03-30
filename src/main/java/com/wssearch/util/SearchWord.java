package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public enum SearchWord {

    AY("AY"),//案由
    AH("AH"),//案号
    FYCJ("FYCJ");//法院层级

    private String typeName;
    SearchWord(String typeName){
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
