package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public enum SearchWord {

    AY("ay"),//案由
    AH("ah"),//案号
    FYCJ("fycj");//法院层级

    private String typeName;
    SearchWord(String typeName){
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
