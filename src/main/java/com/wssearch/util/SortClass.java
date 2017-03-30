package com.wssearch.util;

/**
 * Created by cristph on 2017/3/30.
 */
public enum SortClass {

    FYCJ("FYCJ"),//法院层级
    PJRQ("PJRQ"),//判决日期
    SPCX("SPCX");//审判程序

    private String typeName;
    SortClass(String typeName){
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
